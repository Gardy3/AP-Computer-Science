import java.util.ArrayList;

public class Player {
	
	private ArrayList<Card> hand;
	private String name = "";
	
	public Player(){
		hand = new ArrayList<Card>();
	}
	
	public Player(String name){
		hand = new ArrayList<Card>();
		this.name = name;
	}
	
	public Card getCard(){
		return hand.get(0);
	}
	
	public void addCard(Card x){
		hand.add(x);
	}
	
	public void setCard(ArrayList<Card> x){
		for(Card card : x){
			hand.add(card);
		}
	}
}
