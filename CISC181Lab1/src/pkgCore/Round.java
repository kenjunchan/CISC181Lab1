package pkgCore;

import java.util.LinkedList;

public class Round {

	private int ComeOutScore;
	private eGameResult eGameResult;
	private LinkedList<Roll> rolls = new LinkedList<Roll>();

	public Round() {
		// TODO: Execute Come Out roll, value ComeOutScore
		int[] nats = {7,11};
		int[] craps = {2,3,12};
		Roll cOSR = new Roll();
		ComeOutScore = cOSR.getScore();
		rolls.add(cOSR);
		if (this.checkIsEquals(ComeOutScore, nats))
		{
			this.eGameResult = eGameResult.NATURAL;
		}
		else if (this.checkIsEquals(ComeOutScore, craps))
		{
			this.eGameResult = eGameResult.CRAPS;
		}
		// TODO: Create a loop that will execute a roll until point is made, or
		// seven-out
		else {
			Roll r;
			boolean isSevenOutOrPoint = false;
			while (isSevenOutOrPoint == false)
			{
				r = new Roll();
				rolls.add(r);
				if (r.getScore() == 7)
				{
					this.eGameResult = eGameResult.SEVEN_OUT;
					isSevenOutOrPoint = true;
				}
				if (r.getScore() == ComeOutScore)
				{
					this.eGameResult = eGameResult.POINT;
				}
			}
		}
		// TODO: value the eGameResult after the round is complete
	}

	public boolean checkIsEquals(int s, int[] arr)
	{
		boolean b = false;
		for (int x = 0; x < arr.length; x++)
		{
			if (s == arr[x])
			{
				b = true;
			}
		}
		return b;
	}
	public int getFirstScore()
	{
		return rolls.getFirst().getScore();
	}
	public int getLastScore()
	{
		return rolls.getLast().getScore();
	}
	public int RollCount() {
		// Return the roll count
		return rolls.size();
	}
	public eGameResult geteGameResult()
	{
		return this.eGameResult;
	}

}
