package assignment_4;

/**
 * This is a model class, which serves for other class
 * @author Zhiping Yu         student# 000822513     date 2020,07,03
 */
public class Card {
    /* A card's rank */
    private int rank;
    /* A card's suit */
    private int suit;

    /**
     * Constructor: create a card
      * @param suit initial a card's suit
     * @param rank initial a card's rank
     */
    public Card(int suit, int rank){
        if(rank > 0) {
            this.rank = rank;
        }
        if(suit > 0) {
            this.suit = suit;
        }    }

    /**
     * This method is used to get a card's value
     * @return a card's value
     */
    public int getValue(){
       return rank * suit;
    }

    /**
     * This method is used to get a card's suit and rank
     * @return a card's suit and rank
     */
    @Override
    public String toString() {
        return "Card "+"S"+suit+"R"+rank;
    }
}
