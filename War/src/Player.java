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
	
	public Card getCard(int i){
		return hand.get(i);
	}
	
	public void addCard(Card x){
		hand.add(x);
	}
	
	public Card remove(int x){

		return hand.remove(x);

	}
	
	public void addCard(ArrayList<Card> x){
		for(Card card : x){
			hand.add(card);
		}
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	public int getSize(){
		return hand.size();
	}
}
