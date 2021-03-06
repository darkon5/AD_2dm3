package Primerito;

import java.io.*;
import java.util.Scanner;

public class AccesoFicheroCaracteres {
	static String path = "prueba.txt";
	
	//FUNCI�N PARA LEER UN FICHERO
	public void leer (String ruta_fichero){
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	System.out.println(line);
		    try{	
			br.close();
			}catch(IOException ioe){
				ioe.printStackTrace();}
		    }
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	//FUNCI�N PARA ESCRIBIR UN FICHERO SECUENCIAL
	public void escribir (String ruta_fichero){
		FileWriter fichero = null;
		PrintWriter pw = null;
		try{
			fichero = new FileWriter(ruta_fichero);
			pw = new PrintWriter(fichero);
			for (int i=0; i<10; i++){
				pw.println("Linea: " + (i+1));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				fichero.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void a�adir (String ruta_fichero){		
		try{FileWriter fichero = new FileWriter(ruta_fichero, true);
			PrintWriter pw = new PrintWriter(fichero);
			pw.println("extra");
			fichero.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}


	public void leer_aleatorio (String ruta_fichero){
		String palabra;
		RandomAccessFile fichero=null;
		long pos=0;
		Scanner tek=new Scanner (System.in);
		
		try{
			fichero = new RandomAccessFile(ruta_fichero,"r");
			System.out.println("El fichero tiene " + fichero.length() + " caracteres.");
			System.out.println("Introduce una posici�n:");
			palabra = tek.nextLine();
			pos = Integer.parseInt(palabra);
			while(fichero.length()<pos){
				System.out.println("Error! La posici�n indicada es mayor que el archivo.");
				System.out.println("Introduce una posici�n:");
				palabra = tek.nextLine();
				pos = Integer.parseInt(palabra);
			}

			fichero.seek(pos);
			System.out.println(fichero.readLine());	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				tek.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void leer_linea_aleatorio (String ruta_fichero){
		String palabra;
		RandomAccessFile fichero=null;
		long pos=0;
		int nlinea=0;
		boolean seguir=true;
		Scanner tek=new Scanner (System.in);
		
		try{
			fichero = new RandomAccessFile(ruta_fichero,"r");
			System.out.println("El fichero tiene " + fichero.length() + " caracteres.");
			
			while(seguir){
		
				System.out.println("Introduce una posici�n:");
				palabra = tek.nextLine();
				pos = Integer.parseInt(palabra);
				while(pos>9){
					pos = pos-9;
					nlinea++;
				}

				pos=nlinea*10;
				
					if(fichero.length()<pos){
						//System.out.println("Error! La posici�n indicada es mayor que el archivo.");
					}else{
						seguir=false;
					}
				
			}
			
			while(fichero.length()<pos){
				System.out.println("Error! La posici�n indicada es mayor que el archivo.");
				System.out.println("Introduce una posici�n:");
				palabra = tek.nextLine();
				pos = Integer.parseInt(palabra);
			}

			fichero.seek(pos);
			System.out.println(fichero.readLine());	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				tek.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] Args){
		AccesoFicheroCaracteres afc = new AccesoFicheroCaracteres();
		//afc.escribir(path);
		//afc.a�adir(path);
		//afc.leer(path);
		//afc.leer_aleatorio(path);
		afc.leer_linea_aleatorio(path);
	}

}
