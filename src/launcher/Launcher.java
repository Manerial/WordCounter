package launcher;

import wordCounterUtility.WordCounter;
import wordCounterUtility.WordCounterFactory;

public class Launcher {
	private static String RESOURCES_PATH = System.getProperty("user.dir") + "\\resources\\TEST.txt";

	public static void main(String[] args) {
		WordCounter wordCounter = WordCounterFactory.createDefaultWordCounter();
		wordCounter = WordCounterFactory.fillWordCounter(wordCounter, RESOURCES_PATH);
		//wordCounter.displayWordsOccurences();
		wordCounter.displayWordNumber();
		

		int minLength = 3;
		int nbOccurencesMin = 3;
		int nbOccurencesMax = 300;
		wordCounter.setMinLength(minLength);
		wordCounter.setNbOccurencesMin(nbOccurencesMin);
		wordCounter.setNbOccurencesMax(nbOccurencesMax);
		//wordCounter.displayWordsOccurences();
		wordCounter.displayWordNumber();
	}
}
