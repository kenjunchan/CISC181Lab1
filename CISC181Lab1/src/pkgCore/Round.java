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
		if (this.checkIsEquals(ComeOutScore, craps))
		{
			this.eGameResult = eGameResult.CRAPS;
		}
		// TODO: Create a loop that will execute a roll until point is made, or
		// seven-out
		Roll r;
		boolean isSevenOutOrPoint = false;
		// int[] points = {4,5,6,8,9,10};
		while (isSevenOutOrPoint == false && !(this.checkIsEquals(ComeOutScore, nats)) && !(this.checkIsEquals(ComeOutScore, craps)))
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
	public int RollCount() {
		// Return the roll count
		return rolls.size();
	}

}
