package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.*;

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
		System.out.println("シャッフル済カード（52枚）");
		for(int i = 0; i < cards.size(); i++) 
		{
			System.out.println(cards.get(i));
		}
		
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
		System.out.println("\nプレイヤー" + PLAYERS + "名に"+ INITIAL_CARDS +"枚ずつカードを配布する。");
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
		total.calc_card_sum(card, player1, player2);
		
		
		// 追加でカードを引く時
		// カードが格納されているリストの添え字
		int card_count = 8;
		additional_drawal(cards, card_count, player1, player2);
		
		/**
		 * 追加のカード引きの終了後
		 *  => 勝負の判定
		 */
		result_judgement(player1, player2);
						
		
		
	}
	
	/**
	 * 追加でカードを引く場合
	 * @param cards
	 * @param card_count
	 * @param player1
	 */
	public static void additional_drawal(List <Integer> cards, int card_count, List <Integer> player1, List <Integer> player2) {
		// 追加でカードを引くか選択する
		System.out.println("追加でカードを引きますか?? yes => 0 / no => 1");
		Scanner input = new Scanner(System.in);
		
		Card drawal = new Card();
		
		try 
		{		
			int answer = input.nextInt();			
		
			// 追加でカードを引く時
			// カードが格納されているリストの添え字 => Mainに移動
			if(answer == 0)
			{
				System.out.println("追加でカードを引きます。");	
				
				/**
				*  DEBUG
				*/
//				System.out.println(cards.get(card_count));
				
				System.out.print( "【 " + drawal.convert2SuitNum(cards.get(card_count)) + " 】 ");
				player1.add(drawal.convertTo1_13(cards.get(card_count)));
				
				/**
				 * playerのカードの合計値を計算する
				 */
				Calc_total total = new Calc_total();
				total.calc_card_sum(drawal, player1, player2);
				
				// 次のカードを引くとき用
				card_count++;
				
				/**
				 * 追加でカードを引く
				 */
				additional_drawal(cards, card_count, player1, player2);
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
	public static void result_judgement(List <Integer> player1, List <Integer> player2)
	{
		Card card = new Card();
//		List <Integer> cards = new ArrayList();
		Calc_total total = new Calc_total();
		
		/**
		 * Calc_total.javaからcalc_card_sum()を呼ぶ
		 * カードの合計値を取得する
		 */
		Calc player_sum = total.calc_card_sum(card, player1, player2);
		
		
		/**
		 * player1の合計点のみ【21】を超えた場合
		 */
		if(player_sum.player1_sum > 21 && player_sum.player2_sum <= 21)
		{
			System.out.println("合計値が21を超えたので、手札を引くのを終了します。\nお互いの点数を開示します。\n\n");
			System.out.println("player2の合計値は 【 " + player_sum.player2_sum + " 】 です。\n");
			System.out.println("あなたの負けです。");
		}
		
		/**
		 * player2の合計点のみ【21】を超えた場合
		 */
		if(player_sum.player1_sum <= 21 && player_sum.player2_sum > 21)
		{
			System.out.println("player2の合計値は 【 " + player_sum.player2_sum + " 】 です。\n");
			System.out.println("あなたの勝ちです。");
		}
		
		/**
		 * player1, 2の合計点が共に【21】を超える場合
		 */
		if(player_sum.player1_sum > 21 && player_sum.player2_sum > 21)
		{
			System.out.println("合計値が21を超えたので、手札を引くのを終了します。\nお互いの点数を開示します。\n\n");
			System.out.println("player2の合計値は 【 " + player_sum.player2_sum + " 】 です。\n");
			System.out.println("引き分けです。");			
		}
		
		/**
		 * player1, 2の合計点が共に【21】以下の場合
		 */
		if(player_sum.player1_sum <= 21 && player_sum.player2_sum <= 21)
		{
			System.out.println("player2の合計値は 【 " + player_sum.player2_sum + " 】 です。\n");
			
			// player1, 2の点数を比較
			if(player_sum.player1_sum > player_sum.player2_sum)
			{
				System.out.println("あなたの勝ちです。");			
			}
			else if(player_sum.player1_sum < player_sum.player2_sum)
			{
				System.out.println("あなたの負けです。");						
			}
			else
			{
				System.out.println("引き分けです。");			
			}
		}
		
	}
	
	

}


