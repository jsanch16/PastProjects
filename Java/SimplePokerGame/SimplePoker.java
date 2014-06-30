package PJ4;

import java.util.*;

/*
 * Ref: http://en.wikipedia.org/wiki/Video_poker
 *      http://www.google.com/ig/directory?type=gadgets&url=www.labpixies.com/campaigns/videopoker/videopoker.xml
 *
 *
 * Short Description and Poker rules:
 *
 * Video poker is also known as draw poker. 
 * The dealer uses a 52-card deck, which is played fresh after each currentHand. 
 * The player is dealt one five-card poker currentHand. 
 * After the first draw, which is automatic, you may hold any of the cards and draw 
 * again to replace the cards that you haven't chosen to hold. 
 * Your cards are compared to a table of winning combinations. 
 * The object is to get the best possible combination so that you earn the highest 
 * payout on the bet you placed. 
 *
 * Winning Combinations
 *  
 * 1. Jacks or Better: a pair pays out only if the cards in the pair are Jacks, 
 * 	Queens, Kings, or Aces. Lower pairs do not pay out. 
 * 2. Two Pair: two sets of pairs of the same card denomination. 
 * 3. Three of a Kind: three cards of the same denomination. 
 * 4. Straight: five consecutive denomination cards of different suit. 
 * 5. Flush: five non-consecutive denomination cards of the same suit. 
 * 6. Full House: a set of three cards of the same denomination plus 
 * 	a set of two cards of the same denomination. 
 * 7. Four of a kind: four cards of the same denomination. 
 * 8. Straight Flush: five consecutive denomination cards of the same suit. 
 * 9. Royal Flush: five consecutive denomination cards of the same suit, 
 * 	starting from 10 and ending with an ace
 *
 */

/* This is the main poker game class.
 * It uses Decks and Card objects to implement poker game.
 * Please do not modify any data fields or defined methods
 * You may add new data fields and methods
 * Note: You must implement defined methods
 */

public class SimplePoker {

	// default constant values
	private static final int startingBalance = 100;
	private static final int numberOfCards = 5;

	// default constant payout value and currentHand types
	private static final int[] multipliers = { 1, 2, 3, 5, 6, 9, 25, 50, 250 };
	private static final String[] goodHandTypes = { "Royal Pair", "Two Pairs",
			"Three of a Kind", "Straight", "Flush	", "Full House",
			"Four of a Kind", "Straight Flush", "Royal Flush" };       
	
	
	// must use only one deck
	private static final Decks oneDeck = new Decks(1);

	// holding current poker 5-card hand, balance, bet
	private List<Card> currentHand;
	private int balance;
	private int bet;
	
	

	/** default constructor, set balance = startingBalance */
	public SimplePoker() {
		this(startingBalance);
		balance = startingBalance;
		currentHand = new ArrayList<Card>(5);
	}

	/** constructor, set given balance */
	public SimplePoker(int balance) {
		this.balance = balance;
		currentHand = new ArrayList<Card>(5);
	}

	/**
	 * This display the payout table based on multipliers and goodHandTypes
	 * arrays
	 */
	private void showPayoutTable() {
		System.out.println("\n\n");
		System.out.println("Payout Table   	      Multiplier   ");
		System.out.println("=======================================");
		int size = multipliers.length;
		for (int i = size - 1; i >= 0; i--) {
			System.out.println(goodHandTypes[i] + "\t|\t" + multipliers[i]);
		}
		System.out.println("\n\n");
	}

