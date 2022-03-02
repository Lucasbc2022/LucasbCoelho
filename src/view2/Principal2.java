package view2;

import javax.swing.JOptionPane;

import Controller2.RedesController2;

public class Principal2 {
	
	public static void main(String[] args) {
		int option;
		do {
			option = Integer.parseInt(JOptionPane.showInputDialog(
			"1 - Identificador de Sistema Operacional\n"+
			"2 - Lista de Processos\n"+
			"3 - Chamada de aplicação\n"+
			"4 - Matando processo \n"+
	
			"9 - Finalize"));
			RedesController2 procController2 = new RedesController2();
			String os = procController2.os();
		switch(option) {
		
		case 1:System.out.println(os); break;
		
		case 2:String process = "TASKLIST /FO TABLE";procController2.readProcess(process);
		break;
		
		case 3:String process2 = "C:\\Windows\\write.exe"; procController2.callProcess(process2); 
		break;
		
		case 4:String param = "wordpad.exe"; 
		procController2.killProcess(param);
		break;
		
		
		case 9: JOptionPane.showMessageDialog(null, "Encerrando.");break;

		default: JOptionPane.showMessageDialog(null, "Codigo invalido tente novamente");break;
		}
		}while(option != 9);

		
		
		
		}
	}


//String param = "cmd.exe";
	//    procController2.killProcess(param)

