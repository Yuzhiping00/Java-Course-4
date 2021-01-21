package assignment_4;


import java.util.Arrays;
import java.util.Random;

/**
 * This class is a model class, which provides several methods for other programmers to call, including shuffle cards,
 * deal cards and make histogram etc
 *
 * @author Zhiping Yu       student# 000822513      date 2020,07,03
 */
public class DeckOfCards {
    /* array's length */
    private int size;
    /* top card in a deck of cards */
    private Card[] cardArray;

    /**
     * Constructor: create and initialize a Card array based on passed in values
     *
     * @param maxRank    initial maximum rank in a deck of cards
     * @param numOfSuits initial number of suits in a deck of cards
     */
    public DeckOfCards(int maxRank, int numOfSuits) {
        this.size = maxRank * numOfSuits;      // array's length or number of cards in a deck of cards
        int count = 0; //array's index
        cardArray = new Card[size];            // create a new array used to store cards
        for (int suit = 1; suit <= numOfSuits; suit++) {
            for (int rank = 1; rank <= maxRank; rank++) {
                cardArray[count++] = new Card(suit, rank);      // store cards in the card array
            }
        }
    }

    /**
     * This method is used to shuffle a deck of cards, which makes cards in different order
     */
    public void shuffle() {
        Random random = new Random();      // create a new random object
        for (int i = 0; i < size; i++) {
            int j = random.nextInt(size);  // get random integer from 0-size, but does not include size
            /* swapping pairs of cards in the array */
            Card temp = cardArray[i];
            cardArray[i] = cardArray[j];
            cardArray[j] = temp;
        }

    }

    /**
     * This method is used to get minimum value of a card in a deck
     *
     * @return 1 since rank and suit are all positive values, 1 is the smallest value
     */
    private int getMin() {
        return 1;

    }

    /**
     * This method is used to get maximum value of a card in a deck
     *
     * @return size which is the maximum value in a deck of cards
     */
    private int getMax() {
        return size;
    }


    /**
     * This method is to store the occurrence of different sum value in an integer array after shuffling 100000 times.
     * @param numberToDeal number of cards to be dealt
     * @return int[] an array consist of occurrence of different sum value
     */
    public int[] makeHistogram(int numberToDeal) {
        // create an integer array and its length based on the maximum value of dealt cards adding together
        int[] histogram = new int[addValueMax(numberToDeal) + 1];
        // declare an integer array which is used to store dealt cards values
        int[] numArray;
        for (int i = 1; i <= 100000; i++) { // loop 100000 times
            shuffle();
            numArray = dealCards(numberToDeal, cardArray); // call method to get an integer array
            int sum = calSum(numArray); // calculate the sum  of dealt cards
            histogram[sum]++; // use sum as index and count the occurrence of that sum

        }
        return histogram;

    }

    /**
     * This method is used to get the top card in a deck of cards
     *
     * @param arr an array contains cards
     * @return card  first card of an array
     */
    private Card getTopCard(Card[] arr) {
        return arr[0]; // first card
    }

    /**
     * This method is used to display some attributes of an object of DeckOfCards
     *
     * @return String which describes the number of cards, min and max value of the cards and top card in a deck of
     * cards
     */
    public String toString() {
        return "Deck of " + size + " cards: low = " + getMin() + " high = " + getMax() + " top = " +
                getTopCard(cardArray);
    }


    /**
     * This method is used to create a new card array based on the number of cards dealt
     * @param numOfCards number of cards will be dealt
     * @return Card[]  a new card array with numOfCards as its length
     */
    public Card[] dealCards(int numOfCards) {
        Card[] newArray = new Card[numOfCards];
        for (int i = 0; i <= numOfCards - 1; i++) {
            newArray[i] = cardArray[i]; // assign elements in card array to new array
        }
        return newArray;
    }

    /**
     * The method is used to get the maximum value of the cards based on the number of cards dealt
     *
     * @param numToDeal number of cards dealt
     * @return maxSum the max value of the dealt cards added
     */
    public int addValueMax(int numToDeal) {
        int[] sortArray = convertToNumber(cardArray);
        int maxSum = 0;
        for (int i = sortArray.length - 1; i >= sortArray.length - numToDeal; i--) {
            maxSum = maxSum + sortArray[i];
        }
        return maxSum;
    }

    /**
     * The method is used to get the minimum value of the cards based on the number of cards dealt
     *
     * @param numToDeal number of cards dealt
     * @return minSum the min value of the dealt cards added
     */
    public int addValueMin(int numToDeal) {
        int[] sortArray = convertToNumber(cardArray);
        int minSum = 0;
        for (int i = 0; i < numToDeal; i++) {
            minSum = minSum + sortArray[i];
        }
        return minSum;
    }

    /**
     * This method is to convert cards to values and stored in different arrays
     *
     * @param cardArray an array contains cards as its element
     * @return result a new array contains integers and it has been sorted
     */
    private int[] convertToNumber(Card[] cardArray) {
        int[] result = new int[cardArray.length];
        for (int i = 0; i < cardArray.length; i++) {
            result[i] = cardArray[i].getValue();
        }
        Arrays.sort(result); // sort an integer array
        return result;
    }

    /**
     * This method is used to calculate the sum of elements in an integer array
     *
     * @param otherArray an array contains integers
     * @return sum the sum of integers in an array
     */
    private int calSum(int[] otherArray) {
        int sum = 0;
        for (int i = 0; i <= otherArray.length - 1; i++) {
            sum = sum + otherArray[i];
        }
        return sum;
    }

    /**
     * This method is to convert some card array to integer array and array's length based on
     * the number of cards dealt
     *
     * @param numberToDeal number of cards dealt
     * @param cardArray    an array used to store cards
     * @return otherArray it is an array contains integer
     */
    private int[] dealCards(int numberToDeal, Card[] cardArray) {
        int[] intArray = new int[numberToDeal];
        for (int i = 0; i < numberToDeal; i++) {
            intArray[i] = cardArray[i].getValue();

        }
        return intArray;

    }

}






