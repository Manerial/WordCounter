package counters;

public class WordCounter extends Counter {
	private int minLength = 0;

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	@Override
	protected boolean checkElement(String element) {
		return checkOccurences(element) && checkLength(element);
	}

	private boolean checkOccurences(String element) {
		int occurrences = super.getElementOccurences(element);
		return occurrences >= super.getNbOccurencesMin() && occurrences <= super.getNbOccurencesMax();
	}

	/**
	 * Check if a word is length enough to match the required minimum length
	 * 
	 * @param word : the word to check
	 * @return true if the word length is greater or equals than the min length
	 */
	private boolean checkLength(String element) {
		return element.length() >= minLength;
	}
}
