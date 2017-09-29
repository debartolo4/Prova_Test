package test;

import static org.junit.Assert.*;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.Controlli;
import enums.Table;
import support.DBManager;

public class TestBlackBox {

	private Controlli control;
	private JTextField text;
	private JPasswordField pass;
	private static final String MATRICOLA = "634845"; 
	
	@Before
	public void setUp() throws Exception {
		control = new Controlli();
		text = new JTextField();
		pass = new JPasswordField();
	}

	@After
	public void tearDown() throws Exception {
		control = null;
		text = null;
		pass = null;
		DBManager db = DBManager.getInstance();
		db.query("DELETE FROM `mydipendente` WHERE `mydipendente`.`ID_Dipendente` = '" + MATRICOLA + "';" );
	}

	// Controllo USERNAME minore di 4 caratteri
	@Test(expected = Exception.class)
	public void testUserControlWithShortWord() throws Exception {
		text.setText("shr");
		control.userControl(text);
	}

	// Controllo USERNAME senza numeri
	@Test(expected = Exception.class)
	public void testUserControlWithoutNumbers() throws Exception {
		text.setText("usernamesenzanumeri");
		control.userControl(text);
	}

	// Controllo USERNAME senza lettere
	@Test(expected = Exception.class)
	public void testUserControlWithoutLetters() throws Exception {
		text.setText("33433433");
		control.userControl(text);
	}

	// Controllo USERNAME che termina con punto
	@Test(expected = Exception.class)
	public void testUserControlWithPoint() throws Exception {
		text.setText("conpunto3.");
		control.userControl(text);
	}

	// Controllo USERNAME valida
	@Test
	public void testUserControlWithAcceptedWord() throws Exception {
		text.setText("usernameValida33");
		assertTrue(control.userControl(text));
	}

	// Controllo PASSWORD minore di 4 caratteri
	@Test(expected = Exception.class)
	public void testPasswordControlWithShortWord() throws Exception {
		pass.setText("4sd");
		control.passwordControl(pass);
	}

	// Controllo PASSWORD maggiore di 20 caratteri
	@Test(expected = Exception.class)
	public void testPasswordControlWithLongWord() throws Exception {
		pass.setText("c0ntienepiudiv3nticaratteri");
		control.passwordControl(pass);
	}

	// Controllo PASSWORD con almeno 1 numero e 1 lettera
	@Test(expected = Exception.class)
	public void testPasswordControlWithoutLetter() throws Exception {
		pass.setText("23121898");
		control.passwordControl(pass);
	}

	// Controllo1 PASSWORD con almeno 1 numero e 1 lettera
	@Test(expected = Exception.class)
	public void testPasswordControlWithoutNumbers() throws Exception {
		pass.setText("password");
		control.passwordControl(pass);
	}

	// Controllo PASSWORD valida
	@Test
	public void testPasswordControlAcceptedWord() throws Exception {
		pass.setText("passwordvalida2");
		assertTrue(control.passwordControl(pass));
	}

	// Controllo SESSO non accettato
	@Test(expected = Exception.class)
	public void testSexControlNotAccepted() throws Exception {
		text.setText("NONVALIDO");
		control.sexControl(text);
	}

	// Controllo SESSO accettato
	@Test
	public void testSexControlAccepted() throws Exception {
		text.setText("M");
		assertTrue(control.sexControl(text));
	}

	// Controllo NOME non accettato
	@Test(expected = Exception.class)
	public void testNameControlNotAccepted() throws Exception {
		text.setText("inizioconlaminuscola");
		control.nameControl(text);
	}

	// Controllo NOME accettato
	@Test
	public void testNameControlAccepted() throws Exception {
		text.setText("Carlo");
		assertTrue(control.nameControl(text));
	}

	// Controllo COGNOME non accettato
	@Test(expected = Exception.class)
	public void testSurnameControlNotAccepted() throws Exception {
		text.setText("ilmiocogn0m3");
		control.surnameControl(text);
	}

	// Controllo COGNOME accettato
	@Test
	public void testSurnameControlAccepted() throws Exception {
		text.setText("de Bartolo");
		assertTrue(control.surnameControl(text));
	}

