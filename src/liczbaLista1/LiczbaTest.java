package liczbaLista1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class LiczbaTest {

	private int liczbaDoKonwersji;
	Liczba liczba;

	@Before
	public void setUp() throws Exception {
		this.liczbaDoKonwersji = 16;
		liczba = new Liczba(liczbaDoKonwersji);
	}

	@After
	public void tearDown() throws Exception {
		liczba = null;
	}

	@Test(expected = LiczbaException.class)
	public final void testPoprawnoscWyjatkuJesliTworzonyJestObiektDlaDlaNieprawidlowegoParametru() throws LiczbaException {
		int nieprawidłowaLiczba = -1;
		try {
			liczba = new Liczba(nieprawidłowaLiczba);
		} catch (Exception e) {
			// poszedl wyjatek czyli to czego oczekujemy
			if (!(e instanceof LiczbaException)) {
				fail("Konstruktor rzucił nieoczekiwany wyjatek");
			}
		}
	}

	@Test
	public final void testPoprawnoscUtowrzenieObiektuLiczbyDlaPrawidlowegoParametru() throws LiczbaException {
		int proprawnaLiczbaDoKonwersji = 123;
		liczba = new Liczba(proprawnaLiczbaDoKonwersji);
		assertNotNull(liczba);
	}

	@Ignore
	public final void testKonwersjaNaSzstemBinarny() {
		int system = 2;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertTrue(wynikKonwersji.equals("10000"));
	}


	@Test(timeout = 999)
	public final void testKonwersjaNaSzstemTrójkowyDlaBardzoDuzejLiczby() throws LiczbaException {
		liczba = new Liczba(Integer.MAX_VALUE);
		int system = 2;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertEquals("1111111111111111111111111111111", wynikKonwersji);
	}

	@Ignore
	public final void testKonwersjaNaSzstemCzworkowy() {
		int system = 4;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);// odp.100
		assertFalse(wynikKonwersji.equals("24"));
	}

	@Test
	public final void testKonwersjaNaSzstemPiatkowy() {
		int system = 5;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertEquals("31", wynikKonwersji);
	}

	@Test
	public final void testKonwersjiNaSystemSzostkowy() {
		int system = 6;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);// odp.24
		assertFalse(wynikKonwersji.equals("23"));
	}

	@Test
	public final void testKonwersjaNaSzstemSiodemkowy() {
		int system = 7;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertTrue(wynikKonwersji.equals("22"));
	}

	@Test
	public final void testKonwersjaNaSzstemOsemkowy() {
		int system = 8;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertTrue(wynikKonwersji.equals("20"));
	}

	@Test
	public final void testKonwersjaNaSzstemDziewiatkowy() {
		int system = 9;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertEquals("17", wynikKonwersji);
	}

	@Test
	public final void testKonwersjaNaSzstemDziesiatkowy() {
		int system = 10;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertTrue(wynikKonwersji.equals("16"));
	}

	@Test
	public final void testKonwersjaNaSzstemJedenastkowy() {
		int system = 11;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertTrue(wynikKonwersji.equals("15"));
	}

	@Test
	public final void testKonwersjaNaSzstemDwunastkowy() {
		int system = 12;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertEquals("14", wynikKonwersji);
	}

	@Test
	public final void testKonwersjaNaSzstemTrzynastkowy() {
		int system = 13;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertFalse(wynikKonwersji.equals("10"));
	}

	@Test
	public final void testKonwersjaNaSzstemCznernastkowy() {
		int system = 14;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);// odp.12
		assertFalse(wynikKonwersji.equals("10"));
	}

	@Test
	public final void testKonwersjaNaSzstemPietnastkowy() {
		int system = 15;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertEquals("11", wynikKonwersji);
	}

	@Test
	public final void testKonwersjaNaSzstemSzesnastkowy() {
		int system = 16;
		String wynikKonwersji = liczba.konwersjaNaInnySystem(system);
		assertEquals("10", wynikKonwersji);
	}


}
