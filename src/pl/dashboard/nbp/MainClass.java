package pl.dashboard.nbp;


import pl.dashboard.nbp.input.NbpService;

public class MainClass {


	public static void main(String[] args) {
		NbpService service = new NbpService();
		String[] args1 = {"2009-12-12"};
		service.getTable(args1);
	}

}
