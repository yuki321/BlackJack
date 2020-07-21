package blackjack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Calc_totalTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	
	Main main = new Main();
	Calc_total total = new Calc_total();
	List <Integer> cards = new ArrayList<>();
	Card card = new Card();
	
	
	// ÉäÉXÉgÇ…êîílÇäiî[
	List <Integer> player1 = Arrays.asList(11, 9);
	List <Integer> player2 = Arrays.asList(5, 6);
	List <Integer> player3 = Arrays.asList(10, 2);
	List <Integer> player4 = Arrays.asList(12, 12);
	
	// CONSTANT
	final int PLAYERS = 4;
	final int INITIAL_CARDS = 2;
	

	@Test
	void calc_card_sumTest1() 
	{
		Calc player_sum = total.calc_card_sum(card, player1, player2, player3, player4);
		assertEquals(player_sum.player1_sum, 19);
	}
	@Test
	void calc_card_sumTest2() 
	{
		Calc player_sum = total.calc_card_sum(card, player1, player2, player3, player4);
		assertEquals(player_sum.player2_sum, 11);
	}
	@Test
	void calc_card_sumTest3() 
	{
		Calc player_sum = total.calc_card_sum(card, player1, player2, player3, player4);
		assertEquals(player_sum.player3_sum, 12);
	}
	@Test
	void calc_card_sumTest4() 
	{
		Calc player_sum = total.calc_card_sum(card, player1, player2, player3, player4);
		assertEquals(player_sum.player4_sum, 20);
	}
	

}
