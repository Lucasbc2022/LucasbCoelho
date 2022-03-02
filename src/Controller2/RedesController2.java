package Controller2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Controller2.RedesController2;

public class RedesController2 {
	
	public RedesController2() {
		super();
	}
      public String os() {
    	 // Retorno do Sistema Operacional em execução; 
    	 String os = System.getProperty("os.name");
    	 String arch = System.getProperty("os.arch");
    	 String version = System.getProperty("os.version");
    	 return os + " - v."+ version +" - arch. "+ arch;
     }
      public void readProcess(String process2) {
     	 
     	 RedesController2 procController	= new RedesController2();
 			String os = procController.os();
     	 try {
     		 Process p = Runtime.getRuntime().exec(process2);
     		 InputStream fluxo = p.getInputStream();
     		 InputStreamReader leitor = new InputStreamReader(fluxo);
     		 BufferedReader buffer = new BufferedReader(leitor);
     		 String linha = buffer.readLine();
     		 while (linha != null) {
     			 System.out.println(linha);
     			 linha = buffer.readLine();
     			 }
     		 buffer.close();
     		 leitor.close();
     		 fluxo.close();
     	 } catch(IOException e) {
     		 e.printStackTrace();
     		
     	 }
      }

      public void callProcess(String process) {
     	 
     	 try {
     	 Runtime.getRuntime().exec(process);
     	 } catch(IOException e) {
     		String msgErro = e.getMessage();
     		if(msgErro.contains("740")) {
     			StringBuffer buffer = new StringBuffer();
     			buffer.append("cmd /c");
     			buffer.append(" ");
     			buffer.append(process);
     			try {
     				Runtime.getRuntime().exec(buffer.toString());
     			} catch(IOException e1) {
     				e1.printStackTrace();
     			}
     			
     		} else {
     			System.err.println(msgErro);
     		}
     	 }
     	 
      }
public void killProcess(String param) {
     //TASK KILL / PID
	 String cmdPid = "TASKKILL /PID";
     String cmdNome = "TASKKILL /IM";
     int pid = 0;
     StringBuffer buffer = new StringBuffer();
     
     try {
     pid = Integer.parseInt(param);
     buffer.append(cmdPid);
     buffer.append(" ");
     buffer.append(pid);
     
     } catch(NumberFormatException e) {
    	 
    	 //TASKKILL /IM nomedoprecesso.exe
    	 buffer.append(cmdNome);
    	 buffer.append(" ");
    	 buffer.append(param);
    	 
     }
     try {
     Runtime.getRuntime().exec(buffer.toString());
     }catch(IOException e) {
    	 e.printStackTrace();
     }
     callProcess(buffer.toString());
 }
/*public void killProcessPID(String param) {
    //TASK KILL / PID
	 String cmdPid = "TASKKILL /PID";
    int pid = 0;
    StringBuffer buffer = new StringBuffer();
    
    pid = Integer.parseInt(param);
    buffer.append(cmdPid);
    buffer.append(" ");
    buffer.append(pid);
    
    try {
    Runtime.getRuntime().exec(buffer.toString());
    }catch(IOException e) {
   	 e.printStackTrace();
    }
    callProcess(buffer.toString());
      
}
public void killProcessIM(String nome) { 
    String cmdNome = "TASKKILL /IM";
    
    StringBuffer buffer = new StringBuffer();
    
   	 //TASKKILL /IM nomedoprecesso.exe
   	 buffer.append(cmdNome);
   	 buffer.append(" ");
   	 buffer.append(nome);
   	 
    
    try {
    Runtime.getRuntime().exec(buffer.toString());
    }catch(IOException e) {
   	 e.printStackTrace();
    }
    callProcess(buffer.toString());
}  */
}
