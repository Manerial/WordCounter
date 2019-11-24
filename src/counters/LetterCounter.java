package counters;

public class LetterCounter extends Counter {
	/**
	 * Create an empty LetterCounter
	 */
	protected LetterCounter() {
		super();
	}

	@Override
	protected void addElement(String element) {
		element = element.toLowerCase().replace("ɑ̃", "â");
		String[] letters = element.split("");
		for (String letter : letters) {
			addLetter(letter);
		}
	}
	
	/**
	 * Add a new letter to this LetterCounter
	 * 
	 * @param word : the word to add
	 */
	private void addLetter(String letter) {
		letter = letter.toLowerCase().replace("â", "ɑ̃");
		if(super.elementMap.containsKey(letter)) {
			super.elementMap.put(letter, super.elementMap.get(letter) + 1);
		} else {
			super.elementMap.put(letter, 1);
		}
	}

	@Override
	protected boolean checkElement(String element) {
		return checkOccurences(element);
	}

	private boolean checkOccurences(String element) {
		int occurrences = super.getElementOccurences(element);
		return occurrences >= super.getNbOccurencesMin() && occurrences <= super.getNbOccurencesMax();
	}
}
