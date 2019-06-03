import java.util.ArrayList;
import java.util.Scanner;
public class War {
	
	private ArrayList<Player> players = new ArrayList<>();
	private Deck cardDeck;
	private int numPlayers;
	
	public War(){
		
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
		ArrayList<Card> drawnCards = new ArrayList<>();
		ArrayList<Player> tempPlayers = new ArrayList<>();
		for(Player player : players){
			tempPlayers.add(player);
		}
		for(int i = 0; i < players.size(); i++){
			System.out.println(players.get(i).getName() + " drew a " + players.get(i).getCard());
			drawnCards.add(players.get(i).remove());
		}
		ArrayList<Player> winners = compareCards(drawnCards, tempPlayers);
	}
	
	/*
	public void flip(int startVal, ArrayList<Card> drawnCards, ArrayList<Player> tempPlayers){
		for(int i = 0; i < players.size(); i++){
			System.out.println(players.get(i).getName() + " drew a " + players.get(i).getCard());
			drawnCards.add(players.get(i).remove());
		}
		ArrayList<Player> winners = new ArrayList<>();
	}
	*/
	
	public ArrayList<Player> compareCards(ArrayList<Card> drawnCards, ArrayList<Player> tempPlayers){
		ArrayList<Player> winners = new ArrayList<>();
		int maxVal = 0;
		for(Card card : drawnCards){
			
		}
		return winners;
	}
}
