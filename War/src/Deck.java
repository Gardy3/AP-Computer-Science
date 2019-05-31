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
	
	public void shuffle(ArrayList<Card> cards){
		Random rand = new Random();
		for(int i = 0; i < cards.size() * 2; i++){
			int index1 = rand.nextInt(cards.size());
			int index2 = rand.nextInt(cards.size());
			Card temp = cards.get(index1);
			cards.set(index1, cards.get(index2));
			cards.set(index2, temp);
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
