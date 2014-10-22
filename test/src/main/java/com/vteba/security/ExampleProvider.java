//package com.vteba.security;
//
//import java.io.ByteArrayOutputStream;
//import java.lang.reflect.Constructor;
//import java.security.InvalidKeyException;
//import java.security.Key;
//import java.security.MessageDigestSpi;
//import java.security.Provider;
//import java.security.SecureRandom;
//
//import javax.crypto.Cipher;
//import javax.crypto.CipherSpi;
//import javax.crypto.SecretKey;
//
///**
// * Example provider that demonstrates some of the new API features.
// *
// *  . implement multiple different algorithms in a single class.
// *    Previously each algorithm needed to be implemented in a separate class
// *    (e.g. one for MD5, one for SHA-1, etc.)
// *
// *  . multiple concurrent instances of the provider frontend class each
// *    associated with a different backend.
// *
// *  . it uses "unextractable" keys and lets the framework know which key
// *    objects it can and cannot support
// *
// * Note that this is only a simple example provider designed to demonstrate
// * several of the new features.  It is not explicitly designed for efficiency.
// */
//public final class ExampleProvider extends Provider {
//
//    // reference to the crypto backend that implements all the algorithms
//    final CryptoBackend cryptoBackend;
//
//    public ExampleProvider(String name, CryptoBackend cryptoBackend) {
//        super(name, 1.0, "JCA/JCE provider for " + name);
//        this.cryptoBackend = cryptoBackend;
//        // register the algorithms we support (MD5, SHA1, DES, and AES)
//        putServiceDescription(new MyServiceDescription
//            (this, "MessageDigest", "MD5", "com.foo.ExampleProvider$MyMessageDigest"));
//        putServiceDescription(new MyServiceDescription
//            (this, "MessageDigest", "SHA1", "com.foo.ExampleProvider$MyMessageDigest"));
//        putServiceDescription(new MyCipherServiceDescription
//            (this, "Cipher", "DES", "com.foo.ExampleProvider$MyCipher"));
//        putServiceDescription(new MyCipherServiceDescription
//            (this, "Cipher", "AES", "com.foo.ExampleProvider$MyCipher"));
//    }
//
//    // the API of our fictitious crypto backend
//    static abstract class CryptoBackend {
//        abstract byte[] digest(String algorithm, byte[] data);
//        abstract byte[] encrypt(String algorithm, KeyHandle key, byte[] data);
//        abstract byte[] decrypt(String algorithm, KeyHandle key, byte[] data);
//        abstract KeyHandle createKey(String algorithm, byte[] keyData);
//    }
//
//    // the shell of the representation the crypto backend uses for keys
//    private static final class KeyHandle {
//        // fill in code
//    }
//
//    // we have our own ServiceDescription implementation that overrides newInstance()
//    // that calls the (Provider, String) constructor instead of the no-args constructor
//    private static class MyServiceDescription extends ServiceDescription {
//
//        private static final Class[] paramTypes = {Provider.class, String.class};
//
//        MyServiceDescription(Provider provider, String type, String algorithm,
//                String className) {
//            super(provider, type, algorithm, className, null, null);
//        }
//
//        public Object newInstance(Object param) throws Exception {
//            // get the Class object for the implementation class
//            Class clazz;
//            Provider provider = getProvider();
//            ClassLoader loader = provider.getClass().getClassLoader();
//            if (loader == null) {
//                clazz = Class.forName(getClassName());
//            } else {
//                clazz = loader.loadClass(getClassName());
//            }
//            // fetch the (Provider, String) constructor
//            Constructor cons = clazz.getConstructor(paramTypes);
//            // invoke constructor and return the SPI object
//            Object obj = cons.newInstance(new Object[] {provider, getAlgorithm()});
//            return obj;
//        }
//    }
//
//    // custom ServiceDescription class for Cipher objects. See supportsParameter() below
//    private static class MyCipherServiceDescription extends MyServiceDescription {
//        MyCipherServiceDescription(Provider provider, String type, String algorithm,
//                String className) {
//            super(provider, type, algorithm, className);
//        }
//        // we override supportsParameter() to let the framework know which
//        // keys we can support. We support instances of MySecretKey, if they
//        // are stored in our provider backend, plus SecretKeys with a RAW encoding.
//        public boolean supportsParameter(Object obj) {
//            if (obj instanceof SecretKey == false) {
//                return false;
//            }
//            SecretKey key = (SecretKey)obj;
//            if (key.getAlgorithm().equals(getAlgorithm()) == false) {
//                return false;
//            }
//            if (key instanceof MySecretKey) {
//                MySecretKey myKey = (MySecretKey)key;
//                return myKey.provider == getProvider();
//            } else {
//                return "RAW".equals(key.getFormat());
//            }
//        }
//    }
//
//    // our generic MessageDigest implementation. It implements all digest
//    // algorithms in a single class. We only implement the bare minimum
//    // of MessageDigestSpi methods
//    private static final class MyMessageDigest extends MessageDigestSpi {
//        private final ExampleProvider provider;
//        private final String algorithm;
//        private ByteArrayOutputStream buffer;
//        MyMessageDigest(Provider provider, String algorithm) {
//            super();
//            this.provider = (ExampleProvider)provider;
//            this.algorithm = algorithm;
//            engineReset();
//        }
//        protected void engineReset() {
//            buffer = new ByteArrayOutputStream();
//        }
//        protected void engineUpdate(byte b) {
//            buffer.write(b);
//        }
//        protected void engineUpdate(byte[] b, int ofs, int len) {
//            buffer.write(b, ofs, len);
//        }
//        protected byte[] engineDigest() {
//            byte[] data = buffer.toByteArray();
//            byte[] digest = provider.cryptoBackend.digest(algorithm, data);
//            engineReset();
//            return digest;
//        }
//    }
//
//    // our generic Cipher implementation, only partially complete. It implements
//    // all cipher algorithms in a single class. We implement only as many of the
//    // CipherSpi methods as required to show how it could work
//    private static abstract class MyCipher extends CipherSpi {
//        private final ExampleProvider provider;
//        private final String algorithm;
//        private int opmode;
//        private MySecretKey myKey;
//        private ByteArrayOutputStream buffer;
//        MyCipher(Provider provider, String algorithm) {
//            super();
//            this.provider = (ExampleProvider)provider;
//            this.algorithm = algorithm;
//        }
//        protected void engineInit(int opmode, Key key, SecureRandom random)
//                throws InvalidKeyException {
//            this.opmode = opmode;
//            myKey = MySecretKey.getKey(provider, algorithm, key);
//            if (myKey == null) {
//                throw new InvalidKeyException();
//            }
//            buffer = new ByteArrayOutputStream();
//        }
//        protected byte[] engineUpdate(byte[] b, int ofs, int len) {
//            buffer.write(b, ofs, len);
//            return new byte[0];
//        }
//        protected int engineUpdate(byte[] b, int ofs, int len, byte[] out, int outOfs) {
//            buffer.write(b, ofs, len);
//            return 0;
//        }
//        protected byte[] engineDoFinal(byte[] b, int ofs, int len) {
//            buffer.write(b, ofs, len);
//            byte[] in = buffer.toByteArray();
//            byte[] out;
//            if (opmode == Cipher.ENCRYPT_MODE) {
//                out = provider.cryptoBackend.encrypt(algorithm, myKey.handle, in);
//            } else {
//                out = provider.cryptoBackend.decrypt(algorithm, myKey.handle, in);
//            }
//            buffer = new ByteArrayOutputStream();
//            return out;
//        }
//        // code for remaining CipherSpi methods goes here
//    }
//
//    // our SecretKey implementation. All our keys are stored in our crypto
//    // backend, we only have an opaque handle available. There is no
//    // encoded form of these keys.
//    private static final class MySecretKey implements SecretKey {
//
//        final String algorithm;
//        final Provider provider;
//        final KeyHandle handle;
//
//        MySecretKey(Provider provider, String algorithm, KeyHandle handle) {
//            super();
//            this.provider = provider;
//            this.algorithm = algorithm;
//            this.handle = handle;
//        }
//        public String getAlgorithm() {
//            return algorithm;
//        }
//        public String getFormat() {
//            return null; // this key has no encoded form
//        }
//        public byte[] getEncoded() {
//            return null; // this key has no encoded form
//        }
//        // Convert the given key to a key of the specified provider, if possible
//        static MySecretKey getKey(ExampleProvider provider, String algorithm, Key key) {
//            if (key instanceof SecretKey == false) {
//                return null;
//            }
//            // algorithm name must match
//            if (!key.getAlgorithm().equals(algorithm)) {
//                return null;
//            }
//            // if key is already an instance of MySecretKey and is stored
//            // on this provider, return it right away
//            if (key instanceof MySecretKey) {
//                MySecretKey myKey = (MySecretKey)key;
//                if (myKey.provider == provider) {
//                    return myKey;
//                }
//            }
//            // otherwise, if the input key has a RAW encoding, convert it
//            if (!"RAW".equals(key.getFormat())) {
//                return null;
//            }
//            byte[] encoded = key.getEncoded();
//            KeyHandle handle = provider.cryptoBackend.createKey(algorithm, encoded);
//            return new MySecretKey(provider, algorithm, handle);
//        }
//    }
//}
