package pl.dashboard.nbp;


import pl.dashboard.nbp.NbpInput.GetService;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("test");
		GetService service = new GetService();
		service.getXmlFile(args[0]);
	}

}
