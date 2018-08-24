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
		DateValidator validator = new DateValidator();
		if (validator.validateInputDate(date)) {
			try {
				URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/a/" + date +"/?format=xml");
				DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
				Document document = docBuilder.parse(new InputSource(url.openStream()));
				document.getDocumentElement().normalize();
				System.out.println(document);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Date You entered is not valid. Proper date Input: YYYY-MM-DD");

		}

	}
}
