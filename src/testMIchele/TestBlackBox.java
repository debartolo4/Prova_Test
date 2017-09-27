package testMIchele;

import static org.junit.Assert.assertTrue;

import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.Controlli;
import enums.Table;

public class TestBlackBox {

	private Controlli c;
	JTextField jt;
	
	@Before
	public void setUp() throws Exception {
		c = new Controlli();
		jt = new JTextField();
	}

	@After
	public void tearDown() throws Exception {
		c = null;
		jt = null;
	}

	@Test
	public void testUserFourCharacter() throws Exception {
		assertTrue(c.controlUser("ci_1"));
	}
	
	@Test
	public void testUser20Character() throws Exception {
		assertTrue(c.controlUser("sonoesattamentevent1"));
	}
	
	@Test 
	public void testUserOnlyNumber() throws Exception {
		c.controlUser("1234");
	}
	
	@Test 
	public void testUserWithoutNumber() throws Exception {
		c.controlUser("ciaoo");
	}
	
	@Test (expected = Exception.class)
	public void testUserlessFourCharacter() throws Exception {
		c.controlUser("ci1");
	}
	
	@Test (expected = Exception.class)
	public void testUserMore20Character() throws Exception {
		c.controlUser("ventunofumaturedic1ao");
	}
	
	@Test (expected = Exception.class)
	public void testUserWithSpace() throws Exception {
		c.controlUser("ciao _5");
	}
	
	@Test
	public void testPasswordFourCharacter() throws Exception {
		assertTrue(c.controlPassword("Password_1"));
	}
	
	@Test
	public void testPassword20Character() throws Exception {
		assertTrue(c.controlPassword("Sonoesattamentevent1"));
	}
	
	@Test (expected = Exception.class)
	public void testPasswordOnlyNumber() throws Exception {
		c.controlPassword("1234");
	}
	
	@Test (expected = Exception.class)
	public void testPasswordWithoutNumber() throws Exception {
		c.controlPassword("ciaoo");
	}
	
	@Test (expected = Exception.class)
	public void testPasswordlessFourCharacter() throws Exception {
		c.controlPassword("ci1");
	}
	
	@Test (expected = Exception.class)
	public void testPasswordMore20Character() throws Exception {
		c.controlPassword("ventunofumaturedic1ao");
	}
	
	@Test (expected = Exception.class)
	public void testPasswordWithSpace() throws Exception {
		c.controlPassword("ciao _5");
	}
	
	@Test
	public void testControlID() throws Exception {
		jt.setText("123456");
		assertTrue(c.controlId(jt,Table.DIPENDENTE));
	}
	
	@Test (expected = Exception.class)
	public void testControlIDLessSixDigit() throws Exception {
		jt.setText("12345");
		c.controlId(jt,Table.DIPENDENTE);
	}
	
	@Test (expected = Exception.class)
	public void testControlIDMoreSixDigit() throws Exception {
		jt.setText("1234567");
		c.controlId(jt,Table.DIPENDENTE);
	}
	
	@Test (expected = Exception.class)
	public void testIDWithChar() throws Exception {
		jt.setText("12345d");
		c.controlId(jt,Table.DIPENDENTE);
	}
		
	@Test 
	public void testControlChar() throws Exception {
		jt.setText("char ex");
		c.controlChar(jt);
	}
	
