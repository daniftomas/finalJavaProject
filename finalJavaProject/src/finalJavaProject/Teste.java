package finalJavaProject;

import java.util.List;

public class Teste {

	public static void main(String[] args) {
		DataBase db = new DataBase();
		List<Office> lista = db.getOfficeList();
		System.out.println(lista.size());
		for (Office office : lista) {
			System.out.println(office.toString());
		}
		Office of = db.getOffice("o1");
		System.out.println(of.getTerritory());

	}

}
