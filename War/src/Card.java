
public class Card {
	
	private int cardVal;
	private int cardType;
	
	public Card(int cardVal, int cardType){
		this.cardVal = cardVal;
		this.cardType = cardType;
	}
	
	public int getCardVal(){
		return cardVal;
	}
	
	public int getCardType(){
		return cardType;
	}
	
	public String toString(){
		String retVal = "";
		switch(cardVal){
			case 0:
				retVal += "Two";
				break;
			case 1:
				retVal += "Three";
				break;
			case 2:
				retVal += "Four";
				break;
			case 3:
				retVal += "Five";
				break;
			case 4:
				retVal += "Six";
				break;
			case 5:
				retVal += "Seven";
				break;
			case 6:
				retVal += "Eight";
				break;
			case 7:
				retVal += "Nine";
				break;
			case 8:
				retVal += "Ten";
				break;
			case 9:
				retVal += "Jack";
				break;
			case 10:
				retVal += "Queen";
				break;
			case 11:
				retVal += "King";
				break;
			case 12:
				retVal += "Ace";
				break;
		}
		retVal += " of ";
		
		switch(cardType){
			case 0:
				retVal += "Hearts";
				break;
			case 1:
				retVal += "Spades";
				break;
			case 2:
				retVal += "Clubs";
				break;
			case 3:
				retVal += "Diamonds";
				break;
		}
		return retVal;
	}

	
	public boolean isLargerThan(Card card2){
		return card2.cardVal > this.cardVal;
	}
	

}
