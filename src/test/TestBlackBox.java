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
	
	@Test (expected = Exception.class)
	public void testUserControlWithShortWord() throws Exception {
		text.setText("cia");
		control.userControl(text);
	}
	
	@Test
	public void testUserControlWithAcceptedWord() throws Exception {
		text.setText("ciao");
		assertTrue(control.userControl(text));
	}
	
	

}
