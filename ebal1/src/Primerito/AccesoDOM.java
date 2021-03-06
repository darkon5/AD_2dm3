package Primerito;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class AccesoDOM {
	
	Document document;
	
	public Document getDocument(){
		return document;
	}
	
	public void abrirXML_DOM (String path){
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		File fichero = null;
		
		try{
			fichero = new File(path);
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document=builder.parse(fichero);
			document= getDocument();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void recorrer_DOM (Document doc){
		Node raiz = doc.getFirstChild();
		Node hijo;
		NodeList hijos = raiz.getChildNodes();
		
		for(int i=0; i<hijos.getLength();i++){
			hijo=hijos.item(i);
			if (hijo.getNodeType()==Node.ELEMENT_NODE){
				procesarHijosyMostrar(hijo);
			}
		}
		
	}
	
	public void procesarHijosyMostrar(Node hijo){
		String datos[] = new String[4];
		datos[0] = hijo.getAttributes().item(0).getNodeValue();
		//System.out.println("Publicado en: " + datos);
		NodeList nietos = hijo.getChildNodes();
		int contador=1;
		for (int i=0;i<nietos.getLength();i++){
			Node nieto=nietos.item(i);
			if (nieto.getNodeType()==Node.ELEMENT_NODE){
				if (nieto.getNodeType()==0){
					datos[3]=nieto.getChildNodes().item(0).getNodeValue();
				}
					datos[contador]=nieto.getChildNodes().item(0).getNodeValue();
					contador++;
			}
		}

		System.out.println("Publicado en: " + datos[0]);
		System.out.println(": " + datos[1]);
		System.out.println(": " + datos[2]);
		System.out.println("----------------");
	}
	
	public void a�adirDOM (String autor, String titulo, String a�o){
		try{
			Node nTitulo = document.createElement("Titulo");
			Node nTituloText = document.createTextNode(titulo);
			nTitulo.appendChild(nTituloText);
			Node nAutor = document.createElement("Autor");
			Node nAutorText = document.createTextNode(autor);
			nAutor.appendChild(nAutorText);
			Node nLibro = document.createElement("Libro");
			((Element)nLibro).setAttribute("publicado_en", a�o);
			nLibro.appendChild(nTitulo);
			nLibro.appendChild(nAutor);
			
			Node raiz = document.getFirstChild();
			raiz.appendChild(nLibro);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void guardarDOM_XML(String ruta_archivo){
		try{
			File salida = new File(ruta_archivo);
			OutputFormat format = new OutputFormat(document);
			format.setIndenting(true);
			XMLSerializer serializer = new XMLSerializer(new FileOutputStream(salida),format);
			serializer.serialize(document);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		AccesoDOM acDOM = new AccesoDOM();
		acDOM.abrirXML_DOM("LibrosXML.xml");
		acDOM.recorrer_DOM(acDOM.getDocument());
	}

}
