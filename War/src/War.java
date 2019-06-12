import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class War {
	
	private ArrayList<Player> players = new ArrayList<>();
	
	private Deck cardDeck;
	private int numPlayers;
	private int currInd;
	private boolean gameLoop;
	private int round;
	private int numOfWars;
	private int numOfRounds;
	
	public War(){
	}
	
	public static void main(String[] args){
		War game = new War();
		//game.play();
		game.autoRun();
	}
	
	public void play(){
		round = 0;
		numOfWars = 0;
		cardDeck = new Deck();
		numPlayers();
		cardDeck.shuffle();
		deal();
		checkPlayers();
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
		round++;
		ArrayList<Card> drawnCards = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		input.nextLine();
		System.out.println("Round: " + round);
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
			shuffleHand(drawnCards);
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
		numOfWars++;
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
			shuffleHand(drawnCards);
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
	
	public ArrayList<Card> shuffleHand(ArrayList<Card> cards){
		Random rand = new Random();
		for(int i = 0; i < cards.size() * 2; i++){
			int index1 = rand.nextInt(cards.size());
			int index2 = rand.nextInt(cards.size());
			Card temp = cards.get(index1);
			cards.set(index1, cards.get(index2));
			cards.set(index2, temp);
		}
		return cards;
	}
	
	public void autoRun(){
		Scanner input = new Scanner(System.in);
		System.out.print("Number of players: ");
		numPlayers = input.nextInt();
		System.out.print("Number of games: ");
		int numGames = input.nextInt();
		numOfWars = 0;
		numOfRounds = 0;
		
		for(int i = 0; i < numGames; i++){
			for(int j = 0; j < numPlayers; j++){
				players.add(new Player());
			}
			cardDeck = new Deck();
			cardDeck.shuffle();
			deal();
			checkPlayers();
			gameLoop = true;
			while(gameLoop){
				autoFlip();
				checkPlayers();
			}	
		}
		System.out.println("Average Rounds: " + (double)numOfRounds/numGames);
		System.out.println("Average Wars: " + (double)numOfWars/numGames);
		
	}
	
	public void autoFlip(){
		round++;
		numOfRounds++;
		ArrayList<Card> drawnCards = new ArrayList<>();
		for(int i = 0; i < players.size(); i++){
			Card played = players.get(i).getCard(0);
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
			autoWar(winners, drawnCards);
		}
		else{
			if(drawnCards.contains(winners.get(0).getCard(0))){
				winners.get(0).remove(0);
			}
			shuffleHand(drawnCards);
			winners.get(0).addCard(drawnCards);
		}
	}
	
	public void autoWar(ArrayList<Player> players, ArrayList<Card> drawnCards){
		numOfWars++;
		ArrayList<Card> countingCards= new ArrayList<>();
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
			autoWar(winners, drawnCards);
		}
		else{
			if(drawnCards.contains(winners.get(0).getCard(0))){
				winners.get(0).remove(0);
			}
			shuffleHand(drawnCards);
			winners.get(0).addCard(drawnCards);
		}
	}
}
