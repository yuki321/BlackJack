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
		System.out.println("�V���b�t���σJ�[�h�i52���j");
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
		System.out.println("\n�v���C���[" + PLAYERS + "����"+ INITIAL_CARDS +"�����J�[�h��z�z����B");
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
		total.calc_card_sum(card, player1, player2);
		
		
		// �ǉ��ŃJ�[�h��������
		// �J�[�h���i�[����Ă��郊�X�g�̓Y����
		int card_count = 8;
		additional_drawal(cards, card_count, player1, player2);
		
		/**
		 * �ǉ��̃J�[�h�����̏I����
		 *  => �����̔���
		 */
		result_judgement(player1, player2);
						
		
		
	}
	
	/**
	 * �ǉ��ŃJ�[�h�������ꍇ
	 * @param cards
	 * @param card_count
	 * @param player1
	 */
	public static void additional_drawal(List <Integer> cards, int card_count, List <Integer> player1, List <Integer> player2) {
		// �ǉ��ŃJ�[�h���������I������
		System.out.println("�ǉ��ŃJ�[�h�������܂���?? yes => 0 / no => 1");
		Scanner input = new Scanner(System.in);
		
		Card drawal = new Card();
		
		try 
		{		
			int answer = input.nextInt();			
		
			// �ǉ��ŃJ�[�h��������
			// �J�[�h���i�[����Ă��郊�X�g�̓Y���� => Main�Ɉړ�
			if(answer == 0)
			{
				System.out.println("�ǉ��ŃJ�[�h�������܂��B");	
				
				/**
				*  DEBUG
				*/
//				System.out.println(cards.get(card_count));
				
				System.out.print( "�y " + drawal.convert2SuitNum(cards.get(card_count)) + " �z ");
				player1.add(drawal.convertTo1_13(cards.get(card_count)));
				
				/**
				 * player�̃J�[�h�̍��v�l���v�Z����
				 */
				Calc_total total = new Calc_total();
				total.calc_card_sum(drawal, player1, player2);
				
				// ���̃J�[�h�������Ƃ��p
				card_count++;
				
				/**
				 * �ǉ��ŃJ�[�h������
				 */
				additional_drawal(cards, card_count, player1, player2);
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
	public static void result_judgement(List <Integer> player1, List <Integer> player2)
	{
		Card card = new Card();
//		List <Integer> cards = new ArrayList();
		Calc_total total = new Calc_total();
		
		/**
		 * Calc_total.java����calc_card_sum()���Ă�
		 * �J�[�h�̍��v�l���擾����
		 */
		Calc player_sum = total.calc_card_sum(card, player1, player2);
		
		
		/**
		 * player1�̍��v�_�̂݁y21�z�𒴂����ꍇ
		 */
		if(player_sum.player1_sum > 21 && player_sum.player2_sum <= 21)
		{
			System.out.println("���v�l��21�𒴂����̂ŁA��D�������̂��I�����܂��B\n���݂��̓_�����J�����܂��B\n\n");
			System.out.println("player2�̍��v�l�� �y " + player_sum.player2_sum + " �z �ł��B\n");
			System.out.println("���Ȃ��̕����ł��B");
		}
		
		/**
		 * player2�̍��v�_�̂݁y21�z�𒴂����ꍇ
		 */
		if(player_sum.player1_sum <= 21 && player_sum.player2_sum > 21)
		{
			System.out.println("player2�̍��v�l�� �y " + player_sum.player2_sum + " �z �ł��B\n");
			System.out.println("���Ȃ��̏����ł��B");
		}
		
		/**
		 * player1, 2�̍��v�_�����Ɂy21�z�𒴂���ꍇ
		 */
		if(player_sum.player1_sum > 21 && player_sum.player2_sum > 21)
		{
			System.out.println("���v�l��21�𒴂����̂ŁA��D�������̂��I�����܂��B\n���݂��̓_�����J�����܂��B\n\n");
			System.out.println("player2�̍��v�l�� �y " + player_sum.player2_sum + " �z �ł��B\n");
			System.out.println("���������ł��B");			
		}
		
		/**
		 * player1, 2�̍��v�_�����Ɂy21�z�ȉ��̏ꍇ
		 */
		if(player_sum.player1_sum <= 21 && player_sum.player2_sum <= 21)
		{
			System.out.println("player2�̍��v�l�� �y " + player_sum.player2_sum + " �z �ł��B\n");
			
			// player1, 2�̓_�����r
			if(player_sum.player1_sum > player_sum.player2_sum)
			{
				System.out.println("���Ȃ��̏����ł��B");			
			}
			else if(player_sum.player1_sum < player_sum.player2_sum)
			{
				System.out.println("���Ȃ��̕����ł��B");						
			}
			else
			{
				System.out.println("���������ł��B");			
			}
		}
		
	}
	
	

}


