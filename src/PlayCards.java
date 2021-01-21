package assignment_4;

import java.util.Scanner;

/**
 * This class is a test class, which enables users to make different choices and output relevant information
 * @author Zhiping Yu      student# 000822513     date 2020,07,03
 */
public class PlayCards {
    /**
     * Main method is used to ask user input choice and display information
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // create a new scanner
        System.out.print("How many suits? ");
        int numOfSuits = sc.nextInt(); // store integer input in a variable
        System.out.print("How many ranks? ");
        int numOfRanks = sc.nextInt(); // store integer input in a variable
        DeckOfCards dCards = new DeckOfCards(numOfRanks, numOfSuits); // create an object of DeckOfCards class
        boolean flag = false;
        while (!flag) { // loop enables user to make different choices
            System.out.println();
            System.out.println(dCards);
            System.out.print("1=shuffle, 2=deal 1 hand, 3=deal 100000 times, 4=quit: ");
            int input = sc.nextInt();
            if (input == 1) {
                dCards.shuffle(); // user chooses to shuffle the cards
            }else if(input == 2){
                System.out.print("How many cards: ");
                int numOfCards = sc.nextInt();
                if(numOfCards <=numOfSuits * numOfRanks) {
                    Card[] cardArr = dCards.dealCards(numOfCards);
                    for (Card element:cardArr
                         ) {
                        System.out.print(element + "  ");
                    }
                }else{
                    System.err.println("Number of cards dealt cannot be more than: "+(numOfRanks*numOfSuits)+
                            " . Please try again!\n");

                }
            }else if(input ==3){
                System.out.print("How many cards: ");
                int cardNum = sc.nextInt();
                if(cardNum <=numOfSuits * numOfRanks ) {
                    int[] histogram = dCards.makeHistogram(cardNum);
                    // print histogram
                    for (int i = dCards.addValueMin(cardNum); i < dCards.addValueMax(cardNum) + 1; i++) {
                        System.out.print(String.format("%2d:  %5d", i, histogram[i]) + "  ");
                        for (int j = 1; j <= Math.round(histogram[i] / 1000.0); j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                }else{
                    System.err.println("Number of cards dealt cannot be more than: "+(numOfRanks*numOfSuits)+
                            ". Please try again!\n");
                }
            }else if(input ==4){ // exit condition
                System.out.println("\nBYE!");
                flag = true;

            }else{
                System.err.println("Invalid input! Please input an integer from 1 to 4.\n");
            }

            }
        }



}
