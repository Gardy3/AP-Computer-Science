import java.util.ArrayList;
import java.util.Scanner;
public class War {
	
	private ArrayList<Player> players = new ArrayList<>();
	
	private Deck cardDeck;
	private int numPlayers;
	private int currInd;
	private boolean gameLoop;
	
	public War(){
	}
	
	public static void main(String[] args){
		War game = new War();
		game.play();
	}
	
	public void play(){
		cardDeck = new Deck();
		numPlayers();
		cardDeck.shuffle();
		deal();
		gameLoop = true;
		while(gameLoop){
			flip();
			checkPlayers();
			for(Player player : players){
				System.out.println(player.getName() + ": " + player.getSize());
			}
		}
	}
	
	public void numPlayers(){
		Scanner input = new Scanner(System.in);
		System.out.print("Input number of players: ");
		numPlayers = input.nextInt();
		input.nextLine();
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
		Scanner input = new Scanner(System.in);
		input.nextLine();
		for(int i = 0; i < players.size(); i++){
			Card played = players.get(i).getCard(0);
			System.out.println(players.get(i).getName() + ": " + played);
			drawnCards.add(played);
			if(players.get(i).getSize() > 1){
				players.get(i).remove(0);
			}
		}
		ArrayList<Player> winners = compareCards(drawnCards, players);
		for(Player player : players){
			if(!winners.contains(player)){
				if(drawnCards.contains(player.getCard(0))){
					player.remove(0);
				}
			}
		}
		if(winners.size() > 1){
			war(winners, drawnCards);
		}
		else{
			if(drawnCards.contains(winners.get(0).getCard(0))){
				winners.get(0).remove(0);
			}
			System.out.println(winners.get(0).getName() + " wins the round!");
			winners.get(0).addCard(drawnCards);
		}
		
		
	}
	
	/*
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
	*/
	
	
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
		Scanner input = new Scanner(System.in);
		ArrayList<Card> countingCards= new ArrayList<>();
		input.nextLine();
		for(Player player : players){
			int numBurn;
			if(player.getSize() < 4){
				numBurn = player.getSize() - 1;
			}
			else{
				numBurn = 3;
			}
			for(int i = 0; i < numBurn; i++){
				drawnCards.add(player.remove(0));
			}
			System.out.println(player.getName() + " places " + numBurn + " cards face down.");
		}
		for(Player player : players){
			Card played = player.getCard(0);
			System.out.println(player.getName() + ": " + played);
			if(player.getSize() > 1){
				player.remove(0);
			}
			countingCards.add(played);
			if(!drawnCards.contains(played)){
				drawnCards.add(played);
			}
		}
		ArrayList<Player> winners = compareCards(countingCards, players);
		for(int i = 0; i < players.size(); i++){
			if(!winners.contains(players.get(i))){
				if(drawnCards.contains(players.get(i).getCard(0))){
					players.get(i).remove(0);
				}
				players.remove(i);
				i--;
			}
		}
		if(winners.size() > 1){
			war(winners, drawnCards);
		}
		else{
			System.out.println(winners.get(0).getName() + " wins the war!");
			if(drawnCards.contains(winners.get(0).getCard(0))){
				winners.get(0).remove(0);
			}
			winners.get(0).addCard(drawnCards);
		}
	}
	
	public void checkPlayers(){
		for(int i = 0; i < players.size(); i++){
			if(players.get(i).getSize() == 0){
				System.out.println(players.get(i).getName() + " is out.");
				players.remove(i);
				i--;
			}
		}
		if(players.size() == 1 && players.get(0).getSize() == 52){
			System.out.println(players.get(0).getName() + " won the game!");
			gameLoop = false;
		}
	}
}
