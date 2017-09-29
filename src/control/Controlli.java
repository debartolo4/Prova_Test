package control;

import java.util.GregorianCalendar;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

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
	// -Contenere almeno 1 lettera maiuscola;
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

	// CONTROLLO SESSO
	// Il campo 'Sesso' deve essere una 'M' o una 'F'.
	public boolean sexControl(JTextField text) throws Exception {
		String sex = text.getText();

		if (sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("F")) {
			return true;
		} else {
			throw new Exception("Il valore inserito per il SESSO non è consentito.");
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

	// CONTROLLO MANSIONE DIPENDENTE
	// La mansione del dipendente non può contenere numeri.
	public boolean taskControl(JTextField text) throws Exception {
		String task = text.getText();

		if (task.matches("^\\D+$")) {
			return true;
		} else {
			throw new Exception("La mansione non può contenere numeri.");
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
				"^((via)|(viale)|(piazza)|(corte)|(corso)|(vicolo)|(contrada)|(strada))(\\s(\\w*[a-zA-Z]+\\w*)+\\D*\\s*)*[,]\\s*\\d+([/]?[a-zA-Z])?$")) {
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
				if (bornDay <= 31) {
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
				query = "SELECT ID_Dipendente FROM mydipendente";
				label = "ID_Dipendente";
			} else if (table.equals(Table.SPAZIO)) {
				query = "SELECT ID_Spazio FROM myspazio";
				label = "ID_Spazio";
			} else if (table.equals(Table.STRUMENTAZIONE)) {
				query = "SELECT ID_Strumento FROM mystrumentazione";
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

		if ((field.isEmpty()) || (!field.matches("^\\S+$"))) {
			throw new Exception("Stringa vuota!");
		} else {
			return true;
		}
	}

	// CONTROLLO NUMERO UNITA' POSSEDUTE
	// Controllare che il campo non sia una lettera e che il numero sia >0
	public boolean onlyNumFieldControl(JTextField text) throws Exception {
		String field = text.getText();

		if (field.matches("^\\d+$")) {
			return true;
		} else {
			throw new Exception("Il campo deve contenere solo numeri!");
		}
	}

	// public boolean controlId(JTextField jt, Table t) throws Exception {
	// String query = null;
	// Pattern pattern = Pattern.compile("^\\d{6}$");
	// Matcher matcher = pattern.matcher(jt.getText());
	// if(!matcher.matches())
	// throw new Exception("Sono accettati solo numeri di 6 cifre");
	// if(t.equals(Table.DIPENDENTE))
	// query = "Select ID_Dipendente from mydipendente";
	// if(t.equals(Table.SPAZIO))
	// query = "Select ID_Spazio from myspazio";
	// if(t.equals(Table.STRUMENTAZIONE))
	// query = "Select ID_Struemnto from mystrumentazione";
	// DBManager db = DBManager.getInstance();
	// ResultSet rs = db.querySelect(query);
	// while(rs.next()) {
	// if(rs.toString().equals(jt.getText()))
	// throw new Exception("ID già esistente");
	// }
	// return true;
	// }
	//
	//
	//
	// public boolean controlChar(JTextField... jt) throws Exception {
	// Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$");
	// Matcher matcher = null;
	// boolean temp = true;
	// for(int i = 0; i < jt.length; i++) {
	// matcher = pattern.matcher(jt[i].getText());
	// if(!matcher.matches())
	// temp = false;
	// }
	// if(temp)
	// return temp;
	// throw new Exception("Sono accettati solo caretteri e spazi");
	// }
	//
	//
	// public boolean controlSex(JTextField jt) throws Exception {
	// if(jt.getText().equals("M") || jt.getText().equals("F")) {
	// return true;
	// }
	// throw new Exception("Il sesso può essere solo maschile o femminile");
	// }
	//
	//
	// public boolean controlDate(JTextField jt) throws Exception {
	// Pattern pattern = Pattern.compile("^(19[5-9][0-9]|20[0-4][0-9]|2017)"
	// + "-(01-(0[1-9]|[12][0-9]|3[01])"
	// + "|02-(0[1-9]|[12][0-8])"
	// + "|(0[3-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]))$");
	// Matcher matcher = pattern.matcher(jt.getText());
	// if(matcher.matches())
	// return true;
	// throw new Exception("Le date sono accettate solo nel formato YYYY-MM-DD
	// ");
	//
	// }
	// public boolean controlEmail(JTextField jt) throws Exception {
	// Pattern pattern =
	// //espressione regolare semplificata
	// Pattern.compile("^[\\w]+((.?)(\\w+))*[@][\\w]+((.?)(\\w+))*[.][a-zA-Z]{2,3}$");
	// //espressione regolare completa
	//// Pattern.compile("^[\\w]+((.?|[-]?)(\\w+))*[@][\\w]+((.?)(\\w+))*[.][a-zA-Z]{2,3}$");
	//
	// Matcher matcher = pattern.matcher(jt.getText());
	// if(matcher.matches())
	// return true;
	// throw new Exception("Formato email non valido");
	//
	// }
	//
	//
	// public boolean controlPhoneNumber(JTextField jt) throws Exception {
	// if(jt.getText().matches("\\d{10}")) return true;
	// else if(jt.getText().matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
	// return true;
	// else if(jt.getText().matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
	// return true;
	// else if(jt.getText().matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
	// throw new Exception("Numero di telefono non valido");
	// }
	//
	//
	// public boolean controlCf(JTextField jt) throws Exception {
	// if(jt.getText().matches("^[a-zA-Z0-9]{16}$"))
	// return true;
	// throw new Exception("Codice fiscale non valido");
	//
	// }
	//
	//
	// public boolean controlAddress(JTextField jt) throws Exception {
	// if(jt.getText().matches("(via)(([\\s]+)([a-zA-Z]+))+")) return true;
	// else if(jt.getText().matches("(corte)(([\\s]+)([a-zA-Z]+))+")) return
	// true;
	// else if(jt.getText().matches("(viale)(([\\s]+)([a-zA-Z]+))+")) return
	// true;
	// else if(jt.getText().matches("(piazza)(([\\s]+)([a-zA-Z]+))+")) return
	// true;
	// else if(jt.getText().matches("(corso)(([\\s]+)([a-zA-Z]+))+")) return
	// true;
	// throw new Exception("l'indirizzo obbligatoriamente una via, piazza, corte
	// o viale");
	// }
	//
	//
	// public boolean controlNUnità(JTextField jt) throws Exception{
	// if(Integer.parseInt(jt.getText()) > 0 && Integer.parseInt(jt.getText()) <
	// 100)
	// return true;
	// if(Integer.parseInt(jt.getText()) == 0)
	// throw new Exception("Unità non disponibile");
	// throw new Exception("Numero di unità non valido");
	// }
	//
	//
	// public boolean controlYear(JTextField jt) throws Exception{
	// if(Integer.parseInt(jt.getText()) > 1950 &&
	// Integer.parseInt(jt.getText()) < 2018)
	// return true;
	// throw new Exception("Anno non disponibile");
	// }
	//
	//
	// public boolean controlUser(String user) throws Exception {
	// Pattern pattern =
	// Pattern.compile("^(?=.{4,20}$)(?![_.-])(?!.*[_.-]{2})[a-zA-Z0-9_-]+([^._-])$");
	// Matcher matcher = pattern.matcher(user);
	// if(matcher.matches())
	// return true;
	// throw new Exception("User non valida ("
	// + "deve avere una lunghezza compresa fra 4 e 20;"
	// + "deve contenere una lettere ed un numero)");
	// }
	//
	//
	// public boolean controlPassword(String password) throws Exception {
	// Pattern pattern =
	// Pattern.compile("^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{4,})\\S$");
	// Matcher matcher = pattern.matcher(password);
	// if(matcher.matches())
	// return true;
	// throw new Exception("Password non valida ("
	// + "deve avere una lunghezza compresa fra 4 e 20;"
	// + "deve contenere una lettere ed un numero)");
	// }

	/**
	 * Gets the query.
	 *
	 * @param textField
	 *            the text field
	 * @return the query
	 * @throws Exception
	 * @Query
	 */
//	public String getQuery(ArrayList<JTextField> textField2, Table t, String... elem) throws Exception {
//		textField2.iterator();
//		int count = 0;
//		String query = null;
//		if (t.equals(Table.STRUMENTAZIONE))
//			query = "INSERT INTO mystrumentazione (";
//		else if (t.equals(Table.DIPENDENTE))
//			query = "INSERT INTO mydipendente (";
//		else if (t.equals(Table.SPAZIO))
//			query = "INSERT INTO myspazio (";
//		else
//			throw new Exception();
//
//		while (count < elem.length) {
//			if (count != elem.length - 1)
//				query = query + elem[count] + ",";
//			else
//				query = query + elem[count] + ") VALUES";
//			count++;
//		}
//		query = query + "(";
//		for (JTextField field1 : textField2) {
//			query = query + "'" + field1.getText() + "',";
//		}
//		query = query.substring(0, query.length() - 1);
//		query = query + ");";
//		return query;
//	}
//
//	/**
//	 * List utility.
//	 *
//	 * @param list
//	 *            the list
//	 * @param query
//	 *            the query
//	 * @param id
//	 *            the id
//	 * @return the array list
//	 * @throws Exception
//	 * @listUtility
//	 */
//	public ArrayList<String> listUtility(ArrayList<String> list, String query, String id) throws Exception {
//		DBManager mysql = DBManager.getInstance();
//		int count = 0;
//		ResultSet rs = mysql.querySelect(query);
//		while (rs.next()) {
//			count++;
//			Integer temp = rs.getInt(id);
//			list.add(temp.toString());
//		}
//		if (list.size() == count)
//			return list;
//		throw new Exception("Gli id non sono stati salvati correttamente");
//	}
}
