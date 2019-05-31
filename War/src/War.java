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
}
