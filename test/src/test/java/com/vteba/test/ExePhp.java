package com.vteba.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class ExePhp {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
    	ExePhp test = new ExePhp();
        //String r = test.execPHP("E:/dev/project/workspace/JavaCallphp/test.php", "id=123");
        //System.out.println(r);
        try {
        	BufferedReader input = null;
        	
        	String[] cmdarray = {"cmd.exe", "/c dir", "c:/"};
			Process process = Runtime.getRuntime().exec(cmdarray);
			StringBuilder output = new StringBuilder();
			String line;
			input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = input.readLine()) != null) {
                output.append(line+"\n");
                process.destroy();
            }
            System.out.println(line);
            if(line == null){
                process.destroy();
            }
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    public String execPHP(String scriptName, String param) {
        StringBuilder output = new StringBuilder();
        BufferedReader input = null;
        String phpPath = "E:/wnmp/php/php.exe";
        try {
            String line;
            Process p = Runtime.getRuntime().exec(phpPath + " " +scriptName + " " + param);
            input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                output.append(line+"\n");
                p.destroy();
            }
             
            if(line == null){
                p.destroy();
            }
        } catch (Exception err) {
            err.printStackTrace();
        }finally{
            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return output.toString();
    }
 
}
