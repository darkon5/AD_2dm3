package Primerito;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AccesoDomObjeto {
	
	Document document;
	
	
	
	
	private Document getDocument() {
	// TODO Auto-generated method stub
	return document;
}



	//independiente del archivo de XML
public void abrirXML_DOM(String ruta_archivo){
	
	DocumentBuilderFactory factory= null;
	DocumentBuilder builder = null;
	File fichero=null;
	try{
		fichero=new File(ruta_archivo);
		factory =  DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder(); 
		document=builder.parse(fichero);
		document.getDocumentElement().normalize();
	
	}catch(Exception e){
		e.printStackTrace();
	}
		
}	
	
public void guardarDOM_XML(String ruta_archivo){
	try{
	//aqui se crea un archivo por el nombre pasado por parametro
		File salida = new File(ruta_archivo);
		OutputFormat format = new OutputFormat(document);
		format.setIndenting(true);
		// escribimos el documen t donde eestga erl� arrvbjp�olfkwdfa
		XMLSerializer serializer = new XMLSerializer(new FileOutputStream(salida),format);
		serializer.serialize(document);
	}catch(Exception e){
	e.printStackTrace();			
}

}	
	public ArrayList<Libro> obtenerListaLibro(Document doc){
		ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
		Node hijo;
		Node raiz = doc.getFirstChild();
		NodeList hijos = raiz.getChildNodes();
		for (int i=0; i<hijos.getLength();i++){
			hijo = hijos.item(i);     
		if(hijo.getNodeType()==Node.ELEMENT_NODE){
			Libro libro = procesarLibroObjeto(hijo);
				arrayLibros.add(libro);
				
			}
		}
		return arrayLibros;
		
	}
	
	public Libro procesarLibroObjeto(Node hijo) {
	    Libro libro = new Libro();
	    libro.setPublicadoen(hijo.getAttributes().item(0).getNodeValue());
	    NodeList nietos = hijo.getChildNodes();
	    for(int i=0; i<nietos.getLength(); i++){
	      Node nieto = nietos.item(i);
	      if(nieto.getNodeType()==Node.ELEMENT_NODE){
	        if(nieto.getNodeName()=="Titulo"){
	        libro.setTitulo(nieto.getChildNodes().item(0).getNodeValue());    
	        }                                    
	        if(nieto.getNodeName()=="Autor"){
	          libro.setAutor(nieto.getChildNodes().item(0).getNodeValue());
	      }
	    }
	  }
	    return libro;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccesoDomObjeto accDOM = new AccesoDomObjeto();
		//pasamos del fichero XML al arbol DOM
		accDOM.abrirXML_DOM("LibrosXML.xml");
		//procesaremos el arbol
		ArrayList <Libro> libros = accDOM.obtenerListaLibro(accDOM.getDocument());
		for (int i=0; i<libros.size();i++){
			System.out.println("Publicado en: " + libros.get(i).getPublicadoen());
			System.out.println("Titulo: " + libros.get(i).getTitulo());
			System.out.println("Autor: " + libros.get(i).getAutor());
			System.out.println("_-------------------------------------------_");

			
			
			
			
			
			
		}
		//pasar del arbol DOM al fichero XML
	  //	accDOM.guardarDOM_XML("librosXML.xml");
		
	}

		
		
		
	}
	
	
	
	
	
	
	
	
	
		

