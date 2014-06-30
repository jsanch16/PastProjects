package PJ4;

import java.util.*;

/** class PlayingCardException: It is used for errors related to Card and Deck objects
 *  Do not modify this class!
 */
class PlayingCardException extends Exception {

    /* Constructor to create a PlayingCardException object */
    PlayingCardException (){
		super ();
    }

    PlayingCardException ( String reason ){
		super ( reason );
    }
}


/** class Card : for creating playing card objects
 *  it is an immutable class.
 *  Rank - valid values are 1 to 13
 *  Suit - valid values are 0 to 3
 *  Do not modify this class!
 */
class Card {
	
    /* constant suits and ranks */
    static final String[] Suit = {"Clubs", "Diamonds", "Hearts", "Spades" };//
    static final String[] Rank = {"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    /* Data field of a card: rank and suit */
    private int cardRank;  /* values: 1-13 (see Rank[] above) */
    private int cardSuit;  /* values: 0-3  (see Suit[] above) */

    /* Constructor to create a card */
    /* throw PlayingCardException if rank or suit is invalid */
    public Card(int rank, int suit) throws PlayingCardException { 
	if ((rank < 1) || (rank > 13))
		throw new PlayingCardException("Invalid rank:"+rank);
	else
        	cardRank = rank;
	if ((suit < 0) || (suit > 3))
		throw new PlayingCardException("Invalid suit:"+suit);
	else
        	cardSuit = suit;
    }

    /* Accessor and toString */
    /* You may impelemnt equals(), but it will not be used */
    public int getRank() { return cardRank; }
    public int getSuit() { return cardSuit; }
    public String toString() { return Rank[cardRank] + " " + Suit[cardSuit]; }

    
    /* Few quick tests here */
    public static void main(String args[])
    {
	try {
	    Card c1 = new Card(1,3);    // A Spades
	    System.out.println(c1);
	    c1 = new Card(10,0);	// 10 Clubs
	    System.out.println(c1);
	    c1 = new Card(10,5);        // generate exception here
	}
	catch (PlayingCardException e)
	{
	    System.out.println("PlayingCardException: "+e.getMessage());
	}
    }
}


/** class Decks represents : n decks of playing cards
 *  Use class Card to construct n * 52 playing cards!
 *
 *  Do not add new data fields!
 *  Do not modify any methods
 *  You may add private methods 
 */

class Decks {

    /* this is used to keep track of original n*52 cards */
    private List<Card> originalDecks;   

    /* this starts with n*52 cards deck from original deck   */
    /* it is used to keep track of remaining cards to deal */
    /* see reset(): it resets dealDecks to a full deck      */
    private List<Card> dealDecks;

    /* number of decks in this object */
    private int numberDecks;


    /**
     * Constructor: Creates default one deck of 52 playing cards in originalDecks and
     * 		    copy them to dealDecks.
     *              initialize numberDecks=n
     * Note: You need to catch PlayingCardException from Card constructor
     *	     Use ArrayList for both originalDecks & dealDecks
     */
    public Decks()
    {
        // implement this method!
        this(1);
    }


    /**
     * Constructor: Creates n decks (52 cards each deck) of playing cards in // what do you  mean by n number of decks?
     *              originalDecks and copy them to dealDecks.
     *              initialize numberDecks=n
     * Note: You need to catch PlayingCardException from Card constructor
     *	     Use ArrayList for both originalDecks & dealDecks
     */
    public Decks(int n)
    {
        // implement this method!
        this.originalDecks = new ArrayList<Card>();
        this.dealDecks = new ArrayList<Card>();
        this.numberDecks= n;
        
        createDeck(n);
        
        Card[] holdCards = new Card[originalDecks.toArray().length];
        holdCards = originalDecks.toArray(holdCards);
        copyDeck(0, holdCards);
        
        
       
    }
   // private Card[] copyElements(){
    
