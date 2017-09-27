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
		

}
