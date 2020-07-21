package blackjack;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.Ignore;

class MainTest {

	/**
	 * �e�X�g���s�O�̏����i�e�e�X�g���ʂ̏����j
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		// 52���̃g�����v�����X�g�Ɋi�[
		for(int i = 0; i < 52; i++)
		{
			cards.add(i);
		}
		
		// player�Ɋe2���̃J�[�h��z�z�i���X�g�Ɋi�[�����j
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
		
	}
	
	// Test�I����̏���
	@AfterEach
	void tearDown() throws Exception {
		cards = null;
		player1 = null;
		player2 = null;
		player3 = null;
		player4 = null;
		
		System.setOut(null);
	}
	
	
	Main main = new Main();
	List <Integer> cards = new ArrayList<>(52);
	List <Integer> player1 = new ArrayList<Integer>();
	List <Integer> player2 = new ArrayList<Integer>();
	List <Integer> player3 = new ArrayList<Integer>();
	List <Integer> player4 = new ArrayList<Integer>();
	
	Card card = new Card();
	Calc_total total = new Calc_total();
	
	// CONSTANT
	// how many players 
	final int PLAYERS = 4;
	// how much cards is dealt at first
	final int INITIAL_CARDS = 2;

	/**
	 * ���X�g�̃T�C�Y��52�ɂȂ邩�e�X�g
	 */
	@Test
	void cardsListTotaltest() 
	{
		assertEquals(52, cards.size());
	}
	
	
	/**
	 * �eplayer�ɁA���ꂼ��2�����z�z����邩�e�X�g
	 */
	@Test
	void deal2Cards_for_4Players()
	{	
		assertEquals(2, player1.size());
		assertEquals(2, player2.size());
		assertEquals(2, player3.size());
		assertEquals(2, player4.size());
		
	}
	
	
	/**
	 * Main.java��additional drawal���\�b�h���s��A
	 * �z�z���ꂽ�J�[�h�����v3���ɂȂ��Ă��邩���e�X�g
	 */
	@Test
	void additional_drawalTest()
	{
		int card_count = 8;
		player1.add(card.convertTo1_13(cards.get(card_count)));
		
		assertEquals(3, player1.size());
	}
	
	
	
	
	
	
	
	

}
