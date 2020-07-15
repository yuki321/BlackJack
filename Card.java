package blackjack;

public class Card {
	/**
	 * suit DIAMOND / HEART / SPADE / CRUB
	 * rank 1-10 / Jack / Queen / King
	 */
	
	
	/**
	 * 1-52�̐��l�\�L��rank��suit
	  *    �ɂ��\�L�ɕϊ�����
	 * EX) �uHEART��QUEEN�v
	 * 
	 *  2�i�K�ɕ����ĕϊ�����
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
		// convert2Suit���Ăяo���A�J�[�h�̎�ނ�����
		String kind = convert2Suit(num);
		int cardNum;
		
		switch(kind)
		{
			// DIAMOND
			case "DIAMOND":
				return "�_�C����" + num;
				
			// HEART(1)
			case "HEART":
				if(num % 13 == 0) cardNum = 13;
				cardNum = num % 13;
				
				return "�n�[�g��" + cardNum;
							
			// SPADE(2)
			case "SPADE":
				if(num % 13 == 0) cardNum = 13;
				cardNum = num % (13 * SPADE);
				
				return "�X�y�[�h��" + cardNum;
				
			// CRUB(3)
			case "CRUB":
				if(num % 13 == 0) cardNum = 13;
				cardNum = num % (13 * CRUB);
				
				return "�N���[�o�[��" + cardNum;
				
			// exception
			default:
				return "��O�ł�!!";	
		}
		
	}
	
	// �J�[�h��  1-52  �̐��l��  1-13  �ɕϊ�
	public int convertTo1_13(int num)
	{
		int cardNum;
		String fromConvert2Suit = convert2Suit(num);
		
		// 1-13
		if(fromConvert2Suit == "DIAMOND")
		{
			return num;
		}
		/**
		 *  14-26  "HEART":
		 *  27-39  "SPADE"
		 *  40-52  "CRUB"
		 */
		else
		{
			if((num % 13) == 0)
			{
				cardNum = 13;
				return cardNum;
			}
			cardNum = num % 13;
			return cardNum;
		}

	}
	
	
	// 1-52�̐�����suit�𔻒肷��i�ϊ�����j
	public String convert2Suit(int num) 
	{
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
				return "��O�ł�!!";
		}
	}
	

	
		

}