	// Controllo TASK non accettato
	@Test(expected = Exception.class)
	public void testTaskControlNotAccepted() throws Exception {
		text.setText("Mansione non accettata 3");
		control.taskControl(text);
	}

	// Controllo TASK accettato
	@Test
	public void testTaskControlAccepted() throws Exception {
		text.setText("Mansione accettata");
		assertTrue(control.taskControl(text));
	}

	// Controllo DATA con delimitatori sbagliati
	@Test(expected = Exception.class)
	public void testDateWithWrongDelimiter() throws Exception {
		text.setText("28\09\2012");
		control.dateControl(text);
	}

	// Controllo DATA non accettata
	@Test(expected = Exception.class)
	public void testDateNotAccepted() throws Exception {
		text.setText("2012-02-30");
		control.dateControl(text);
	}

	// Controllo DATA formato non accettato
	@Test(expected = Exception.class)
	public void testDateWrongFormat() throws Exception {
		text.setText("3-2-20");
		control.dateControl(text);
	}

	// Controllo DATA (out of bound)
	@Test(expected = Exception.class)
	public void testDateOutOfBound() throws Exception {
		text.setText("2012-01-32");
		control.dateControl(text);
	}

	// Controllo DATA (limite superiore)
	@Test
	public void testDateUpperLimit() throws Exception {
		text.setText("1970-01-01");
		assertTrue(control.dateControl(text));
	}

	// Controllo DATA (limite superiore)
	@Test
	public void testDateLowerLimit() throws Exception {
		text.setText("2080-12-31");
		assertTrue(control.dateControl(text));
	}

	// Controllo DATA accettata
	@Test
	public void testDateAccepted() throws Exception {
		text.setText("2012-02-20");
		assertTrue(control.dateControl(text));
	}

	// Controllo E-MAIL con spazi
	@Test(expected = Exception.class)
	public void testEmailWithWhitespace() throws Exception {
		text.setText("lamiaemail@ac count.com");
		control.emailControl(text);
	}

	// Controllo E-MAIL in formato errato
	@Test(expected = Exception.class)
	public void testEmailNotAcceptedFormat() throws Exception {
		text.setText("l@amiaemail.account.lon.it");
		control.emailControl(text);
	}

	// Controllo E-MAIL con due "@"
	@Test(expected = Exception.class)
	public void testEmailWithTwoAt() throws Exception {
		text.setText("lamiaemail@acco@unt.long");
		control.emailControl(text);
	}

	// Controllo E-MAIL con '.' prima di '@'
	@Test(expected = Exception.class)
	public void testEmailWithDotBeforeAt() throws Exception {
		text.setText("lamiaemail.@account.dom");
		control.emailControl(text);
	}

	// Controllo E-MAIL con dominio di lunghezza maggiore di tre
	@Test(expected = Exception.class)
	public void testEmailWithNotAcceptedDom() throws Exception {
		text.setText("lamiaemail@account.long");
		control.emailControl(text);
	}

	// Controllo E-MAIL accettata del tipo "email@account.dom"
	@Test
	public void testEmailAccepted() throws Exception {
		text.setText("la_mia_email@account.dom");
		assertTrue(control.emailControl(text));
	}

	// Controllo E-MAIL accettata del tipo "email@acc.ount.dom"
	@Test
	public void testEmailAcceptedWhitDot() throws Exception {
		text.setText("lamiaemail@inserisco.ilpunto.dom");
		assertTrue(control.emailControl(text));
	}

	// Controllo NUMERO DI TELEFONO con caratteri non accettati
	@Test(expected = Exception.class)
	public void testPhoneNumberWhitLetters() throws Exception {
		text.setText("+33g3333333");
		control.phoneControl(text);
	}

	// Controllo NUMERO DI TELEFONO troppo corto
	@Test(expected = Exception.class)
	public void testPhoneNumberTooShort() throws Exception {
		text.setText("3333");
		control.phoneControl(text);
	}

	// Controllo NUMERO DI TELEFONO con prefisso
	@Test
	public void testPhoneNumberWhitPrefix() throws Exception {
		text.setText("+393334615154");
		assertTrue(control.phoneControl(text));
	}

