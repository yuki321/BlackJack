package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import blackjack.Card;


public class Main {

	public static void main(String[] args) {
		// CONSTANT
		// how many players 
		final int PLAYERS = 4;
		// how much cards is dealt at first
		final int INITIAL_CARDS = 2;
		
		
		System.out.println("ゲームスタート!!\nカード配布します。\n");
		
		List <Integer> cards = new ArrayList<>(52);
		for(int i = 1; i < 53; i++) 
		{
			cards.add(i);
		}
		
		// shuffle the List
		Collections.shuffle(cards);

/**
 *  ** For Debug **
 */
//		System.out.println("シャッフル済カード（52枚）");
//		for(int i = 0; i < cards.size(); i++) 
//		{
//			System.out.println(cards.get(i));
//		}
		
		List <Integer> player1 = new ArrayList();
		List <Integer> player2 = new ArrayList();
		List <Integer> player3 = new ArrayList();
		List <Integer> player4 = new ArrayList();

		Card card = new Card();
		
		// deal 2 cards per player(4x2)
		for(int i = 0; i < PLAYERS * INITIAL_CARDS; i++) 
		{	
			try 
			{				
				if	   ((i + 4) % 4 == 0) player1.add(cards.get(i));
				else if((i + 4) % 4 == 1) player2.add(cards.get(i));
				else if((i + 4) % 4 == 2) player3.add(cards.get(i));
				else if((i + 4) % 4 == 3) player4.add(cards.get(i));				
				else 
				{
					System.out.println("例外発生!!");
				}
											
			}
			catch(IndexOutOfBoundsException e) 
			{
				System.out.println("例外発生!!");
				e.getStackTrace();
			}
						
		}
		
		
		
/**
 *  ** For Debug **
 */
//		System.out.println("\nプレイヤー" + PLAYERS + "名に"+ INITIAL_CARDS +"枚ずつカードを配布する。");
		for(int i = 0; i < PLAYERS * INITIAL_CARDS; i++) 
		{
			System.out.println(cards.get(i));
		}
		
		// 引いたカードのスートを表示する。
		for(int i = 0; i < PLAYERS * INITIAL_CARDS; i++) 
		{
			if((i + 4) % 4 == 0) 
			{
				System.out.print( "【 " + card.convert2SuitNum(cards.get(i)) + " 】  です。");
			}
		}
				
		/**
		 * playerのカードの合計値を計算する
		 * Calc_total.javaからメソッドを呼び出す。
		 */
		Calc_total total = new Calc_total();
		total.calc_card_sum(card, player1, player2, player3, player4);
		
		
		// 追加でカードを引く時
		// カードが格納されているリストの添え字
		int card_count = 8;
		additional_drawal(card, cards, card_count, player1, player2, player3, player4);
				
	}
	
	/**
	 * 追加でカードを引く場合
	 * @param cards
	 * @param card_count
	 * @param player1
	 */
	public static void additional_drawal(Card card, List <Integer> cards, int card_count, List <Integer> player1, List <Integer> player2
			, List <Integer> player3, List <Integer> player4) {
		// 追加でカードを引くか選択する
		System.out.println("追加でカードを引きますか?? yes => 0 / no => 1");
		Scanner input = new Scanner(System.in);

		Card drawal = new Card();
		
		try 
		{		
			int answer = input.nextInt();			

			// draw cards additionally
			// Index of cards to draw cards additionally
			if(answer == 0)
			{
				System.out.println("追加でカードを引きます。");	
				
				/**
				*  DEBUG ↓↓↓
				*/
//				System.out.println(cards.get(card_count));
				
				System.out.print( "【 " + drawal.convert2SuitNum(cards.get(card_count)) + " 】 ");
				player1.add(drawal.convertTo1_13(cards.get(card_count)));
				
				/**
				 * playerのカードの合計値を計算する
				 */
				Calc_total total = new Calc_total();
				total.calc_card_sum(drawal, player1, player2, player3, player4);
			
				
				/**
				 * カード合計値計算後、player1の合計値が【21】を超える場合
				 * Calc_total.javaからcalc_card_sum()を呼ぶ
				 * 
				 */
				Calc player_sum = total.calc_card_sum(card, player1, player2, player3, player4);
				if(player_sum.player1_sum > 21)
				{
					/**
					 * 追加のカード引きの終了後
					 *  => 勝負の判定
					 */
					result_judgement(player1, player2, player3, player4);
					
					return;
				}
				
				// when player draw cards additionally
				card_count++;
				
				/**
				 * 追加でカードを引く
				 */
				additional_drawal(card, cards, card_count, player1, player2, player3, player4);
			
			}
			// No additional card
			else
			{
				result_judgement(player1, player2, player3, player4);
				return;
			}
				
		
		}
		catch(InputMismatchException e) 
		{
			System.out.println("型が違います：" + e);
		}
		finally
		{
	        input.close();
	    }
	
	}
	// END OF additional_drawal
	
	/**
	 * 結果を判定するメソッド
	 */
	public static void result_judgement(List <Integer> player1, List <Integer> player2
			, List <Integer> player3, List <Integer> player4)
	{
		Card card = new Card();
		Calc_total total = new Calc_total();
		
		/**
		 * Calc_total.javaからcalc_card_sum()を呼ぶ
		 * カードの合計値を取得する
		 */
		Calc player_sum = total.calc_card_sum(card, player1, player2, player3, player4);
		
		/**
		 *  player2-4の最大値
		 *  player2-4の値で21を超えるものがあれば、
		 *  　  その値に0が代入される 
		 *   => player1の値と比較
		 *   
		 */
		int[] sum_max = {player_sum.player2_sum, player_sum.player3_sum, player_sum.player4_sum};
		int max = sum_max[0];
		
		
		for(int i = 0; i < sum_max.length; i++)
		{
			if(sum_max[i] > 21)
			{
				sum_max[i] = 0;
			}
			max = Math.max(max, sum_max[i]);
		}
		
		System.out.println("player2-4の最大値 = " + max + "\n");

				
		/**
		 *  player1とplayer2-4の最大値を比較
		 */
		if(player_sum.player1_sum > max) 
		{
			System.out.println("あなたの勝ちです。");
		}
		else if(player_sum.player1_sum < max)
		{
			System.out.println("あなたの負けです。");
		}
		else
		{
			System.out.println("引き分けです。");	
		}
		
		
	}
	
	

}


