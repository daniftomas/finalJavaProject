package finalJavaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
	
	Connection c = null;
	boolean ligacao;
	
	
	public DataBase() {
		ligacao = false;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:dbfinalJavaProject.db");
			ligacao = true;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} 
	}
	
	public DataBase(String senha, String pass){
		ligacao = false;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:dbfinalJavaProject.db");
			ligacao = true;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} 
	}
	
	public boolean isOn(){
		return ligacao;
	}
	
	public Office getOffice (String var){
		Office office = null; 
		if (this.isOn()) {
			String city;
			String phone;
			String addressLine1;
			String addressLine2;
			String state;
			String country;
			String postalCode;
			String territory;
			try {
				Statement smt = c.createStatement();
				String sql = "SELECT city, phone, addressLine1, addressLine2, state, country, postalCode, territory from Offices WHERE officeCode = '"+var+"';";;
				ResultSet rs = smt.executeQuery(sql);
				if (rs.next()) {
					city = rs.getString("city");
					phone = rs.getString("phone");
					addressLine1 = rs.getString("addressLine1");
					addressLine2 = rs.getString("addressLine2");
					state = rs.getString("state");
					country = rs.getString("country");
					postalCode = rs.getString("postalCode");
					territory = rs.getString("territory");
					office = new Office(var, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return office;
	}
	
	public List<Office> getOfficeList (){
		Office office = null; 
		List<Office> offices = new ArrayList<>();
		if (this.isOn()) {
			String city;
			String phone;
			String addressLine1;
			String addressLine2;
			String state;
			String country;
			String postalCode;
			String territory;
			String officeCode;
			try {
				Statement smt = c.createStatement();
				String sql = "SELECT officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory from Offices;";;
				ResultSet rs = smt.executeQuery(sql);
				while (rs.next()) {
					officeCode = rs.getString("officeCode"); 
					city = rs.getString("city");
					phone = rs.getString("phone");
					addressLine1 = rs.getString("addressLine1");
					addressLine2 = rs.getString("addressLine2");
					state = rs.getString("state");
					country = rs.getString("country");
					postalCode = rs.getString("postalCode");
					territory = rs.getString("territory");
					office = new Office(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
					offices.add(office);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return offices;
	}
	
	public List<Office> getOfficeList (int tipoPesquisa, String variavel){
		Office office = null; 
		List<Office> offices = new ArrayList<>();
		if (this.isOn()) {
			String city;
			String phone;
			String addressLine1;
			String addressLine2;
			String state;
			String country;
			String postalCode;
			String territory;
			String officeCode;
			try {
				Statement smt = c.createStatement();
				String compara = "";
				switch (tipoPesquisa){
					case 0:
						compara = "city"; 
						break;
					case 1:
						compara = "state";
						break;
					case 2:
						compara = "territory";
						break;
					default:
						compara = "country";
				}
				String sql = "SELECT officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory from Offices where "+compara+" = '"+variavel+"';";;
				ResultSet rs = smt.executeQuery(sql);
				while (rs.next()) {
					officeCode = rs.getString("officeCode"); 
					city = rs.getString("city");
					phone = rs.getString("phone");
					addressLine1 = rs.getString("addressLine1");
					addressLine2 = rs.getString("addressLine2");
					state = rs.getString("state");
					country = rs.getString("country");
					postalCode = rs.getString("postalCode");
					territory = rs.getString("territory");
					office = new Office(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
					offices.add(office);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return offices;
	}
	
	
	
	
	
	
}