package Primerito;

import java.io.*;

public class BinarioLeerGuardar {
	
	static boolean silence = false;
	
	public static byte[] leer_binario(String path){

		File file = new File(path);
		byte[] datuak = new byte[(int) file.length()];
		
		try{
			FileInputStream fileinput = new FileInputStream(path);
			BufferedInputStream bufferedinput = new BufferedInputStream(fileinput);
			
			bufferedinput.read(datuak);
			bufferedinput.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return datuak;
	}
	
	public static void guardar_binario(byte[] datuak, String path){
		
		try{	
			FileOutputStream fileoutput = new FileOutputStream(path);
			BufferedOutputStream bufferedoutput = new BufferedOutputStream(fileoutput);
			
			bufferedoutput.write(datuak);
			bufferedoutput.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void copiar_binario(String source, String destination){
		
		byte[] datuak = leer_binario(source);
		guardar_binario(datuak, destination);
			
		if(!silence){System.out.println("Se ha intentado copiar ~ " + source + " -> " + destination);}
			
	}
	
	public static void main(String[] Args){
		
		//silence=true

		copiar_binario("pep.bin","pep.jpeg");
		
	}

}
