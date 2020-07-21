package blackjack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		player1 = null;
	}
	
	Card card = new Card();
	List <Integer> player1 = new ArrayList<Integer>();

	
	/**
	 * convert2Suitのテスト
	 */
	// DIAMOND
	@Test
	void convert2Suit_Test0() 
	{
		int num = 1;
		String kind = card.convert2Suit(num);
		if(num == 1)
		{
			assertEquals(kind, "DIAMOND");			
		}
		
	}
	// DIAMOND
	@Test
	void convert2Suit_Test12() 
	{
		int num = 13;
		String kind = card.convert2Suit(num);
		if(num == 13)
		{
			assertEquals(kind, "DIAMOND");			
		}
	}
	// HEART
	@Test
	void convert2Suit_Test13() 
	{
		int num = 14;
		String kind = card.convert2Suit(num);
		if(num == 14)
		{
			assertEquals(kind, "HEART");			
		}
	}
	// HEART
	@Test
	void convert2Suit_Test25() 
	{
		int num = 26;
		String kind = card.convert2Suit(num);
		if(num == 26)
		{
			assertEquals(kind, "HEART");			
		}
	}
	// SPADE
	@Test
	void convert2Suit_Test26() 
	{
		int num = 27;
		String kind = card.convert2Suit(num);
		if(num == 27)
		{
			assertEquals(kind, "SPADE");			
		}
	}
	// SPADE
	@Test
	void convert2Suit_Test38() 
	{
		int num = 39;
		String kind = card.convert2Suit(num);
		if(num == 39)
		{
			assertEquals(kind, "SPADE");			
		}
	}
	// CRUB
	@Test
	void convert2Suit_Test39() 
	{
		int num = 40;
		String kind = card.convert2Suit(num);
		if(num == 40)
		{
			assertEquals(kind, "CRUB");			
		}
	}
	// CRUB
	@Test
	void convert2Suit_Test51() 
	{
		int num = 52;
		String kind = card.convert2Suit(num);
		if(num == 52)
		{
			assertEquals(kind, "CRUB");			
		}
	}
	// 例外
	@Test
	void convert2Suit_TestException() 
	{
		int num = 53;
		String kind = card.convert2Suit(num);
		if(num == 53)
		{
			assertEquals(kind, "例外です!!");			
		}
	}
	@Test
	void convert2Suit_TestMinus() 
	{
		int num = -1;
		String kind = card.convert2Suit(num);
		if(num == -1)
		{
			assertEquals(kind, "例外です!!");			
		}
	}
	
	/**
	 * convertTo1_13(int num)のテスト
	 */
	@Test
	void convertTo1_13_Test1()
	{
		player1.add(card.convertTo1_13(1));
		assertEquals(1, player1.get(0));
	}
	@Test
	void convertTo1_13_Test11()
	{
		player1.add(card.convertTo1_13(11));
		assertEquals(10, player1.get(0));
	}
	@Test
	void convertTo1_13_Test12()
	{
		player1.add(card.convertTo1_13(12));
		assertEquals(10, player1.get(0));
	}
	@Test
	void convertTo1_13_Test13()
	{
		player1.add(card.convertTo1_13(13));
		assertEquals(10, player1.get(0));
	}
	@Test
	void convertTo1_13_Test14()
	{
		player1.add(card.convertTo1_13(14));
		assertEquals(1, player1.get(0));
	}
	@Test
	void convertTo1_13_Test25()
	{
		player1.add(card.convertTo1_13(25));
		assertEquals(10, player1.get(0));
	}
	@Test
	void convertTo1_13_Test26()
	{
		player1.add(card.convertTo1_13(26));
		assertEquals(10, player1.get(0));
	}
	@Test
	void convertTo1_13_Test27()
	{
		player1.add(card.convertTo1_13(27));
		assertEquals(1, player1.get(0));
	}
	@Test
	void convertTo1_13_Test38()
	{
		player1.add(card.convertTo1_13(38));
		assertEquals(10, player1.get(0));
	}
	@Test
	void convertTo1_13_Test39()
	{
		player1.add(card.convertTo1_13(39));
		assertEquals(10, player1.get(0));
	}
	@Test
	void convertTo1_13_Test40()
	{
		player1.add(card.convertTo1_13(40));
		assertEquals(1, player1.get(0));
	}
	@Test
	void convertTo1_13_Test50()
	{
		player1.add(card.convertTo1_13(50));
		assertEquals(10, player1.get(0));
	}
	@Test
	void convertTo1_13_Test52()
	{
		player1.add(card.convertTo1_13(52));
		assertEquals(10, player1.get(0));
	}
	
	@Test
	void convert2SuitNum_Test1()
	{
		String suit = card.convert2SuitNum(1);
		assertEquals("ダイヤの1", suit);
	}
	@Test
	void convert2SuitNum_Test13()
	{
		String suit = card.convert2SuitNum(13);
		assertEquals("ダイヤの13", suit);
	}
	@Test
	void convert2SuitNum_Test14()
	{
		String suit = card.convert2SuitNum(14);
		assertEquals("ハートの1", suit);
	}
	@Test
	void convert2SuitNum_Test26()
	{
		String suit = card.convert2SuitNum(26);
		assertEquals("ハートの13", suit);
	}
	@Test
	void convert2SuitNum_Test27()
	{
		String suit = card.convert2SuitNum(27);
		assertEquals("スペードの1", suit);
	}
	@Test
	void convert2SuitNum_Test39()
	{
		String suit = card.convert2SuitNum(39);
		assertEquals("スペードの13", suit);
	}
	@Test
	void convert2SuitNum_Test40()
	{
		String suit = card.convert2SuitNum(40);
		assertEquals("クローバーの1", suit);
	}
	@Test
	void convert2SuitNum_Test52()
	{
		String suit = card.convert2SuitNum(52);
		assertEquals("クローバーの13", suit);
	}
	
	// Exception
	@Test
	void convert2SuitNum_Test0()
	{
		String suit = card.convert2SuitNum(0);
		assertEquals("例外です!!", suit);
	}
	@Test
	void convert2SuitNum_TestMinus()
	{
		String suit = card.convert2SuitNum(-1);
		assertEquals("例外です!!", suit);
	}
	@Test
	void convert2SuitNum_Test100()
	{
		String suit = card.convert2SuitNum(100);
		assertEquals("例外です!!", suit);
	}

	
}



