package pl.dashboard.nbp;


import pl.dashboard.nbp.NbpInput.GetService;

public class MainClass {

	public static void main(String[] args) {
		GetService service = new GetService();
		service.getXmlFile("2013-12-12");
	}

}
