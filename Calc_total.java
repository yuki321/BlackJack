package blackjack;

import java.util.ArrayList;
import java.util.List;


public class Calc_total {
	
/**
 *  playerのトランプの合計値を計算する
 * 
 */
	public Calc calc_card_sum(Card card, List <Integer> player1, List <Integer> player2 ) 
	{
		
		List <Integer> player1_card = player1;
		List <Integer> player2_card = player2;
		
		/**
		 * DEBUG
		 */
//		System.out.println(player1_card);
	
		Calc sum = new Calc();
		sum.player1_sum = 0;
		sum.player2_sum = 0;
		
		for(int i = 0; i < player1_card.size(); i++)
		{
			sum.player1_sum += card.convertTo1_13(player1_card.get(i));
		}
		System.out.println("player1の合計値は 【 " + sum.player1_sum + " 】 です。\n");
		
		for(int i = 0; i < player2_card.size(); i++)
		{
			sum.player2_sum += card.convertTo1_13(player2_card.get(i));
		}
		
		/**
		 * DEBUG用
		 * 普段は表示しない
		 */
//		System.out.println("player2の合計値は 【 " + sum.player2_sum + " 】 です。\n");
				
		return sum;
		
	}

	
	
}