     //   return null;
    //}
    private void createDeck(int i){
    if(i!=0){
        try{
             this.originalDecks.add(new Card(1,0));
        this.originalDecks.add(new Card(2,0));
        this.originalDecks.add(new Card(3,0));
        this.originalDecks.add(new Card(4,0));
        this.originalDecks.add(new Card(5,0));
        this.originalDecks.add(new Card(6,0));
        this.originalDecks.add(new Card(7,0));
        this.originalDecks.add(new Card(8,0));
        this.originalDecks.add(new Card(9,0));
        this.originalDecks.add(new Card(10,0));
        this.originalDecks.add(new Card(11,0));
        this.originalDecks.add(new Card(12,0));
        this.originalDecks.add(new Card(13,0));
        
        this.originalDecks.add(new Card(1,1));
        this.originalDecks.add(new Card(2,1));
        this.originalDecks.add(new Card(3,1));
        this.originalDecks.add(new Card(4,1));
        this.originalDecks.add(new Card(5,1));
        this.originalDecks.add(new Card(6,1));
        this.originalDecks.add(new Card(7,1));
        this.originalDecks.add(new Card(8,1));
        this.originalDecks.add(new Card(9,1));
        this.originalDecks.add(new Card(10,1));
        this.originalDecks.add(new Card(11,1));
        this.originalDecks.add(new Card(12,1));
        this.originalDecks.add(new Card(13,1));
        
          this.originalDecks.add(new Card(1,2));
        this.originalDecks.add(new Card(2,2));
        this.originalDecks.add(new Card(3,2));
        this.originalDecks.add(new Card(4,2));
        this.originalDecks.add(new Card(5,2));
        this.originalDecks.add(new Card(6,2));
        this.originalDecks.add(new Card(7,2));
        this.originalDecks.add(new Card(8,2));
        this.originalDecks.add(new Card(9,2));
        this.originalDecks.add(new Card(10,2));
        this.originalDecks.add(new Card(11,2));
        this.originalDecks.add(new Card(    12,2));
        this.originalDecks.add(new Card(13,2));
        
          this.originalDecks.add(new Card(1,3));
        this.originalDecks.add(new Card(2,3));
        this.originalDecks.add(new Card(3,3));
        this.originalDecks.add(new Card(4,3));
        this.originalDecks.add(new Card(5,3));
        this.originalDecks.add(new Card(6,3));
        this.originalDecks.add(new Card(7,3));
        this.originalDecks.add(new Card(8,3));
        this.originalDecks.add(new Card(9,3));
        this.originalDecks.add(new Card(10,3));
        this.originalDecks.add(new Card(11,3));
        this.originalDecks.add(new Card(12,3));
        this.originalDecks.add(new Card(13,3));}
        
        catch(PlayingCardException ex){
            System.out.println("PlayingCardException : "+ ex);
        }
    }
    i--;
    if(i!=0){
    createDeck(i);}
    }
    
    private void copyDeck(int i, Card[] holdCards){
         i =i;
        
        dealDecks.add(holdCards[i]);
        if(i!= holdCards.length-1 ){
            i++;
            copyDeck(i, holdCards);
        }
       
    
    }

    /**
     * Task: Shuffles cards in deal deck.
     * Hint: Look at java.util.Collections
     */
    public void shuffle()
    {
        // implement this method!
        Collections.shuffle(dealDecks);
        
    }

    /**
     * Task: Deals cards from the deal deck.
     *
     * @param numberCards number of cards to deal
     * @return a list containing cards that were dealt
     * @throw PlayingCardException if numberCard > number of remaining cards
     *
     * Note: You need to create ArrayList to stored dealt cards
     *       and should removed dealt cards from dealDecks
     *
     */
    public List<Card> deal(int numberCards) throws PlayingCardException
    {
        // implement this method!
        //do random selection of total numberCards from the dealDeck.
         List<Card> hand= new ArrayList<Card>();
        int selectedIndex=0;
        if(numberCards> dealDecks.size()){
            throw new PlayingCardException("Not enough cards to deal");
        }
        else{
        selectedIndex = dealDecks.size()-1;
        for(int i=0; i<numberCards; i++){
            
            hand.add(dealDecks.remove(selectedIndex));
            selectedIndex--;
        }
        }
        return hand;
    }

    /**
     * Task: Resets deal deck by getting all cards from the original deck.
     */
    public void reset()
    {
        // implement this method!
        Card[] holdcards = new Card[52];
                holdcards = originalDecks.toArray(holdcards);
                copyDeck(0, holdcards);
    }

    /**
     * Task: Return number of remaining cards in deal deck.
     */
    public int remain()
    {
	return dealDecks.size();
    }

    /**
     * Task: Returns a string representing cards in the deal deck 
     */
    public String toString()
    {
	return ""+dealDecks;
    }


    /* Quick test                   */
    /*                              */
    /* Do not modify these tests    */
    /* Generate 2 decks of cards    */
    /* Loop 2 times:                */
    /*   Deal 30 cards for 4 times  */
    /*   Expect exception last time */
    /*   reset()                    */

    public static void main(String args[]) {

        System.out.println("*******    Create 2 decks of cards      *********\n\n");
        Decks decks  = new Decks(2);
         
	for (int j=0; j < 2; j++)
	{
        	System.out.println("\n************************************************\n");
        	System.out.println("Loop # " + j + "\n");
		System.out.println("Before shuffle:"+decks.remain()+" cards");
		System.out.println("\n\t"+decks);
        	System.out.println("\n==============================================\n");

                int numHands = 4;
                int cardsPerHand = 30;

        	for (int i=0; i < numHands; i++)
	 	{
	    		decks.shuffle();
		        System.out.println("After shuffle:"+decks.remain()+" cards");
		        System.out.println("\n\t"+decks);
			try {
            		    System.out.println("\n\nHand "+i+":"+cardsPerHand+" cards");
            		    System.out.println("\n\t"+decks.deal(cardsPerHand));
            		    System.out.println("\n\nRemain:"+decks.remain()+" cards");
		            System.out.println("\n\t"+decks);
        	            System.out.println("\n==============================================\n");
			}
			catch (PlayingCardException e) 
			{
		 	        System.out.println("*** In catch block : PlayingCardException : msg : "+e.getMessage());
			}
		}


		decks.reset();
	}
    }

}

