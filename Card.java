package blackjack;

public class Card {
	/**
	 * suit DIAMOND / HEART / SPADE / CRUB
	 * rank 1-10 / Jack / Queen / King
	 */
	
	
	/**
	 * 1-52の数値表記をrankとsuit
	  *    による表記に変換する
	 * EX) 「HEARTのQUEEN」
	 * 
	 *  2段階に分けて変換する
	  *   
	 * 1-13 => DIAMOND
	   14-26 => HEART
	   27-39 => SPADE
	   40-52 => CRUB
	 */
	static int DIAMOND = 0;
	static int HEART   = 1;
	static int SPADE   = 2;
	static int CRUB    = 3;
	
	String convert2SuitNum(int num)
	{
		// convert2Suitを呼び出し、カードの種類を入れる
		String kind = convert2Suit(num);
		int cardNum;
		
		switch(kind)
		{
			// DIAMOND
			case "DIAMOND":
				return "ダイヤの" + num;
				
			// HEART(1)
			case "HEART":
				cardNum = num % 13;
				if(num % 13 == 0) cardNum = 13;
				
				return "ハートの" + cardNum;
							
			// SPADE(2)
			case "SPADE":
				cardNum = num % (13 * SPADE);
				if(num % 13 == 0) cardNum = 13;
				
				return "スペードの" + cardNum;
				
			// CRUB(3)
			case "CRUB":
				cardNum = num % (13 * CRUB);
				if(num % 13 == 0) cardNum = 13;
				
				return "クローバーの" + cardNum;
				
			// exception
			default:
				return "例外です!!";	
		}
		
	}
	
	// カードの  1-52  の数値を  1-13  に変換
	public int convertTo1_13(int num)
	{
		int cardNum;
		String fromConvert2Suit = convert2Suit(num);
		
		// 1-13
		if(fromConvert2Suit == "DIAMOND")
		{
			// 引いたカードが11, 12, 13の場合、10としてカウントする
			if(num == 11 | num == 12 | num == 13)
			{
				num = 10;
				return num;
			}
			// 1-10
			return num;
		}
		/**
		 *  14-26  "HEART":
		 *  27-39  "SPADE"
		 *  40-52  "CRUB"
		 */
		else
		{
			/**
			 * 14-52を引いた場合は、13で割ったあまりで
			 * 得点をカウントする。
			 * 引いたカードが11, 12, 13（余りは 11, 12, 0 ）の場合、10としてカウントする
			 */
			if((num % 13) == 0 | (num % 13) == 11 | (num % 13) == 12 )
			{
				cardNum = 10;
				return cardNum;
			}
			cardNum = num % 13;
			return cardNum;
		}

	}
	
	
	// 1-52の数字のsuitを判定する（変換する）
	public String convert2Suit(int num) 
	{
		if(num <= 0)
		{
			return "例外です!!";
		}
		
		switch((num - 1)/ 13) 
		{
			// 0-12 / 13
			case 0:
				return "DIAMOND";
			// 13-25 / 13
			case 1:
				return "HEART";
			// 26-38 / 13
			case 2:
				return "SPADE";
			// 39-51 / 13
			case 3:
				return "CRUB";
			// exception
			default:
				return "例外です!!";
		}
	}
	

	
		

}