	@Test 
	public void testControlCharWithSpace() throws Exception {
		jt.setText("char ex");
		c.controlChar(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlCharWithSpecialChar() throws Exception {
		jt.setText("char_ex");
		c.controlChar(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlCharWithDigit() throws Exception {
		jt.setText("char_1");
		c.controlChar(jt);
	}
	
	@Test 
	public void testControlSex() throws Exception {
		jt.setText("F");
		c.controlSex(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlSexOtherChar() throws Exception {
		jt.setText("D");
		c.controlSex(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlSexSpace() throws Exception {
		jt.setText("M ");
		c.controlSex(jt);
	}
	
	@Test
	public void testControlDateCapodanno() throws Exception {
		jt.setText("1950-01-01");
		assertTrue(c.controlDate(jt));
	}

	@Test
	public void testControlDateUltimo() throws Exception {
		jt.setText("2017-12-31");
		assertTrue(c.controlDate(jt));
	}
	
	@Test
	public void testControlDate28th02() throws Exception {
		jt.setText("1993-02-28");
		c.controlDate(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlDateWithoutScore() throws Exception {
		jt.setText("19930230");
		c.controlDate(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlDateDDMMYYYY() throws Exception {
		jt.setText("30-02-1997");
		c.controlDate(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlDateFuture() throws Exception {
		jt.setText("3000-60-60");
		c.controlDate(jt);
	}
	
	@Test
	public void testControlEmail() throws Exception {
		jt.setText("mdipede3@studentiuniba.it");
		c.controlEmail(jt);
	}
	
	@Test
	public void testControlEmailWithPoint() throws Exception {
		jt.setText("m.dipede3@studenti.uniba.it");
		c.controlEmail(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlEmailWithoutAtSign() throws Exception {
		jt.setText("m.dipede3studentiuniba.iti");
		c.controlEmail(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlEmailWithoutFinalpoint() throws Exception {
		jt.setText("m.dipede3@studentiunibaiti");
		c.controlEmail(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlEmail4WordAfterFinalPoint() throws Exception {
		jt.setText("m.dipede3@studentiunib.aiti");
		c.controlEmail(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlEmailNoWordAfterPoint() throws Exception {
		jt.setText("m.@studentiunib.iti");
		c.controlEmail(jt);
	}
	
	@Test 
	public void testControlPhoneNumberOnlyDigit() throws Exception {
		jt.setText("0987654322");
		c.controlPhoneNumber(jt);
	}
	
	@Test 
	public void testControlPhoneNumberSpace() throws Exception {
		jt.setText("098 765 4322");
		c.controlPhoneNumber(jt);
	}
	
	@Test 
	public void testControlPhoneNumberWithScore() throws Exception {
		jt.setText("098-765-4322");
		c.controlPhoneNumber(jt);
	}
	
	@Test 
	public void testControlPhoneNumberPoint() throws Exception {
		jt.setText("098.765.4322");
		c.controlPhoneNumber(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlPhoneNumberMoreTenDigit() throws Exception {
		jt.setText("02192302129");
		c.controlPhoneNumber(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlPhoneNumberLessTenDigit() throws Exception {
		jt.setText("001234567");
		c.controlPhoneNumber(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlPhoneNumberOnlyOneSpace() throws Exception {
		jt.setText("0 23456789");
		c.controlPhoneNumber(jt);
	}
	
	@Test
	public void testControlCf() throws Exception {
		jt.setText("asdqwezxcrjyfg22");
		c.controlCf(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlCf15char() throws Exception {
		jt.setText("qwertyuiopasd22");
		c.controlCf(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlCf17char() throws Exception {
		jt.setText("qwertyuiopasdfg11");
		c.controlCf(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlCfSpecialChar() throws Exception {
		jt.setText("qwertyuiopasdfg@");
		c.controlCf(jt);
	}
	
	@Test
	public void testControlAddressVia() throws Exception {
		jt.setText("via cacca");
		c.controlAddress(jt);
	}
	
	@Test
	public void testControlAddressViale() throws Exception {
		jt.setText("viale caccia");
		c.controlAddress(jt);
	}
	
	@Test
	public void testControlAddressCorso() throws Exception {
		jt.setText("corso caccia");
		c.controlAddress(jt);
	}
	
	@Test
	public void testControlAddressCorte() throws Exception {
		jt.setText("corte caccia");
		c.controlAddress(jt);
	}
	
	@Test
	public void testControlAddressPiazza() throws Exception {
		jt.setText("piazza caccia");
		assertTrue(c.controlAddress(jt));
	}
	
	@Test (expected = Exception.class)
	public void testControlAddressOnlyVia() throws Exception {
		jt.setText("via");
		c.controlAddress(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlAddressOnlyViaAndSpace() throws Exception {
		jt.setText("via ");
		c.controlAddress(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlAddressOtherName() throws Exception {
		jt.setText("skdfjsdkfl");
		c.controlAddress(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlAddressSpecialChar() throws Exception {
		jt.setText("corte caccia@");
		c.controlAddress(jt);
	}
	
	@Test
	public void testControlNUnit‡1() throws Exception {
		jt.setText("1");
		c.controlNUnit‡(jt);
	}
	
	@Test
	public void testControlNUnit‡99() throws Exception {
		jt.setText("1");
		c.controlNUnit‡(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlNUnit‡0() throws Exception {
		jt.setText("0");
		c.controlNUnit‡(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlNUnit‡100() throws Exception {
		jt.setText("100");
		c.controlNUnit‡(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlNUnit‡Space() throws Exception {
		jt.setText("8 0");
		c.controlNUnit‡(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlNUnit‡SpecialCharacter() throws Exception {
		jt.setText("1_0_0");
		c.controlNUnit‡(jt);
	}
	
	@Test 
	public void testControlYear1951() throws Exception {
		jt.setText("1951");
		c.controlYear(jt);
	}

	@Test 
	public void testControlYear2017() throws Exception {
		jt.setText("2017");
		c.controlYear(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlYear2018() throws Exception {
		jt.setText("2018");
		c.controlYear(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlYear1950() throws Exception {
		jt.setText("1950");
		c.controlYear(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlYearSpecialCharacter() throws Exception {
		jt.setText("1952_");
		c.controlYear(jt);
	}
	
	@Test (expected = Exception.class)
	public void testControlYearSpace() throws Exception {
		jt.setText("1 9 5 2");
		c.controlYear(jt);
	}	
	
}