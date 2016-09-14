package Primerito;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class AccesoDOM {
	
	public void abrirXML_DOM (String path){
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		File fichero = null;
		
		try{
			fichero = new File(path);
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		AccesoDOM acDOM = new AccesoDOM();
		acDOM.abrirXML_DOM("LibrosXML.xml");
	}

}
