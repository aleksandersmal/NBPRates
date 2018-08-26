package pl.dashboard.nbp.input;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import pl.dashboard.nbp.builder.RatesBuilder;
import pl.dashboard.nbp.exceptions.TooMuchArgsException;
import pl.dashboard.nbp.util.Consts;
import pl.dashboard.nbp.util.Currency;

public class NbpService {

	List<String> currencyCodeList = Arrays.asList(Consts.Currencies.EUR, Consts.Currencies.CHF, Consts.Currencies.USD,
			Consts.Currencies.GBP);

	
	public void getTable(String[] args) {
		Validator validator = new Validator();
		try {
			validator.validateArgsTable(args);
			if (validator.validateInputDate(args[0])) {
				Document document = getXmlFile(args[0]);
				buildAndDisplayTable(document, args[0]);
			}
		} catch (TooMuchArgsException e) {
			System.out.println(Consts.TOO_MUCH_ARGS + " " + e.getAmount());
		} catch (Exception e ) {
			System.out.println(Consts.DOWNLOAD_NBP_ERROR);

		}
	}

	private Document getXmlFile(String date) {
		try {
			URL url = new URL(Consts.TABLE_URL + date + Consts.XML_FORMAT);
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document document = docBuilder.parse(new InputSource(url.openStream()));
			document.getDocumentElement().normalize();
			return document;
		}catch(FileNotFoundException e){
			System.out.println( Consts.FILE_NOT_FOUND);
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	private void buildAndDisplayTable(Document document, String date) {
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		RatesBuilder ratesBuilder = new RatesBuilder();
		NodeList nList = document.getElementsByTagName("Rate");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			if (currencyCodeList.contains(eElement.getElementsByTagName("Code").item(0).getTextContent()))
				currencyList.add(ratesBuilder.buildCurrency(eElement));
		}
		System.out.println(ratesBuilder.buildRatesTable(date, currencyList));
	}
}
