package control;

import java.util.GregorianCalendar;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import enums.Table;
import support.DBManager;

public class Controlli {

	// CONTROLLO USERNAME
	// L'Username:
	// - Deve contenere da 4 (compreso) a 20 (escluso) caratteri;
	// - Deve contenere almeno un numero e una lettera;
	// - Non deve contenere caratteri speciali;
	// - Non può terminare con ".".
	public boolean userControl(JTextField text) throws Exception {
		String user = text.getText();

		if (user.length() >= 4 && user.length() < 20) {
			if (user.matches("^([a-zA-Z]+\\w*[0-9]+[a-zA-Z]*\\w*)|([a-zA-Z]*\\w*[0-9]+[a-zA-Z]+\\w*)$")) {
				return true;
			} else {
				throw new Exception(
						"L'Username deve contenere almeno un numero e una lettera (non può contenere caratteri speciali).");
			}
		} else {
			throw new Exception("Il campo 'Username' deve contenere da 4 (compreso) a 20 (escluso) caratteri.");
		}
	}

	// CONTROLLO PASSWORD
	// -Lunghezza da 4 a 20 caratteri;
	// -Contenere almeno 1 numero e 1 lettera;
	public boolean passwordControl(JPasswordField pass) throws Exception {
		String password = String.copyValueOf(pass.getPassword());

		if ((password.length() >= 4) && (password.length() < 20)) {
			if (password.matches("^([a-zA-Z]+\\w*[0-9]+[a-zA-Z]*\\w*)|([a-zA-Z]*\\w*[0-9]+[a-zA-Z]+\\w*)$")) {
				return true;
			} else {
				throw new Exception("Il campo 'Password' deve contenere almeno un numero e una lettera");
			}
		} else {
			throw new Exception("Il campo 'Password' deve contenere da 4 (compreso) a 20 (escluso) caratteri.");
		}
	}

	// CONTROLLO NOME DIPENDENTE
	// Il nome del dipendente non può contenere numeri e deve cominciare con una
	// lettera maiuscola.
	public boolean nameControl(JTextField text) throws Exception {
		String name = text.getText();

		if (name.matches("^[A-Z]+\\D*$")) {
			return true;
		} else {
			throw new Exception(
					"Nome inserito non valido. Deve cominciare con la lettera maiuscola e può contenere solo lettere.");
		}
	}

	// CONTROLLO COGNOME DIPENDENTE
	// Il cognome del dipendente non può contenere numeri.
	public boolean surnameControl(JTextField text) throws Exception {
		String surname = text.getText();

		if (surname.matches("^\\D+$")) {
			return true;
		} else {
			throw new Exception("Il cognome inserito non è valido. Può contenere solo lettere.");
		}
	}

	// CONTROLLO DATA
	// La data deve essere del seguente formato: AAAA-MM-GG.
	// Qualsiasi altro formato o delimitatore non è accettato.
	public boolean dateControl(JTextField text) throws Exception {
		String dateInString = text.getText();

		if (dateInString.length() != 10) {
			throw new Exception("Data inserita non valida (troppo lunga o troppo corta).");
		}
		if (!dateInString.substring(4, 5).equals("-") || !dateInString.substring(7, 8).equals("-")) {
			throw new Exception("Delimitatore non valido. Utilizzare solo ed esclusivamente '-'.");
		} else {
			Integer day = Integer.parseInt(dateInString.substring(8));
			Integer month = Integer.parseInt(dateInString.substring(5, 7));
			Integer year = Integer.parseInt(dateInString.substring(0, 4));
			GregorianCalendar date = new GregorianCalendar(year, month - 1, day);
			date.setLenient(false);
			try {
				date.get(Calendar.DATE);
				return true;
			} catch (IllegalArgumentException e) {
				throw new Exception("Data non valida.");
			}
		}
	}

