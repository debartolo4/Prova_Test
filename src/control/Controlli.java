package control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import enums.Table;
import support.DBManager;

public class Controlli {

	public boolean userControl (JTextField text) throws Exception {
		
		String user = text.getText();
		
		if (user.length() >= 4 && user.length() < 20) {
			return true;
		} else {
			throw new Exception("Il campo 'Username' deve contenere da 4 (compreso) a 20 (escluso) caratteri.");
		}
		
		if (user.)
		
	}
	
	
//	
//	
//	
//	public boolean controlId(JTextField jt, Table t) throws Exception {
//		String query = null;
//		Pattern pattern = Pattern.compile("^\\d{6}$");
//		Matcher matcher = pattern.matcher(jt.getText());
//		if(!matcher.matches())
//			throw new Exception("Sono accettati solo numeri di 6 cifre");
//		if(t.equals(Table.DIPENDENTE))
//			query = "Select ID_Dipendente from mydipendente";
//		if(t.equals(Table.SPAZIO))
//			query = "Select ID_Spazio from myspazio";
//		if(t.equals(Table.STRUMENTAZIONE))
//			query = "Select ID_Struemnto from mystrumentazione";
//		DBManager db = DBManager.getInstance();
//		ResultSet rs = db.querySelect(query);
//		while(rs.next()) {
//			if(rs.toString().equals(jt.getText()))
//				throw new Exception("ID già esistente");
//		}
//		return true;
//	}
//	
//	
//	
//	public boolean controlChar(JTextField... jt) throws Exception {
//		Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$");
//		Matcher matcher = null;
//		boolean temp = true;
//		for(int i = 0; i < jt.length; i++) {
//			matcher = pattern.matcher(jt[i].getText());
//			if(!matcher.matches())
//				temp = false;
//		}
//		if(temp)
//			return temp;
//		throw new Exception("Sono accettati solo caretteri e spazi");	
//	}
//	
//	
//	public boolean controlSex(JTextField jt) throws Exception {
//		if(jt.getText().equals("M") || jt.getText().equals("F")) {
//			return true;
//		}
//		throw new Exception("Il sesso può essere solo maschile o femminile");
//	}
//	
//	
//	public boolean controlDate(JTextField jt) throws Exception {
//		Pattern pattern = Pattern.compile("^(19[5-9][0-9]|20[0-4][0-9]|2017)"
//				+ "-(01-(0[1-9]|[12][0-9]|3[01])"
//				+ "|02-(0[1-9]|[12][0-8])"
//				+ "|(0[3-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]))$");
//		Matcher matcher = pattern.matcher(jt.getText());
//		if(matcher.matches())
//			return true;
//		throw new Exception("Le date sono accettate solo nel formato YYYY-MM-DD ");
//		
//	}
//	public boolean controlEmail(JTextField jt) throws Exception {
//		Pattern pattern = 
//				//espressione regolare semplificata
//				Pattern.compile("^[\\w]+((.?)(\\w+))*[@][\\w]+((.?)(\\w+))*[.][a-zA-Z]{2,3}$");
//				//espressione regolare completa
////				Pattern.compile("^[\\w]+((.?|[-]?)(\\w+))*[@][\\w]+((.?)(\\w+))*[.][a-zA-Z]{2,3}$");
//				
//		Matcher matcher = pattern.matcher(jt.getText());
//		if(matcher.matches())
//			return true;
//		throw new Exception("Formato email non valido");
//		
//	}
//	
//	
//	public boolean controlPhoneNumber(JTextField jt) throws Exception {
//		if(jt.getText().matches("\\d{10}")) return true;
//		else if(jt.getText().matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
//		else if(jt.getText().matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
//		else if(jt.getText().matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
//		throw new Exception("Numero di telefono non valido");
//	}
//	
//	
//	public boolean controlCf(JTextField jt) throws Exception {
//		if(jt.getText().matches("^[a-zA-Z0-9]{16}$"))
//			return true;
//		throw new Exception("Codice fiscale non valido");
//
//	}
//	
//	
//	public boolean controlAddress(JTextField jt) throws Exception {
//		if(jt.getText().matches("(via)(([\\s]+)([a-zA-Z]+))+")) return true;
//		else if(jt.getText().matches("(corte)(([\\s]+)([a-zA-Z]+))+")) return true;
//		else if(jt.getText().matches("(viale)(([\\s]+)([a-zA-Z]+))+")) return true;
//		else if(jt.getText().matches("(piazza)(([\\s]+)([a-zA-Z]+))+")) return true;
//		else if(jt.getText().matches("(corso)(([\\s]+)([a-zA-Z]+))+")) return true;
//		throw new Exception("l'indirizzo obbligatoriamente una via, piazza, corte o viale");
//	}
//	
//	
//	public boolean controlNUnità(JTextField jt) throws Exception{
//		if(Integer.parseInt(jt.getText()) > 0 && Integer.parseInt(jt.getText()) < 100)
//			return true;
//		if(Integer.parseInt(jt.getText()) == 0)
//			throw new Exception("Unità non disponibile");
//		throw new Exception("Numero di unità non valido");
//	}
//	
//	
//	public boolean controlYear(JTextField jt) throws Exception{
//		if(Integer.parseInt(jt.getText()) > 1950 && Integer.parseInt(jt.getText()) < 2018)
//			return true;
//		throw new Exception("Anno non disponibile");
//	}
//
//	
//	public boolean controlUser(String user) throws Exception {
//		Pattern pattern = Pattern.compile("^(?=.{4,20}$)(?![_.-])(?!.*[_.-]{2})[a-zA-Z0-9_-]+([^._-])$");
//		Matcher matcher = pattern.matcher(user);
//		if(matcher.matches())
//			return true;
//		throw new Exception("User non valida ("
//			+ "deve avere una lunghezza compresa fra 4 e 20;"
//			+ "deve contenere una lettere ed un numero)");
//	}
//	
//	
//	public boolean controlPassword(String password) throws Exception {
//		Pattern pattern = Pattern.compile("^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{4,})\\S$");
//		Matcher matcher = pattern.matcher(password);
//		if(matcher.matches())
//			return true;
//		throw new Exception("Password non valida ("
//				+ "deve avere una lunghezza compresa fra 4 e 20;"
//				+ "deve contenere una lettere ed un numero)");
//	}
//	
//	
//	/**
//	 * Gets the query.
//	 *
//	 * @param textField the text field
//	 * @return the query
//	 * @throws Exception 
//	 * @Query 
//	 */
//	public String getQuery(ArrayList<JTextField> textField2, Table t , String... elem) throws Exception {
//		textField2.iterator();
//		int count = 0;
//		String query = null;
//		if(t.equals(Table.STRUMENTAZIONE))
//			query = "INSERT INTO mystrumentazione (";
//		else if(t.equals(Table.DIPENDENTE))
//			query = "INSERT INTO mydipendente (";
//		else if(t.equals(Table.SPAZIO))
//			query = "INSERT INTO myspazio (";
//		else throw new Exception();
//		
//		while(count < elem.length) {
//			if(count != elem.length - 1)
//				query = query + elem[count] + ",";
//			else
//				query = query + elem[count] + ") VALUES";
//			count++;
//		}
//		query = query + "(";
//		for(JTextField field1 : textField2) {
//			query = query + "'" + field1.getText() + "',";
//		}
//		query = query.substring(0,query.length() - 1 );
//		query = query + ");";
//		return query;
//	}
//	
//	/**
//	 * List utility.
//	 *
//	 * @param list the list
//	 * @param query the query
//	 * @param id the id
//	 * @return the array list
//	 * @throws Exception 
//	 * @listUtility 
//	 */
//	public ArrayList<String> listUtility(ArrayList<String> list, String query, String id) throws Exception {
//		DBManager mysql = DBManager.getInstance();
//		int count = 0;		
//		ResultSet rs = mysql.querySelect(query);
//		while(rs.next()) {
//			count++;
//			Integer temp = rs.getInt(id);
//			list.add(temp.toString());
//		}		
//		if(list.size()==count)
//			return list;
//		throw new Exception("Gli id non sono stati salvati correttamente");
//	}
//	
	
}
