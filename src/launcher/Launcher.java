package launcher;

import java.io.IOException;

import counters.CounterFactory;
import utilities.BasicFunctions;
import counters.Counter;

public class Launcher {
	private static String RESOURCES_PATH = System.getProperty("user.dir") + "\\resources\\data.txt";
	private static String RESULT_PATH = System.getProperty("user.dir") + "\\resources\\result.txt";

	public static void main(String[] args) throws IOException {
		BasicFunctions.clearFile(RESULT_PATH);
		testLetterCounter();
		testLetterCounterFile();
		testWordCounter();
		testWordCounterFile();
	}

	private static void testLetterCounter() throws IOException {
		int nbOccurencesMin = 2;
		int nbOccurencesMax = 300;
		Counter letterCounter = CounterFactory.createNewLetterCounter(nbOccurencesMin, nbOccurencesMax);
		letterCounter.fill("aulkjaajfoioshpoushp");
		letterCounter.saveStats(RESULT_PATH);
		letterCounter.saveElementOccurences(RESULT_PATH);
	}

	private static void testLetterCounterFile() throws IOException {
		Counter counter = CounterFactory.createDefaultLetterCounter();
		counter.fillWithFile(RESOURCES_PATH);
		counter.saveStats(RESULT_PATH);
		counter.saveElementOccurences(RESULT_PATH);
	}

	private static void testWordCounter() throws IOException {
		int minLength = 1;
		int nbOccurencesMin = 2;
		int nbOccurencesMax = 300;
		Counter counter = CounterFactory.createNewWordCounter(minLength, nbOccurencesMin, nbOccurencesMax);
		counter.fill("skj skj skj skj dfglksj fdlg kjsd flgs");
		counter.saveStats(RESULT_PATH);
		counter.saveElementOccurences(RESULT_PATH);
	}

	private static void testWordCounterFile() throws IOException {
		Counter counter = CounterFactory.createDefaultWordCounter();
		counter.fillWithFile(RESOURCES_PATH);
		counter.saveStats(RESULT_PATH);
		counter.saveElementOccurences(RESULT_PATH);
	}
}