	/**
	 * Check current currentHand using multipliers and goodHandTypes arrays Must
	 * print yourHandType (default is "Sorry, you lost") at the end of function.
	 * This can be checked by testCheckHands() and main() method.
	 */
	private void checkHands() {
		// implement this method!
		
		
		int clubsCount = 0;
		int diamondsCount = 0;
		int heartsCount = 0;
		int spadesCount = 0;
		
		boolean handFound = false;
		
		for(int i = 0; i < 5; i++) {
			if(currentHand.get(i).getSuit() == 0) {
				clubsCount++;
			}else if(currentHand.get(i).getSuit() == 1) {
				diamondsCount++;
			}else if(currentHand.get(i).getSuit() == 2) {
				heartsCount++;
			}else if(currentHand.get(i).getSuit() == 3) {
				spadesCount++;
			}	
		}
		
		
		int[] rankCounter = new int[14];  
		
		for(int c = 0; c < 5; c++) {
			for(int r = 1; r < 14; r++) {
				if(currentHand.get(c).getRank() == r) {
					rankCounter[r]++;
				}
			}	
		}
		
	
		
		int[] sameRank = new int[4];
		for(int s = 1; s < rankCounter.length; s++) {
			if(rankCounter[s] > 0) {
				sameRank[rankCounter[s] - 1]++;
			}
		}
		
		
		
		if(clubsCount == 5 || diamondsCount == 5 || heartsCount == 5 || spadesCount == 5) {
			if (sameRank[0] == 5) {	
				
				if(rankCounter[13] == 1 && rankCounter[12] == 1 && rankCounter[11] == 1 
						&& rankCounter[10] == 1 && rankCounter[1] == 1) {
					balance += bet*multipliers[8];
					System.out.println("Royal Flush!");
					handFound = true;
				} else if (sameRank[0] == 5){ 
					
					for(int i = 13; i > 4; i--) { 
						if(rankCounter[i] == 1 && rankCounter[i - 1] == 1 && rankCounter[i - 2] == 1 
								&& rankCounter[i - 3] == 1 && rankCounter[i - 4] == 1) {
							balance += bet*multipliers[7];
							System.out.println("Straight Flush!");
							handFound = true;
						} 
					}
				} else{
					balance += bet*multipliers[4];
					System.out.println("Flush!");  
					handFound = true;
				}
				
			} else {
				balance += bet*multipliers[4];
				System.out.println("Flush!");
				handFound = true;
			}
		}else if (sameRank[1] == 1) {     			
			if(sameRank[0] == 3) {   
				if(rankCounter[13] == 2 || rankCounter[12] == 2 || rankCounter[11] == 2 || rankCounter[1] == 2) {
					//royal pair!
					balance += bet*multipliers[0];
					System.out.println("Royal Pair!");
					handFound = true;
				} else {
					System.out.println("Sorry, you lost.");
				}
			}else if (sameRank[2] == 1) {
				balance += bet*multipliers[4];
				System.out.println("Full House!");
				handFound = true;
			}
		} else if(sameRank[0] == 1) {	    
				if(sameRank[1] == 2) { 		
					balance += bet*multipliers[1];
					System.out.println("Two Pairs!");
					handFound = true;
				} else if (sameRank[3] == 1) {	
					balance += bet*multipliers[6];
					System.out.println("Four of a Kind!");
					handFound = true;
				}
		} else if (sameRank[2] == 1) { 						
			balance += bet*multipliers[2];
			System.out.println("Three of a Kind!");
			handFound = true;
		} else if (sameRank[0] == 5) {	
			for(int i = 13; i > 5; i--) {
				if(rankCounter[i] == 1 && rankCounter[i - 1] == 1 && rankCounter[i - 2] == 1 
						&& rankCounter[i - 3] == 1 && rankCounter[i - 4] == 1) {
					balance += bet*multipliers[3];
					System.out.println("Straight!");
					handFound = true;
				}
			}
			if (handFound == false) {
				System.out.println("Sorry, you lost.");
			}
		} else if (handFound == false){
			System.out.println("Sorry, you lost.");
		}
		
	}

	/*************************************************
	 * add new private methods here ....
	 * 
	 *************************************************/

