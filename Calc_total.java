package blackjack;

import java.util.ArrayList;
import java.util.List;


public class Calc_total {
	
/**
 *  player�̃g�����v�̍��v�l���v�Z����
 * 
 */
	public Calc calc_card_sum(Card card, List <Integer> player1, List <Integer> player2
			, List <Integer> player3, List <Integer> player4 ) 
	{
		// player�̃��X�g
		List <Integer> player1_card = player1;
		List <Integer> player2_card = player2;
		List <Integer> player3_card = player3;
		List <Integer> player4_card = player4;
		
		/**
		 * DEBUG
		 */
//		System.out.println(player1_card);
	
		Calc sum = new Calc();
		sum.player1_sum = 0;
		sum.player2_sum = 0;
		sum.player3_sum = 0;
		sum.player4_sum = 0;
		
		
		for(int i = 0; i < player1_card.size(); i++)
		{
			sum.player1_sum += card.convertTo1_13(player1_card.get(i));
		}
		for(int i = 0; i < player2_card.size(); i++)
		{
			sum.player2_sum += card.convertTo1_13(player2_card.get(i));
		}
		for(int i = 0; i < player3_card.size(); i++)
		{
			sum.player3_sum += card.convertTo1_13(player3_card.get(i));
		}
		for(int i = 0; i < player4_card.size(); i++)
		{
			sum.player4_sum += card.convertTo1_13(player4_card.get(i));
		}
		
		System.out.println("player1�̍��v�l�� �y " + sum.player1_sum + " �z �ł��B\n");
				
		/**
		 * DEBUG�p
		 * ���i�͕\�����Ȃ�
		 */
//		System.out.println("player2�̍��v�l�� �y " + sum.player2_sum + " �z �ł��B\n");
//		System.out.println("player3�̍��v�l�� �y " + sum.player3_sum + " �z �ł��B\n");
//		System.out.println("player4�̍��v�l�� �y " + sum.player4_sum + " �z �ł��B\n");
		
		System.out.println("\n*********************************************\n");
		return sum;
		
	}
	
	
}



