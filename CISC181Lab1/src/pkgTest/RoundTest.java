package pkgTest;

import static org.junit.Assert.*;
import org.junit.Test;
import pkgCore.Round;
import pkgCore.eGameResult;

public class RoundTest {

	@Test
	public void test()
	{
		for(int x = 0; x<10000; x++)
		{
			Round testRound = new Round();
			
			if((testRound.RollCount() == 1) && ((testRound.getFirstScore() == 7) ||(testRound.getFirstScore() == 11)))
			{
				assertEquals(testRound.geteGameResult(), eGameResult.NATURAL);
			}
			else if((testRound.RollCount() == 1) && ((testRound.getFirstScore() == 2) ||(testRound.getFirstScore() == 3) || (testRound.getFirstScore() == 12)))
			{
				assertEquals(testRound.geteGameResult(), eGameResult.CRAPS);
			}
			else if((testRound.RollCount() > 1) && (testRound.getFirstScore() == testRound.getLastScore()))
			{
				assertEquals(testRound.geteGameResult(), eGameResult.POINT);
			}
			else if((testRound.RollCount() > 1) && (testRound.getLastScore() == 7))
			{
				assertEquals(testRound.geteGameResult(), eGameResult.SEVEN_OUT);
			}
		}
	}
}
