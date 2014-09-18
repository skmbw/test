package com.vteba.test;

import java.io.InputStream;

import com.thoughtworks.xstream.XStream;


public class XstreamTest {
    public static void main(String[] aa) {
        XStream xstream =  new XStream();
        xstream.fromXML((InputStream)null);
    }
}
