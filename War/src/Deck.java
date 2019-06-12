import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> deck;
	
	public Deck(){
		deck = new ArrayList<Card>();
		for(int val = 0; val < 13; val++){
			for(int type = 0; type < 4; type++){
				deck.add(new Card(val, type));
			}
		}
	}
	
	public void shuffle(){
		Random rand = new Random();
		for(int i = 0; i < deck.size() * 2; i++){
			int index1 = rand.nextInt(deck.size());
			int index2 = rand.nextInt(deck.size());
			Card temp = deck.get(index1);
			deck.set(index1, deck.get(index2));
			deck.set(index2, temp);
		}
	}
	
	public Card getCard(int x){
		return deck.get(x);
	}
	
	public int size(){
		return deck.size();
	}
	
	public void setCard(Card x){
		deck.add(x);
	}
	
	
}