	// Controllo NUMERO DI TELEFONO senza prefisso
	@Test
	public void testPhoneNumberWhitoutPrefix() throws Exception {
		text.setText("3334615154");
		assertTrue(control.phoneControl(text));
	}

	// Controllo INDIRIZZO in formato errato
	@Test(expected = Exception.class)
	public void testAddressNotAcceptedFormat() throws Exception {
		text.setText("2, Via Mario Rossi");
		control.addressControl(text);
	}

	// Controllo INDIRIZZO senza via
	@Test(expected = Exception.class)
	public void testAddressWithoutPrefix() throws Exception {
		text.setText("Mario Rossi,2");
		control.addressControl(text);
	}

	// Controllo INDIRIZZO senza numero civico
	@Test(expected = Exception.class)
	public void testAddressWithoutNumber() throws Exception {
		text.setText("Corso Mario Rossi");
		control.addressControl(text);
	}

	// Controllo INDIRIZZO solo numeri
	@Test(expected = Exception.class)
	public void testAddressOnlyNumbers() throws Exception {
		text.setText("Via 2222,2");
		control.addressControl(text);
	}

	// Controllo INDIRIZZO valido 1
	@Test
	public void testAddressAccepted1() throws Exception {
		text.setText("Contrada Sant'Antonio,8");
		assertTrue(control.addressControl(text));
	}

	// Controllo INDIRIZZO valido 2 (numero civico barrato)
	@Test
	public void testAddressAccepted2() throws Exception {
		text.setText("Via San Martino (traversa Viale Carducci), 3/C");
		assertTrue(control.addressControl(text));
	}

	// Controllo CODICE FISCALE con lunghezza errata
	@Test(expected = Exception.class)
	public void testCfTooLong() throws Exception {
		text.setText("DBRGLC95L03");
		control.cfControl(text);
	}

	// Controllo CODICE FISCALE con carattere per il mese non accettato
	@Test(expected = Exception.class)
	public void testCfWithAWrongChar() throws Exception {
		text.setText("DBRGLC95F03H926X");
		control.cfControl(text);
	}

	// Controllo CODICE FISCALE con giorno del mese errato
	@Test(expected = Exception.class)
	public void testCfWithWrongDay() throws Exception {
		text.setText("DBRGLC95L32H926X");
		control.cfControl(text);
	}

	// Controllo CODICE FISCALE con minuscole (deve essere accettato comunque)
	@Test
	public void testCfLowerCase() throws Exception {
		text.setText("dbrglc95l03h926x");
		assertTrue(control.cfControl(text));
	}

	// Controllo CODICE FISCALE valido
	@Test
	public void testCfAccepted() throws Exception {
		text.setText("DBRGLC95L31H987X");
		assertTrue(control.cfControl(text));
	}

	// Controllo ID nuovo dipendente con lettere
	@Test(expected = Exception.class)
	public void testIDDepWithLetters() throws Exception {
		text.setText("ser444");
		control.IDControl(text, Table.DIPENDENTE, "NuovoDipendente");
	}

	// Controllo ID nuova strumentazione con lettere
	@Test(expected = Exception.class)
	public void testIDToolWithLetters() throws Exception {
		text.setText("ser444");
		control.IDControl(text, Table.STRUMENTAZIONE, "NuovoDipendente");
	}

	// Controllo ID nuovo spazio con lettere
	@Test(expected = Exception.class)
	public void testIDSpaceWithLetters() throws Exception {
		text.setText("ser444");
		control.IDControl(text, Table.SPAZIO, "NuovoDipendente");
	}

	// Controllo ID nuovo dipendente con lettere
	@Test
	public void testIDDepAccepted() throws Exception {
		text.setText("634444");
		assertTrue(control.IDControl(text, Table.DIPENDENTE, "NuovoDipendente"));
	}

	// Controllo ID nuovo dipendente con lettere
	@Test
	public void testIDToolAccepted() throws Exception {
		text.setText("634444");
		assertTrue(control.IDControl(text, Table.STRUMENTAZIONE, "NuovoDipendente"));
	}

