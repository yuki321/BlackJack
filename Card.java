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
				cardNum = num % 13;
				if(num % 13 == 0) cardNum = 13;
				
				return "�n�[�g��" + cardNum;
							
			// SPADE(2)
			case "SPADE":
				cardNum = num % (13 * SPADE);
				if(num % 13 == 0) cardNum = 13;
				
				return "�X�y�[�h��" + cardNum;
				
			// CRUB(3)
			case "CRUB":
				cardNum = num % (13 * CRUB);
				if(num % 13 == 0) cardNum = 13;
				
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
			// �������J�[�h��11, 12, 13�̏ꍇ�A10�Ƃ��ăJ�E���g����
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
			 * 14-52���������ꍇ�́A13�Ŋ��������܂��
			 * ���_���J�E���g����B
			 * �������J�[�h��11, 12, 13�i�]��� 11, 12, 0 �j�̏ꍇ�A10�Ƃ��ăJ�E���g����
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
	
	
	// 1-52�̐�����suit�𔻒肷��i�ϊ�����j
	public String convert2Suit(int num) 
	{
		if(num <= 0)
		{
			return "��O�ł�!!";
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
				return "��O�ł�!!";
		}
	}
	

	
		

}



