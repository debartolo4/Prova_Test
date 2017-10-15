package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.Controlli;
import enums.Table;

public class TestWhiteBox {

	Controlli c;

	@Before
	public void setUp() throws Exception {
		c = new Controlli();
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	// TEST WHITE BOX - getQuery - PERCORSO 1
	@Test(expected = Exception.class)
	public void testGetQueryPath1() throws Exception {
		ArrayList<JTextField> textField = new ArrayList<>();
		textField.add(new JTextField("ID_Eccezione"));
		String id = "666999";
		c.getQuery(textField, null, id);
	}

	// TEST WHITE BOX - getQuery - PERCORSO 2
	@Test
	public void testGetQueryPath2() throws Exception {
		ArrayList<JTextField> textField = new ArrayList<>();
		textField.add(new JTextField("666999"));
		Table t = Table.STRUMENTAZIONE;
		String field = "ID_Strumentazione";
		assertTrue(c.getQuery(textField, t, field)
				.equals("INSERT INTO strumentazione (ID_Strumentazione) VALUES ('666999');"));
	}

	// TEST WHITE BOX - getQuery - PERCORSO 3
	@Test
	public void testGetQueryPath3() throws Exception {
		ArrayList<JTextField> textField = new ArrayList<>();
		textField.add(new JTextField("666999"));
		Table t = Table.DIPENDENTE;
		String field = "ID_Dipendente";
		assertTrue(c.getQuery(textField, t, field).equals("INSERT INTO dipendente (ID_Dipendente) VALUES ('666999');"));
	}

	// TEST WHITE BOX - listUtility - PERCORSO 1
	@Test(expected = Exception.class)
	public void listUtilityTest1() throws Exception {
		ArrayList<String> a = null;
		String query = "SELECT ID_Dipendente FROM dipendente WHERE Nome = 'Nomeinesistente';";
		String id = "ID_Dipendente";

		c.listUtility(a, query, id);
	}

	// TEST WHITE BOX - listUtility - PERCORSO 2
	@Test
	public void listUtilityTest2() throws Exception {
		ArrayList<String> a = new ArrayList<>();
		ArrayList<String> b = new ArrayList<>();
		b.add("2");
		b.add("100001");
		b.add("123000");
		String query = "SELECT ID_Strumento FROM strumentazione;";
		String id = "ID_Strumento";

		assertTrue(c.listUtility(a, query, id).equals(b));
	}

}
