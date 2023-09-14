package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("What is your starting amount of money?");
		double startAmount = in.nextDouble();

		System.out.println("What is your win chance as a decimal?");
		double winChance = in.nextDouble();

		System.out.println("What is your win limit?");
		double winLimit = in.nextDouble();

		System.out.println("How many days do you want to simulate?");
		int totalSimulations = in.nextInt();

		// win or lose $1
		// stop if money is max or 0
		boolean ruin = false;
		boolean success = false;
		double currentMoney = startAmount;
		int x = 0;
		int plays = 0;
		double ruinTimes = 0;
		double successTimes = 0;
		double a = ((1-winChance)/winChance); 
		double expectedRuin = 0;
		
		while ((x+1) <= totalSimulations) {

			while (!ruin && !success) {

				double chance = Math.random();

				if (chance <= (winChance)) {
					currentMoney++;
					plays++;
				}
				else if (chance > (winChance)) {
					currentMoney--;
					plays++;
				}

				if (currentMoney == winLimit) {
					System.out.println("success");
					successTimes++;
					success = true;

				}

				if (currentMoney == 0) {
					System.out.println("ruin");
					ruinTimes++;
					ruin = true;

				}

				System.out.println(currentMoney);
			}
			
			System.out.println(plays);

			System.out.println("Simulation day: " + (x+1));

			x++;
			success = false;
			ruin = false; 
			currentMoney = startAmount;
			
			
		}
		
		
		if ((winChance) == 0.5)
		{
		expectedRuin = 1.0-(startAmount/winLimit);
		System.out.println(expectedRuin);
		}

		else
			expectedRuin = (Math.pow(a, startAmount)-(Math.pow(a, winLimit)))/(1.0 - Math.pow(a, winLimit));

		System.out.println("Ruin Rate: " + ruinTimes/x);
		System.out.println("expected ruin rate: " + expectedRuin);
		

	

}
	
}
