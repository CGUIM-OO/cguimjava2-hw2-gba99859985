import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * B0544118 陳崧鈞 Try to write some comments for your codes (methods, 15 points)
 */
public class hw2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on
		// your screen (10 points)
		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/**
	 * This method is used for checking your result, not a part of your HW2
	 * 
	 * @param allCards
	 *            所有的牌
	 * @param nDeck
	 *            總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank, checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/**
 * Description: TODO: please add description here
 */
class Deck {
	private ArrayList<Card> cards;

	// TODO: Please implement the constructor (30 points)

	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		for (int i = 0; i < nDeck; i++) {
			for (int x = 1; x <= 4; x++) { // 4種花色
				for (int y = 1; y <= 13; y++) { // 13張卡
					Card card = new Card(x, y);
					cards.add(card);
				}

			}
		}

		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end

	}

	// TODO: Please implement the method to print all cards on screen (10
	// points)
	public void printDeck() {
		for (int i = 0; i < cards.size(); i++) {
			cards.get(i).printCard();
		}
		// Hint: print all items in ArrayList<Card> cards,
		// TODO: please implement and reuse printCard method in Card class (5
		// points)

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/**
 * Description: TODO: please add description here
 */
class Card {
	private int suit;

	enum Suit {
		Club, Diamond, Heart, Spade
	}

	Suit s1 = Suit.Club;
	Suit s2 = Suit.Diamond;
	Suit s3 = Suit.Heart;
	Suit s4 = Suit.Spade;
	// 不太會用先放著

	// Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank;

	// 1~13
	/**
	 * @param s
	 *            suit
	 * @param r
	 *            rank
	 */
	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// TODO: 1. Please implement the printCard method (20 points, 10 for suit,
	// 10 for rank)
	public void printCard() {
		if (suit == 1)
			System.out.println("Club" + rank);
		else if (suit == 2)
			System.out.println("Diamond" + rank);
		else if (suit == 3)
			System.out.println("Heart" + rank);
		else if (suit == 4)
			System.out.println("Spade" + rank);
		// Hint: print (System.out.println) card as suit,rank, for example:
		// print 1,1 as Clubs Ace

	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}