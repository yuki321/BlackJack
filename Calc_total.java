package blackjack;

import java.util.ArrayList;
import java.util.List;


public class Calc_total {
	
/**
 *  playerのトランプの合計値を計算する
 * 
 */
	public Calc calc_card_sum(Card card, List <Integer> player1, List <Integer> player2
			, List <Integer> player3, List <Integer> player4 ) 
	{
		// playerのリスト
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
		
		System.out.println("player1の合計値は 【 " + sum.player1_sum + " 】 です。\n");
				
		/**
		 * DEBUG用
		 * 普段は表示しない
		 */
//		System.out.println("player2の合計値は 【 " + sum.player2_sum + " 】 です。\n");
//		System.out.println("player3の合計値は 【 " + sum.player3_sum + " 】 です。\n");
//		System.out.println("player4の合計値は 【 " + sum.player4_sum + " 】 です。\n");
		
		System.out.println("\n*********************************************\n");
		return sum;
		
	}
	
	
}



