import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class CardGame {
    final static int size = 13;
    final static int deckSize=size*4;

    static String[] rangCard =new String[]{"T","K","Q","J","10","9","8","7","6","5","4","3","2"};
    static String[] suitCard = new String[] {"♣","♦","♥","♠"};
    static int[] cardDeck = new int[deckSize];
    static {
        for (int i = 0; i < deckSize; i++) {
            cardDeck[i] = i;
        }
    }
    static LinkedList<Integer> deck1 = new LinkedList<>();
    static LinkedList<Integer> deck2 = new LinkedList<>();




    public static void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < deckSize; i++) {
            int card1 = rand.nextInt(deckSize);
            int card2 = rand.nextInt(deckSize);
            int card3 = cardDeck[card1];
            cardDeck[card1] = cardDeck[card2];
            cardDeck[card2] = card3;
        }
    }

    public static String getRang(int number){
        return rangCard[number%13];
    }
    public static String getSuit(int number){
        return suitCard[number/13];
    }

    public static void printCard(int number){
        System.out.print(getRang(number)+getSuit(number));
    }

    public static void distribute(){
        for (int i = 0; i < deckSize/2; i++) {
            deck1.add(cardDeck[i]);
        }
        for (int i = deckSize/2; i <deckSize ; i++) {
            deck2.add(cardDeck[i]);
        }
    }

    public static void move(){
        int card1 = deck1.get(0);
        int card2 = deck2.get(0);
        printCard(card1);
        System.out.print(" ");
        printCard(card2);
        System.out.println();
        String rang1 = getRang(card1);
        String rang2 = getRang(card2);
        deck1.removeFirst();
        deck2.removeFirst();

        if (findIndex(rang1)<findIndex(rang2)){
            deck1.add(card1);
            deck1.add(card2);
            System.out.println();
        }else if (findIndex(rang1)>findIndex(rang2)) {
            deck2.add(card1);
            deck2.add(card2);
        }else   {
                deck1.add(card1);
                deck2.add(card2);
        }

        System.out.println(deck1.size()+ "  "+deck2.size());
    }

    static int findIndex(String rang){
        int index = -1;
        for (int i = 0; i < size; i++)
            if (rangCard[i]==rang)
                index = i;
            return index;

    }


    public static void main(String[] args) {
        shuffle();
        distribute();
        go();
//        for (Integer card:deck1)
//            System.out.print(card+" ");
//        System.out.println();
//        for (Integer card:deck2)
//            System.out.print(card+" ");
//
//        move();
//
//        for (Integer card:deck1)
//            System.out.print(card+" ");
//        System.out.println();
//        for (Integer card:deck2)
//            System.out.print(card+" ");

    }

    static void go(){
        while (!deck1.isEmpty() || !deck2.isEmpty()){
            move();
        }
    }
}
