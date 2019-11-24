package counters;

public class CounterFactory {

	/**
	 * Creates a new WordCounter with default parameters
	 * minLength = 1
	 * nbOccurencesMin = 1;
	 * nbOccurencesMax = 5000;
	 * 
	 * @return the new WordCounter
	 */
	public static WordCounter createDefaultWordCounter() {
		return createNewWordCounter(1, 1, 5000);
	}

	/**
	 * Creates a new WordCounter with given parameters
	 * 
	 * @return the new WordCounter
	 */
	public static WordCounter createNewWordCounter(int minLength, int nbOccurencesMin, int nbOccurencesMax) {	
		WordCounter wordCounter = new WordCounter();
		wordCounter.setMinLength(minLength);
		wordCounter.setNbOccurencesMin(nbOccurencesMin);
		wordCounter.setNbOccurencesMax(nbOccurencesMax);
		return wordCounter;
	}

	/**
	 * Creates a new LetterCounter with default parameters
	 * nbOccurencesMin = 1;
	 * nbOccurencesMax = 5000;
	 * 
	 * @return the new WordCounter
	 */
	public static LetterCounter createDefaultLetterCounter() {
		return createNewLetterCounter(1, 5000);
	}

	/**
	 * Creates a new LetterCounter with given parameters
	 * 
	 * @return the new LetterCounter
	 */
	public static LetterCounter createNewLetterCounter(int nbOccurencesMin, int nbOccurencesMax) {	
		LetterCounter letterCounter = new LetterCounter();
		letterCounter.setNbOccurencesMin(nbOccurencesMin);
		letterCounter.setNbOccurencesMax(nbOccurencesMax);
		return letterCounter;
	}
}
