package test;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.Controlli;

public class TestBlackBox {

	private Controlli control;
	private JTextField text;
	
	@Before
	public void setUp() throws Exception {
		control = new Controlli();
		text = new JTextField();
	}

	@After
	public void tearDown() throws Exception {
		control = null;
		text = null;
	}
	
	//Controllo USERNAME minore di 4 caratteri
	@Test (expected = Exception.class)
	public void testUserControlWithShortWord() throws Exception {
		text.setText("shr");
		control.userControl(text);
	}
	
	//Controllo USERNAME senza numeri
	@Test (expected = Exception.class)
	public void testUserControlWithoutNumbers() throws Exception {
		text.setText("usernamesenzanumeri");
		control.userControl(text);
	}
	
	//Controllo USERNAME senza lettere
	@Test (expected = Exception.class)
	public void testUserControlWithoutLetters() throws Exception {
		text.setText("33433433");
		control.userControl(text);
	}
	
	//Controllo USERNAME che termina con punto
	@Test (expected = Exception.class)
	public void testUserControlWithPoint() throws Exception {
		text.setText("conpunto3.");
		control.userControl(text);
	}
	
	//Controllo USERNAME valida
	@Test
	public void testUserControlWithAcceptedWord() throws Exception {
		text.setText("usernameValida33");
		assertTrue(control.userControl(text));
	}
	
	//Controllo SESSO non accettato
	@Test (expected = Exception.class)
	public void testSexControlNotAccepted() throws Exception {
		text.setText("NONVALIDO");
		control.sexControl(text);
	}

	//Controllo SESSO accettato
	@Test
	public void testSexControlAccepted() throws Exception {
		text.setText("M");
		assertTrue(control.sexControl(text));
	}
	
	//Controllo SESSO non accettato
	@Test (expected = Exception.class)
	public void testNameControlNotAccepted() throws Exception {
		text.setText("inizioconlaminuscola");
		control.nameControl(text);
	}

	//Controllo SESSO accettato
	@Test
	public void testNameControlAccepted() throws Exception {
		text.setText("Carlo");
		assertTrue(control.nameControl(text));
	}
	
	//Controllo SESSO non accettato
	@Test (expected = Exception.class)
	public void testSurnameControlNotAccepted() throws Exception {
		text.setText("ilmiocogn0m3");
		control.surnameControl(text);
	}

	//Controllo SESSO accettato
	@Test
	public void testSurnameControlAccepted() throws Exception {
		text.setText("de Bartolo");
		assertTrue(control.surnameControl(text));
	}
	

	//Controllo PASSWORD minore di 4 caratteri
	@Test (expected = Exception.class)
	public void testPasswordControlWithShortWord() throws Exception {
		text.setText("4sd");
		control.userControl(text);
	}

	//Controllo PASSWORD maggiore di 20 caratteri
	@Test (expected = Exception.class)
	public void testPasswordControlWithLongWord() throws Exception {
		text.setText("c0ntienepiudiv3nticaratteri");
		control.userControl(text);
	}
	
	//Controllo PASSWORD con almeno 1 numero e 1 lettera
	@Test (expected = Exception.class)
	public void testPasswordControlOneNumAndOneLett() throws Exception {
		text.setText("23121898");
		control.passwordControl(text);
	}
	
	//Controllo1 PASSWORD con almeno 1 numero e 1 lettera
	@Test (expected = Exception.class)
	public void test1PasswordControlOneNumAndOneLett() throws Exception {
		text.setText("password");
		control.passwordControl(text);
	}

	
}
