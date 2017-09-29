///**
// * 
// */
//package testMIchele;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.ArrayList;
//
//import javax.swing.JTextField;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import control.Controlli;
//import enums.Table;
//
///**
// * @author Bang
// *
// */
//public class TestWhiteBox {
//
//	private Controlli c;
//	ArrayList<String> list;
//	ArrayList<JTextField> query;
//	
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@Before
//	public void setUp() throws Exception {
//		c = new Controlli();
//		list = new ArrayList<>();
//		query = new ArrayList<>();
//	}
//
//	@Test
//	public void testQuery() throws Exception {
//	    JTextField jt1= new JTextField("Bianca");
//	    query.add(jt1);
//	    JTextField jt2= new JTextField("Arno");
//	    query.add(jt2);
//	    JTextField jt3= new JTextField("F");
//	    query.add(jt3);
//	    JTextField jt4= new JTextField("1995-07-08");
//	    query.add(jt4);
//	    JTextField jt5= new JTextField("bianca@gmail.com");
//	    query.add(jt5);
//	    JTextField jt6= new JTextField("08047575758");
//	    query.add(jt6);
//	    JTextField jt7= new JTextField("via puccia");
//	    query.add(jt7);
//	    JTextField jt8= new JTextField("lavapiatti");
//	    query.add(jt8);
//	    JTextField jt9= new JTextField("109753");
//	    query.add(jt9);
//	    JTextField jt10= new JTextField("RNABCT121818");
//	    query.add(jt10);
//	    
//	    assertNotNull(c.getQuery(query, Table.DIPENDENTE, "nome", "cognome",
//				"sesso", "data_di_nascita", "mail", "telefono", "domicilio", "mansione", 
//				"ID_Dipendente", "cf" ));
//	}
//
//	@Test
//	public void testListUtilityDipendente(){
//		
//		try {
//			assertEquals(list , c.listUtility(list, "SELECT ID_Dipendente from mydipendente",
//					"ID_Dipendente"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testListUtilitySpazio(){
//		
//		try {
//			assertEquals(list , c.listUtility(list, "SELECT ID_Spazio from myspazio",
//					"ID_Spazio"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	@Test
//	public void testListUtilityStrumentazione(){
//		
//		try {
//			assertEquals(list , c.listUtility(list, "SELECT ID_Strumento from mystrumentazione",
//					"ID_Strumento"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	@Test (expected = Exception.class)
//	public void testExceptionDipendente() throws Exception {
//		c.listUtility(list, "SELECT ID_Dipendente from mydipendente" , "134");
//	}
//	
//	@Test (expected = Exception.class)
//	public void testExceptionSpazio() throws Exception {
//		c.listUtility(list, "SELECT ID_Spazio from myspazio" , "3456");
//	}
//
//	@Test (expected = Exception.class)
//	public void testExceptionStrumentazione() throws Exception {
//		c.listUtility(list, "SELECT ID_Strumento from mystrumentazione" , "1234");
//	}
//	
//	
//	
//}
