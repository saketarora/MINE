import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		if (containsPairSum11(selectedCards) || containsJQK(selectedCards)){
			return true;
			}

		return false;
	}
	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		List<Integer> Listi = cardIndexes();
		for (int i = 0; i < Listi.size(); i++){
			Card card = cardAt(Listi.get(i));
			for (int k = 0; k < Listi.size(); k++){
				Card secCard = cardAt(Listi.get(k));
				List<Integer> checklist = new ArrayList<Integer>();
				checklist.add(Listi.get(i));
				checklist.add(Listi.get(k));
				if (containsPairSum11(checklist) == true){
					return true;
				}
				if (card.pointValue() == 0 && secCard.pointValue() == 0){
					for (int j = 0; j < Listi.size(); j++){
						List<Integer> third = new ArrayList<Integer>();
						third.add(Listi.get(i));
						third.add(Listi.get(k));
						third.add(Listi.get(j));
						if (containsJQK(third) == true){
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		int sum = 0;
		for (int i = 0; i < selectedCards.size(); i++){
			Card card = cardAt(selectedCards.get(i));
			sum = (sum + card.pointValue());
		}
		if (sum == 11){
			return true;
		}
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes in0to this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		boolean check1 = false, check2 = false, check3 = false;
		for (int i = 0; i < selectedCards.size(); i++){
			Card card = cardAt(selectedCards.get(i));
			if (card.rank() == "jack"){
				check1 = true;
			}
			else if (card.rank() == "queen"){
				check2 = true;
			}
			else if (card.rank() == "king"){
				check3 = true;
			}
			if (check1 && check2 && check3 == true)
				return true;
		}
		return false;
	}
}