	public void play() {
		/**
		 * The main algorithm for single player poker game
		 * 
		 * Steps: showPayoutTable()
		 * 
		 * ++ show balance, get bet verify bet value, update balance reset deck,
		 * shuffle deck, deal cards and display cards ask for position of cards
		 * to keep get positions in one input line update cards check hands,
		 * display proper messages update balance if there is a payout if
		 * balance = O: end of program else ask if the player wants to play a
		 * new game if the answer is "no" : end of program else :
		 * showPayoutTable() if user wants to see it goto ++
		 */

		// implement this method!
		Scanner user = new Scanner(System.in);
		
		Scanner keepScanner = new Scanner(System.in);
		keepScanner.useDelimiter(System.getProperty("line.separator"));
		
		Scanner numbers;
		
		showPayoutTable();
		
		 
		String answer;
		char wantToPlay = 'y'; 
		balance = startingBalance; 
		String cardsToKeep;
		int[] keepArray = new int[5];
		
		
		while((!(balance == 0)) && (!(wantToPlay == 'n'))){    
			currentHand.clear();
			oneDeck.reset();
			
			System.out.println("Balance: $" + balance);
			do{
				System.out.print("Enter Bet: ");
				bet = user.nextInt();
				if(bet > balance){
					System.out.println("insufficient funds!");
				}else if(bet < 0) {
					System.out.println("Not possible, sir!");
				}
			}while(bet > balance || bet < 0);
			
			balance = (balance - bet);
			oneDeck.shuffle();
			
			try{
				currentHand.addAll(0, oneDeck.deal(numberOfCards));
			}catch(PlayingCardException e){
				System.out.println(e);
			}
			System.out.println(currentHand);
			
			System.out.print("Enter positions of cards to keep (e.g. 1 4 5 ) or 0 to switch all cards: ");
			cardsToKeep = keepScanner.next();
			
			numbers = new Scanner(cardsToKeep); 	
			
			int k = 0;
			while(numbers.hasNextInt()) {
				keepArray[k] = numbers.nextInt();
				k++;
			}
			
			if (keepArray[0] == 0) {
				for(int r = 1; r < 6; r++) {
					try {
						currentHand.set((r-1), oneDeck.deal(1).get(0));
					} catch (PlayingCardException e) {
						
					}
				}
			} else {
				boolean replace;
				
				for(int r = 1; r < 6; r++) {
					for(int c = 0; c < k; c++) {
						replace = true;
						if(r == keepArray[c]) {
							replace = false;
							break;
						}
						if((c == (k-1)) && (replace)) {
							try {
								currentHand.set((r-1), oneDeck.deal(1).get(0));
							} catch (PlayingCardException e) {
							
							}
						}
					}
				}
			}
			
			
			System.out.println(currentHand);
			
			checkHands();
			
			System.out.println("Your balance is " + balance);
			
			if(balance == 0){
				System.out.println("Game Over.");
			} else {
				System.out.print("one more game (y or n)?");
				answer = user.next();
				wantToPlay = answer.charAt(0);
				
				if(wantToPlay == 'y'){
					System.out.print("Want to see payout table (y or n)");
					answer = user.next();
					
					if((answer.charAt(0)) == 'y') {
						showPayoutTable();
					}
					
				} else if(wantToPlay == 'n') {
					System.out.println("Thanks for playing!");
				}
				
			}
			
		}
	}

	/**
	 * Do not modify this. It is used to test checkHands() method checkHands()
	 * should print your current hand type
	 */
	public void testCheckHands() {
		try {
			currentHand = new ArrayList<Card>();

			// set Royal Flush
			currentHand.add(new Card(1, 3));
			currentHand.add(new Card(10, 3));
			currentHand.add(new Card(12, 3));
			currentHand.add(new Card(11, 3));
			currentHand.add(new Card(13, 3));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Straight Flush
			currentHand.set(0, new Card(9, 3));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Straight
			currentHand.set(4, new Card(8, 1));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Flush
			currentHand.set(4, new Card(5, 3));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// "Royal Pair" , "Two Pairs" , "Three of a Kind", "Straight",
			// "Flush	",
			// "Full House", "Four of a Kind", "Straight Flush", "Royal Flush"
			// };

			// set Four of a Kind
			currentHand.clear();
			currentHand.add(new Card(8, 3));
			currentHand.add(new Card(8, 0));
			currentHand.add(new Card(12, 3));
			currentHand.add(new Card(8, 1));
			currentHand.add(new Card(8, 2));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Three of a Kind
			currentHand.set(4, new Card(11, 3));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Full House
			currentHand.set(2, new Card(11, 1));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Two Pairs
			currentHand.set(1, new Card(9, 1));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// set Royal Pair
			currentHand.set(0, new Card(3, 1));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");

			// non Royal Pair
			currentHand.set(2, new Card(3, 3));
			System.out.println(currentHand);
			checkHands();
			System.out.println("-----------------------------------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* Quick testCheckHands() */
	public static void main(String args[]) {
		SimplePoker mypokergame = new SimplePoker();
		mypokergame.play();
		mypokergame.testCheckHands();
	}
}
