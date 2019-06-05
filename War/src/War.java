import java.util.ArrayList;
import java.util.Scanner;
public class War {
	
	private ArrayList<Player> players = new ArrayList<>();
	
	private Deck cardDeck;
	private int numPlayers;
	private int currInd;
	
	public War(){
		
	}
	
	public static void main(String[] args){
		Card card = new Card(6, 3);
		System.out.println(card);
	}
	
	public void numPlayers(){
		Scanner input = new Scanner(System.in);
		System.out.print("Input number of players: ");
		numPlayers = input.nextInt();
		for(int i = 0; i < numPlayers; i++){
			System.out.print("Player " + (i+1) + " name: ");
			String name = input.nextLine();
			players.add(new Player(name));
		}
	}
	
	public void deal(){
		for(int i = 0; i < cardDeck.size(); i++){
			players.get(i % numPlayers).addCard(cardDeck.getCard(i));
		}
	}
	
	public void flip(){
		currInd = 0;
		ArrayList<Card> drawnCards = new ArrayList<>();
		ArrayList<Player> tempPlayers = new ArrayList<>();
		ArrayList<Card> countingCards = new ArrayList<>();
		for(Player player : players){
;			tempPlayers.add(player);
		}
		for(int i = 0; i < players.size(); i++){
			System.out.println(players.get(i).getName() + " drew a " + players.get(i).getCard());
			drawnCards.add(players.get(i).getCard(0));
			countingCards.add(players.get(i).getCard(0));
		}
		ArrayList<Player> winners = compareCards(countingCards, tempPlayers);
		if(winners.size() > 1){
			war(winners, drawnCards);
		}
		
		
	}
	
	
	public void flip(ArrayList<Card> drawnCards, ArrayList<Player> tempPlayers){
		ArrayList<Card> countingCards = new ArrayList<>();
		for(int i = 0; i < tempPlayers.size(); i++){
			System.out.println(tempPlayers.get(i).getName() + " drew a " + tempPlayers.get(i).getCard());
			if(currInd >= tempPlayers.get(i).getHand().size()){
				countingCards.add(tempPlayers.get(i).getCard(tempPlayers.get(i).getHand().size() - 1));
			}
			drawnCards.add(tempPlayers.get(i).getCard(currInd));
			countingCards.add(tempPlayers.get(i).getCard(currInd));
		}
		ArrayList<Player> winners = compareCards(countingCards, tempPlayers);
		if(winners.size() == 1){
			
		}	
	}
	
	
	public ArrayList<Player> compareCards(ArrayList<Card> countingCards, ArrayList<Player> tempPlayers){
		ArrayList<Player> winners = new ArrayList<>();
		int maxVal = 0;
		for(Card card : countingCards){
			if(card.getCardVal() > maxVal){
				maxVal = card.getCardVal();
			}
		}
		for(int i = 0; i < tempPlayers.size(); i++){
			if(countingCards.get(i).getCardVal() == maxVal){
				winners.add(tempPlayers.get(i));
			}
		}
		return winners;
	}
	
	public void war(ArrayList<Player> players, ArrayList<Card> drawnCards){
		currInd += 1;
		
	}
}
