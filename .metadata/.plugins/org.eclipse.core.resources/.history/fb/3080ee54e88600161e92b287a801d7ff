package Primerito;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class AccesoDomObjeto {
	
	Document document;
	
	
	
	
	private Document getDocument() {
	// TODO Auto-generated method stub
	return document;
}


	public void añadirlibro(ArrayList<Libro> arrayLibros, String Año, String Titulo, String Autor){
	    Libro libronew = new Libro();
	    libronew.setPublicadoen(Año);
	    libronew.setAutor(Autor);
	    libronew.setTitulo(Titulo);
	    arrayLibros.add(libronew);
	  }

	  public void mostrarArray(ArrayList<Libro>arrayLibros){
	    for (int i=0; i<arrayLibros.size();i++){
	      System.out.println("Publicado en: " + arrayLibros.get(i).getPublicadoen());
	      System.out.println("Titulo: " + arrayLibros.get(i).getTitulo());
	      System.out.println("Autor: " + arrayLibros.get(i).getAutor());
	      System.out.println("--------------------------------------------" );
	      
	    }
	  }
	  
	  public void modificarLibro(ArrayList<Libro> arrayLibros,String Titulo, String AñoNuevo){
	    for (int i=0; i<arrayLibros.size();i++){
	      if(arrayLibros.get(i).getTitulo().equals(Titulo)){
	        arrayLibros.get(i).setPublicadoen(AñoNuevo);
	      }
	    }
	  }

	  public void eliminarLibro(ArrayList<Libro> arrayLibros,String Titulo){
	    for (int i=0; i<arrayLibros.size();i++){
	      if(arrayLibros.get(i).getTitulo().equals(Titulo)){
	        arrayLibros.remove(i);
	      }
	    }
	  }
	  
	  //public void deArray_DOM

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
		// escribimos el documen t donde eestga erlñ arrvbjpàolfkwdfa
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
	    //PAsamos del fichero xml al arbol DOM
	    accDOM.abrirXML_DOM("LibrosXML.xml");
	    //procesaremos el arbol
	    ArrayList<Libro> libros= accDOM.obtenerListaLibro(accDOM.getDocument());
	    /*
	    for (int i=0; i<libros.size();i++){
	      System.out.println("Publicado en: " + libros.get(i).getPublicadoEn());
	      System.out.println("Titulo: " + libros.get(i).getTitulo());
	      System.out.println("Autor: " + libros.get(i).getAutor());
	      System.out.println("--------------------------------------------" );
	      
	    }*/
	    //AÑADIR
	    accDOM.añadirlibro(libros, "2016", "El pepe olvidado: Harambe", "Internetz");
	    //MODIFICAR
	    //accDOM.modificarLibro(libros, "Mis memorias","2020");
	    //BORRAR
	    //accDOM.eliminarLibro(libros, "El Capote");
	    
	    accDOM.mostrarArray(libros);
	    
	    //pasar del arbol DOM al fichero XML
	    //accDOM.guardarDOM_XML("LibrosXML.xml");
	  }

		//pasar del arbol DOM al fichero XML
	  //	accDOM.guardarDOM_XML("librosXML.xml");
		
	}
	
	
	
	
	
	
	
	
	
	
		

