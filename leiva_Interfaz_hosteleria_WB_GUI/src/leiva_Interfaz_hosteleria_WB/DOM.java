package leiva_Interfaz_hosteleria_WB;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOM {

	public DOM() {

	}

	public Document initDOM(File fichero) {
		org.w3c.dom.Document doc = null;
		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fichero);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return doc;
	}

	 public ArrayList<ArrayList<String>> root(Document doc) {
		 
	        ArrayList<ArrayList<String>> Lreservas = new ArrayList<>();

	        doc.getDocumentElement();

	        NodeList nList = doc.getElementsByTagName("reserva");
	        System.out.println("Número de reservas: " + nList.getLength());

	        for (int i = 0; i < nList.getLength(); i++) {
	            Node nNode = nList.item(i);
	            Lreservas.add(getElement(nNode));
	        }

	        return Lreservas;
	    }

	public ArrayList<String> getElement(Node nNode) {
		ArrayList<String> reserva = new ArrayList<String>();
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			org.w3c.dom.Element eElement = (org.w3c.dom.Element) nNode;

			if (((Node) eElement).hasChildNodes()) {
				NodeList nl = nNode.getChildNodes();
				for (int j = 0; j < nl.getLength(); j++) {
					Node nd = nl.item(j);
					if (!nd.getTextContent().isBlank()) {
						reserva.add(nd.getNodeName()+":"+nd.getTextContent());
						// System.out.print(nd.getNodeName().trim()+":"+nd.getTextContent()+"\n");
					}
				}
				
			}
		}

		return reserva;

	}
	

	public Document initWriteDOM() {

		Document doc = null;
		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return doc;

	}

	public void rootWrite(Document doc,ArrayList<ArrayList<String>> nReservas) {

		org.w3c.dom.Element eRaiz = doc.createElement("reservas");
		if(nReservas.size()==1) {
		doc.appendChild(eRaiz);
		}
		
		for(int i = 0; i<nReservas.size();i++) {
		
		org.w3c.dom.Element e =	writeElement(doc,nReservas.get(i));
		eRaiz.appendChild(e);
		}
	}

	public org.w3c.dom.Element writeElement(Document doc,ArrayList<String> nReservas) {
		
		 org.w3c.dom.Element reserva = doc.createElement("reserva");
		 
			 for(String atributo: nReservas) {
				 String[] resultado = atributo.split(":");
				  org.w3c.dom.Element enombre = doc.createElement(resultado[0]);
				  enombre.appendChild(doc.createTextNode(resultado[1]));
				  reserva.appendChild(enombre);
				 
			 }
			 
			 return reserva;
	}
	
	public void createXML(Document doc) {
		
		try {
			 TransformerFactory transformerFactory = TransformerFactory.newInstance();
			  Transformer transformer = transformerFactory.newTransformer();
			  DOMSource source = new DOMSource(doc);
			  StreamResult result = new StreamResult(new File("ejercicio3.xml"));
			
			  transformer.transform(source, result);
			  
			}catch (Exception e) {
				// TODO: handle exception
			}
		
	}

}
