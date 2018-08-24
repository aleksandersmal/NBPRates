package pl.dashboard.nbp.NbpInput;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GetService {

	public void getXmlFile(String date) {
		try {
			URL url = new URL("http://www.nbp.pl/kursy/xml/lastA.xml" + date);
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document document = docBuilder.parse(new InputSource(url.openStream()));
			document.getDocumentElement().normalize();
			System.out.println(document);
			System.out.println("Root element :" + document.getDocumentElement().getNodeName());
			NodeList nList = document.getElementsByTagName("");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
