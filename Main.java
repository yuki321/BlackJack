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
		
		
		System.out.println("�Q�[���X�^�[�g!!\n�J�[�h�z�z���܂��B\n");
		
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
//		System.out.println("�V���b�t���σJ�[�h�i52���j");
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
					System.out.println("��O����!!");
				}
											
			}
			catch(IndexOutOfBoundsException e) 
			{
				System.out.println("��O����!!");
				e.getStackTrace();
			}
						
		}
		
		
		
/**
 *  ** For Debug **
 */
//		System.out.println("\n�v���C���[" + PLAYERS + "����"+ INITIAL_CARDS +"�����J�[�h��z�z����B");
		for(int i = 0; i < PLAYERS * INITIAL_CARDS; i++) 
		{
			System.out.println(cards.get(i));
		}
		
		// �������J�[�h�̃X�[�g��\������B
		for(int i = 0; i < PLAYERS * INITIAL_CARDS; i++) 
		{
			if((i + 4) % 4 == 0) 
			{
				System.out.print( "�y " + card.convert2SuitNum(cards.get(i)) + " �z  �ł��B");
			}
		}
				
		/**
		 * player�̃J�[�h�̍��v�l���v�Z����
		 * Calc_total.java���烁�\�b�h���Ăяo���B
		 */
		Calc_total total = new Calc_total();
		total.calc_card_sum(card, player1, player2, player3, player4);
		
		
		// �ǉ��ŃJ�[�h��������
		// �J�[�h���i�[����Ă��郊�X�g�̓Y����
		int card_count = 8;
		additional_drawal(card, cards, card_count, player1, player2, player3, player4);
				
	}
	
	/**
	 * �ǉ��ŃJ�[�h�������ꍇ
	 * @param cards
	 * @param card_count
	 * @param player1
	 */
	public static void additional_drawal(Card card, List <Integer> cards, int card_count, List <Integer> player1, List <Integer> player2
			, List <Integer> player3, List <Integer> player4) {
		// �ǉ��ŃJ�[�h���������I������
		System.out.println("�ǉ��ŃJ�[�h�������܂���?? yes => 0 / no => 1");
		Scanner input = new Scanner(System.in);

		Card drawal = new Card();
		
		try 
		{		
			int answer = input.nextInt();			

			// draw cards additionally
			// Index of cards to draw cards additionally
			if(answer == 0)
			{
				System.out.println("�ǉ��ŃJ�[�h�������܂��B");	
				
				/**
				*  DEBUG ������
				*/
//				System.out.println(cards.get(card_count));
				
				System.out.print( "�y " + drawal.convert2SuitNum(cards.get(card_count)) + " �z ");
				player1.add(drawal.convertTo1_13(cards.get(card_count)));
				
				/**
				 * player�̃J�[�h�̍��v�l���v�Z����
				 */
				Calc_total total = new Calc_total();
				total.calc_card_sum(drawal, player1, player2, player3, player4);
			
				
				/**
				 * �J�[�h���v�l�v�Z��Aplayer1�̍��v�l���y21�z�𒴂���ꍇ
				 * Calc_total.java����calc_card_sum()���Ă�
				 * 
				 */
				Calc player_sum = total.calc_card_sum(card, player1, player2, player3, player4);
				if(player_sum.player1_sum > 21)
				{
					/**
					 * �ǉ��̃J�[�h�����̏I����
					 *  => �����̔���
					 */
					result_judgement(player1, player2, player3, player4);
					
					return;
				}
				
				// when player draw cards additionally
				card_count++;
				
				/**
				 * �ǉ��ŃJ�[�h������
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
			System.out.println("�^���Ⴂ�܂��F" + e);
		}
		finally
		{
	        input.close();
	    }
	
	}
	// END OF additional_drawal
	
	/**
	 * ���ʂ𔻒肷�郁�\�b�h
	 */
	public static void result_judgement(List <Integer> player1, List <Integer> player2
			, List <Integer> player3, List <Integer> player4)
	{
		Card card = new Card();
		Calc_total total = new Calc_total();
		
		/**
		 * Calc_total.java����calc_card_sum()���Ă�
		 * �J�[�h�̍��v�l���擾����
		 */
		Calc player_sum = total.calc_card_sum(card, player1, player2, player3, player4);
		
		/**
		 *  player2-4�̍ő�l
		 *  player2-4�̒l��21�𒴂�����̂�����΁A
		 *  �@  ���̒l��0���������� 
		 *   => player1�̒l�Ɣ�r
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
		
		System.out.println("player2-4�̍ő�l = " + max + "\n");

				
		/**
		 *  player1��player2-4�̍ő�l���r
		 */
		if(player_sum.player1_sum > max) 
		{
			System.out.println("���Ȃ��̏����ł��B");
		}
		else if(player_sum.player1_sum < max)
		{
			System.out.println("���Ȃ��̕����ł��B");
		}
		else
		{
			System.out.println("���������ł��B");	
		}
		
		
	}
	
	

}


