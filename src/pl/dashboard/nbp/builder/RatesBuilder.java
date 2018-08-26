package pl.dashboard.nbp.builder;

import java.util.List;

import org.w3c.dom.Element;

import pl.dashboard.nbp.util.Consts;
import pl.dashboard.nbp.util.Currency;

public class RatesBuilder {


	public Currency buildCurrency(Element element) {
		Currency currencyVar = new Currency();
		currencyVar.setBid(element.getElementsByTagName(Consts.BID).item(0).getTextContent());
		currencyVar.setAsk(element.getElementsByTagName(Consts.ASK).item(0).getTextContent());
		currencyVar.setCode(element.getElementsByTagName(Consts.CODE).item(0).getTextContent());
		return currencyVar;
	}

	public StringBuilder buildRatesTable(String date, List<Currency>currencyVar) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Consts.TableBuilders.DATE + date + Consts.TableBuilders.NEW_LINE +  Consts.TableBuilders.TITLE
		+ Consts.TableBuilders.NEW_LINE);
		currencyVar.forEach(element ->{
			stringBuilder.append(element.getCode() + " = " + element.getBid() + "; " + element.getAsk()+ Consts.TableBuilders.NEW_LINE);
		});
		return stringBuilder;
		
	}
}