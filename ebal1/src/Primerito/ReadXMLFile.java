package Primerito;
import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Result;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.annotation.XmlAttribute;


public class ReadXMLFile {
	


   public static void main(String argv[]) {

    try {

	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	DefaultHandler handler = new DefaultHandler() {

	boolean bTitulo = false;
	boolean bAutor = false;
	boolean bISBN = false;
	boolean bNumeroEj = false;
	boolean bEditorial = false;
	boolean bNumPag = false;
	boolean bA�o = false;

	public void startElement(String uri, String localName,String qName,
                Attributes attributes) throws SAXException {

		//System.out.println("Start Element :" + qName);

		if (qName.equalsIgnoreCase("TITULO")) {
			bTitulo = true;
		}

		if (qName.equalsIgnoreCase("AUTOR")) {
			bAutor = true;
		}

		if (qName.equalsIgnoreCase("ISBN")) {
			bISBN = true;
		}

		if (qName.equalsIgnoreCase("NumeroEj")) {
			bNumeroEj = true;
		}
		
		if (qName.equalsIgnoreCase("Editorial")) {
			bEditorial = true;
		}
		
		if (qName.equalsIgnoreCase("NumPag")) {
			bNumPag = true;
		}
		
		if (qName.equalsIgnoreCase("A�o")) {
			bA�o = true;
		}
		

	}

	public void endElement(String uri, String localName,
		String qName) throws SAXException {

		//System.out.println("End Element :" + qName);

	}

	public void characters(char ch[], int start, int length) throws SAXException {

		if (bTitulo) {
			System.out.println("Titulo: " + new String(ch, start, length));
			bTitulo = false;
		}

		if (bAutor) {
			System.out.println("Autor: " + new String(ch, start, length));
			bAutor = false;
		}

		if (bISBN) {
			System.out.println("ISBN: " + new String(ch, start, length));
			bISBN = false;
		}

		if (bNumeroEj) {
			System.out.println("Ejemplar numero: " + new String(ch, start, length));
			bNumeroEj = false;
		}

		if (bEditorial) {
			System.out.println("Editorial: " + new String(ch, start, length));
			bEditorial = false;
		}

		if (bNumPag) {
			System.out.println("NumPag : " + new String(ch, start, length));
			bNumPag = false;
		}

		if (bA�o) {
			System.out.println("A�o : " + new String(ch, start, length));
			bA�o = false;
		}

	}

     };

       saxParser.parse("libros.xml", handler);
       

     } catch (Exception e) {
       e.printStackTrace();
     }

   }

}