	// CONTROLLO E-MAIL DIPENDENTE
	// L'e-mail deve essere del formato: lamiaemail@account.dom, dove:
	// -Non è possibile inserire spazi;
	// -Non è possibile inserire più di una chiocciola;
	// -Il campo "lamiaemail" non può contenere "." prima di "@";
	// -Il campo "account" può contenere punti per accettare stringhe del tipo
	// "studenti.uniba";
	// -Il campo ".dom" può avere lunghezza 2 o 3 per accettare domini deò tipo
	// ".com", ".it", ecc.;
	public boolean emailControl(JTextField text) throws Exception {
		String email = text.getText();

		if (email.contains(" ")) {
			throw new Exception("L'e-mail non può contenere spazi.");
		}
		if (!email.contains("@")) {
			throw new Exception("L'e-mail non contiene '@'.");
		}

		String laMiaEmail = email.substring(0, email.indexOf("@"));
		String dopoChiocciola = email.substring(email.indexOf("@") + 1);

		if (laMiaEmail.endsWith(".")) {
			throw new Exception("Non si può inserire '.' prima di '@'.");
		} else if (laMiaEmail.contains("@")) {
			throw new Exception("Non è possibile inserire più di un '@'.");
		}

		if (!dopoChiocciola.matches("^\\w+[.]*\\w*[^.][.][a-z]{2,3}$")) {
			throw new Exception("Dominio o campo account errato.");
		}

		return true;
	}

	// CONTROLLO NUMERO DI TELEFONO DIPENDENTE
	// Il numero di telefono può contenre solo numeri, al più il carattere '+'
	// all'inizio della stringa.
	// Inoltre deve contenere almeno dieci numeri (escluso il prefisso
	// nazionale);
	public boolean phoneControl(JTextField text) throws Exception {
		String phone = text.getText();

		if (!phone.matches("^[+]?\\d*$") || phone.length() < 10) {
			throw new Exception("Numero di telefono inserito non valido.");
		} else {
			return true;
		}
	}

	// CONTROLLO INDIRIZZO DIPENDENTE
	// -L'indirizzo deve essere del formato :
	// "(via/viale/corso/piazza/contrada/strada/vicolo/corte) stringaIndirizzo,
	// numero".
	public boolean addressControl(JTextField text) throws Exception {
		String address = text.getText();
		address = address.toLowerCase();

		if (!address.matches(
				"^((via)|(viale)|(piazza)|(corte)|(corso)|(vicolo)|(contrada)|(strada))"
				+ "(\\s(\\w*[a-zA-Z]+\\w*)+\\D*\\s*)*[,]\\s*\\d+([/]?[a-zA-Z])?$")) {
			throw new Exception("Formato indirizzo non valido");
		} else {
			return true;
		}
	}

	// CONTROLLO CODICE FISCALE DIPENDENTE
	// Deve avere lunghezza 16;
	// Deve essere del seguente formato: XXXXXX00X00X000X dove le 'X' sono
	// lettere e gli '0' sono numeri.
	// Il valore del carattere corrispondente al mese di nascita non deve essere
	// uno tra F,G,I,J,K,N,O,Q,U,V,W,X,Y,Z.
	// Il valore del numero corrispondente al giorno di nascita non può essere
	// maggiore di 31.
	public boolean cfControl(JTextField text) throws Exception {
		String cf = text.getText();
		cf = cf.toUpperCase();

		if (cf.matches("^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$")) {
			if (cf.substring(8, 9).matches("^[^F,G,I,J,K,N,O,Q,U,V,W,X,Y,Z]$")) {
				Integer bornDay = Integer.parseInt(cf.substring(9, 11));
				if (bornDay <= 31 && bornDay != 0) {
					return true;
				}
			}
		}
		throw new Exception("Codice fiscale inserito non valido");
	}

	// CONTROLLO ID
	// Deve essere composto da soli numeri e deve avere una lunghezza pari a 6.
	// Non deve essere un valore già presente nel database.
	public boolean IDControl(JTextField text, Table table, String className) throws Exception {
		String id = text.getText();
		String query = null;
		String label = null;

		if (!id.matches("^\\d{6}$")) {
			throw new Exception("La lunghezza dell'ID deve essere necessariamente 6.");
		}

		if (className.equals("NuovoDipendente") || className.equals("NuovoSpazio")
				|| className.equals("NuovaStrumentazione")) {
			if (table.equals(Table.DIPENDENTE)) {
				query = "SELECT ID_Dipendente FROM dipendente";
				label = "ID_Dipendente";
			} else if (table.equals(Table.SPAZIO)) {
				query = "SELECT ID_Spazio FROM spazio";
				label = "ID_Spazio";
			} else if (table.equals(Table.STRUMENTAZIONE)) {
				query = "SELECT ID_Strumento FROM strumentazione";
				label = "ID_Strumento";
			}

			DBManager db = DBManager.getInstance();
			ResultSet rs = db.querySelect(query);

			while (rs.next()) {
				if (rs.getString(label).equals(id)) {
					throw new Exception("L'ID deve essere unico. Uno identico è già presente nel Database.");
				}
			}

		}
		return true;
	}