	// Controllo ID nuovo dipendente con lettere
	@Test
	public void testIDSpaceAccepted() throws Exception {
		text.setText("634444");
		assertTrue(control.IDControl(text, Table.SPAZIO, "NuovoDipendente"));
	}

	// Controllo ID nuovo dipendente duplicato
	@Test(expected = Exception.class)
	public void testIDDuplicated() throws Exception {
		String queryTester = "INSERT INTO mydipendente (Nome,Cognome,Sesso,Data_di_nascita,"
				+ "Mail,Telefono,Domicilio,Mansione,ID_Dipendente,CF)VALUES ('Gianluca', 'de Bartolo',"
				+ " 'M' , '1995-07-03', 'lr37@libero.it', '3314615156', 'via Rossi, 4', "
				+ "'Bidello', " + MATRICOLA + ", 'DBRGLC95L03H926G' );";
		DBManager db = DBManager.getInstance();
		db.query(queryTester);
		text.setText(MATRICOLA);
		control.IDControl(text, Table.DIPENDENTE, "NuovoDipendente");
	}

	//Controllo modifica ID dipendente con inserimento errato
	@Test(expected = Exception.class)
	public void testEditIDWrong() throws Exception {
		String queryTester = "INSERT INTO mydipendente (Nome,Cognome,Sesso,Data_di_nascita,"
				+ "Mail,Telefono,Domicilio,Mansione,ID_Dipendente,CF)VALUES ('Gianluca', 'de Bartolo',"
				+ " 'M' , '1995-07-03', 'lr37@libero.it', '3314615156', 'via Rossi, 4', "
				+ "'Bidello', " + MATRICOLA + ", 'DBRGLC95L03H926G' );";
		DBManager db = DBManager.getInstance();
		db.query(queryTester);
		text.setText("634");
		control.IDControl(text, Table.DIPENDENTE, "ModificaDipendente");
	}
	
	//Controllo modifica ID dipendente con inserimento valido
	@Test
	public void testEditIDAccepted() throws Exception {
		String queryTester = "INSERT INTO mydipendente (Nome,Cognome,Sesso,Data_di_nascita,"
				+ "Mail,Telefono,Domicilio,Mansione,ID_Dipendente,CF)VALUES ('Gianluca', 'de Bartolo',"
				+ " 'M' , '1995-07-03', 'lr37@libero.it', '3314615156', 'via Rossi, 4', "
				+ "'Bidello', " + MATRICOLA + ", 'DBRGLC95L03H926G' );";
		DBManager db = DBManager.getInstance();
		db.query(queryTester);
		text.setText("633333");
		assertTrue(control.IDControl(text, Table.DIPENDENTE, "ModificaDipendente"));
	}
	//Controllo campo non vuoto con stringa nulla
	@Test(expected = Exception.class)
	public void testNotEmptyString() throws Exception {
		text.setText("");
		control.notEmptyStringControl(text);
	}
	
	//Controllo campo non vuoto con stringa formata da uno spazio
	@Test(expected = Exception.class)
	public void testNotEmptyStringWithSpace() throws Exception {
		text.setText(" ");
		control.notEmptyStringControl(text);
	}
	
	//Controllo del campo con una stringa accettata
	@Test
	public void testNotEmptyStringCorrectField() throws Exception {
		text.setText("StringadiProva");
		assertTrue(control.notEmptyStringControl(text));
	}
	
	//Controllo numero unità possedute con un numero <0
	@Test(expected = Exception.class)
	public void testNegativeNumber() throws Exception {
		text.setText("-12");
		control.onlyNumFieldControl(text);
	}
	
//	//Controllo numero unità possedute con uno spazio vuoto
	@Test(expected = Exception.class)
	public void testEmptySpace() throws Exception {
		text.setText(" ");
		control.onlyNumFieldControl(text);
	}
	
	//Controllo numero unità possedute con una lettera
	@Test(expected = Exception.class)
	public void testLetter() throws Exception {
		text.setText("e");
		control.onlyNumFieldControl(text);
	}
	
	//Controllo numero unità possedute con un numero accettato
	@Test
	public void testCorrectNumber() throws Exception {
		text.setText("23");
		assertTrue(control.onlyNumFieldControl(text));
	}
}
