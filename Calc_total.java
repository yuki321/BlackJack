package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Calc_total {

/**
 *  player�̃g�����v�̍��v�l���v�Z����
 * 
 */
	public int calc_card_sum(Card card, List <Integer> player1) 
	{
		
		List <Integer> player1_card = player1;
		
		/**
		 * DEBUG
		 */
		System.out.println(player1_card);
	
		int sum = 0;
		for(int i = 0; i < player1_card.size(); i++)
		{
			sum += card.convertTo1_13(player1_card.get(i));
		}
		System.out.println("���v�l�� �y " + sum + " �z �ł��B\n");
				
		return sum;
	}

	
		

}



