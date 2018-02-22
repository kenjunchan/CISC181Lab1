package pkgTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Die;

public class DieTest {

	@Test
	public void TestDie() {

		for (int a = 0; a < 10000; a++) {
			Die d = new Die();
			// TODO: Make sure value of die is between 1 and 6.
			assertTrue(d.getDieValue() >= 1 && d.getDieValue() <= 6);
		}

	}

}
