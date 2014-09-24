package com.vteba.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class Cmd{

	public void execCommand(String[] arstringCommand) {
		for (int i = 0; i < arstringCommand.length; i++) {
			System.out.print(arstringCommand[i] + " ");
		}
		try {
			Runtime.getRuntime().exec(arstringCommand);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void execCommand(String arstringCommand) {
		try {
			Runtime.getRuntime().exec(arstringCommand);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//List<String> cmds = new ArrayList<String>(); 
//	cmds.add("sh"); 
//	cmds.add("-c"); 
//	cmds.add("ps -ef | grep -v grep"); 
//	ProcessBuilder=new ProcessBuilder(cmds); 
//	Process p = pb.start();
	
	
	public String execmd(String arstringCommand) {
		String line;
		StringBuilder output = new StringBuilder();
		try {
			BufferedReader input = null;
			Process process = Runtime.getRuntime().exec(arstringCommand);
			input = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
			
            while ((line = input.readLine()) != null) {
                output.append(line+"\n");
                process.destroy();
            }
            //System.out.println(line);
            if(line == null){
                process.destroy();
            }
            
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return output.toString();
	}
	
	public void cmd(){
		//打开记算器
		String[] arstringCommand = new String[] {
				"cmd ", 
				"/k",
				//"start", // cmd Shell命令
				"calc"
		};
		//execCommand(arstringCommand);
		//打开记事本
		String cmd = "cmd /k notepad";
		//execCommand(cmd);
		String result = null;
		cmd = "cmd /k start dir";
		result = execmd(cmd);
		System.out.println(result);
		
		cmd = "cmd /c dir";
		result = execmd(cmd);
		System.out.println(result);
	}
	
	public static void main(String[] args){
		new Cmd().cmd();
	}
}