	// CONTROLLO STRINGA TESTUALE NON VUOTA
	// Controllare semplicemente che il campo non sia vuoto
	public boolean notEmptyStringControl(JTextField text) throws Exception {
		String field = text.getText();

		if ((field.isEmpty()) || (field.matches("^\\s+$"))) {
			throw new Exception("Stringa vuota!");
		} else {
			return true;
		}
	}

	// CONTROLLO NUMERO UNITA' POSSEDUTE
	// Controllare che il campo non sia una lettera e che il numero sia >= 0
	public boolean onlyNumFieldControl(JTextField text) throws Exception {
		String field = text.getText();

		if (field.matches("^\\d+$")) {
			return true;
		} else {
			throw new Exception("Il campo deve contenere solo numeri!");
		}
	}

	/**
	 * Gets the query.
	 *
	 * @param textField
	 *            the text field
	 * @return the query
	 * @throws Exception
	 * @Query
	 */
	public String getQuery(ArrayList<JTextField> textField2, Table t, JList<String> list, JList<String> list1, String... elem)
			throws Exception {
		textField2.iterator();
		int count = 0;
		String query = null;
		Integer cod_man = getTaskCode(list1);
		if (t.equals(Table.STRUMENTAZIONE))
			query = "INSERT INTO strumentazione (";
		else if (t.equals(Table.DIPENDENTE))
			query = "INSERT INTO dipendente (";
		else if (t.equals(Table.SPAZIO))
			query = "INSERT INTO spazio (";
		else
			throw new Exception();

		while (count < elem.length) {
			if (count != elem.length - 1)
				query = query + elem[count] + ",";
			else
				query = query + elem[count] + ") VALUES";
			count++;
		}
		query = query + "('" + (String) list.getSelectedValue() + "','" + cod_man + "',";

		for (JTextField field1 : textField2) {
			query = query + "'" + field1.getText() + "',";
		}
		query = query.substring(0, query.length() - 1);
		query = query + ");";
		return query;
	}
	
	//Overload (getQuery)
	public String getQuery(ArrayList<JTextField> textField2, Table t, String... elem) throws Exception {
		textField2.iterator();										
		int count = 0;												
		String query = null;										
		if (t.equals(Table.STRUMENTAZIONE))							
			query = "INSERT INTO strumentazione (";					
		else if (t.equals(Table.DIPENDENTE))						
			query = "INSERT INTO dipendente (";						
		else if (t.equals(Table.SPAZIO))							
			query = "INSERT INTO spazio (";							
		else														
			throw new Exception();									
																	
		while (count < elem.length) {								
			if (count != elem.length - 1)							
				query = query + elem[count] + ",";					
			else													
				query = query + elem[count] + ") VALUES (";			
			count++;												
		}															
																	
		for (JTextField field1 : textField2) {						
			query = query + "'" + field1.getText() + "',";			
		}															
		query = query.substring(0, query.length() - 1);				
		query = query + ");";										
		return query;												
	}

	/**
	 * List utility.
	 *
	 * @param list
	 *            the list
	 * @param query
	 *            the query
	 * @param id
	 *            the id
	 * @return the array list
	 * @throws Exception
	 * @listUtility
	 */
	public ArrayList<String> listUtility(ArrayList<String> list, String query, String id) throws Exception {
		DBManager mysql = DBManager.getInstance();
		int count = 0;
		ResultSet rs = mysql.querySelect(query);
		while (rs.next()) {
			count++;
			Integer temp = rs.getInt(id);
			list.add(temp.toString());
		}
		if (list.size() == count)
			return list;
		throw new Exception("Gli id non sono stati salvati correttamente");
	}

	//Restituisce il codice mansione
	public Integer getTaskCode(JList<String> list) throws Exception {
		ArrayList<String> selected_task = (ArrayList<String>) list.getSelectedValuesList();

		if (selected_task.size() == 1 && selected_task.get(0).equals("Collaboratore")) {
			return 1;
		} else if (selected_task.size() == 1 && selected_task.get(0).equals("Direttore")) {
			return 4;
		} else if (selected_task.size() == 1 && selected_task.get(0).equals("Dipendente")) {
			return 2;
		} else if (selected_task.size() == 2 && ((selected_task.get(0).equals("Dipendente")
				&& selected_task.get(1).equals("Collaboratore"))
				|| (selected_task.get(0).equals("Collaboratore") && selected_task.get(1).equals("Dipendente")))) {
			return 3;
		} else {
			throw new Exception("Selezione della mansione non corretta.");
		}
	}
}
