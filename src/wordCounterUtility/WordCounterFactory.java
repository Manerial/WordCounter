package wordCounterUtility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WordCounterFactory {

	/**
	 * Creates a new WordCounter with default parameters
	 * minLength = 1
	 * nbOccurencesMin = 1;
	 * nbOccurencesMax = 5000;
	 * 
	 * @return the new WordCounter
	 */
	public static WordCounter createDefaultWordCounter() {	
		int minLength = 1;
		int nbOccurencesMin = 1;
		int nbOccurencesMax = 5000;
		WordCounter wordCounter = new WordCounter();
		wordCounter.setMinLength(minLength);
		wordCounter.setNbOccurencesMin(nbOccurencesMin);
		wordCounter.setNbOccurencesMax(nbOccurencesMax);
		return wordCounter;
	}

	/**
	 * Fill a WordCounter using a text file
	 * 
	 * @param wordCounter : The WordCounter to fill
	 * @param filePath : The path of the file to use
	 * @return the WordCounter filled with the text file
	 * @throws IOException : All the IO exceptions
	 */
	public static WordCounter fillWordCounter(WordCounter wordCounter, String filePath) throws IOException {		
		BufferedReader br = readFile(filePath);
		String line;
		while ((line = br.readLine()) != null) {
			String[] wordslist = specialSplitString(line);
			wordCounter.addWords(wordslist);
		}
		return wordCounter;
	}

	/**
	 * Uses a path and creates a new BufferedReader
	 * 
	 * @param filePath : The path to the file to read
	 * @return a new BufferedReader to read the file
	 * @throws FileNotFoundException
	 */
	public static BufferedReader readFile(String filePath) throws FileNotFoundException {
		InputStream ips = new FileInputStream(filePath);
		InputStreamReader ipsr = new InputStreamReader(ips);
		return new BufferedReader(ipsr);
	}

	/**
	 * Split a string on special characters
	 * 
	 * @param string : The string to split
	 * @return the list of words in the string
	 */
	public static String[] specialSplitString(String string) {
		return replaceSpecialCharacters(string).split(" ");
	}

	/**
	 * Replace the space characters
	 * ("-", ",", "'", ".", "(", ")", "[", "]", etc...)
	 * by spaces
	 * 
	 * @param string : the string to use
	 * @return the string without space-characters
	 */
	public static String replaceSpecialCharacters(String string) {
		return string
				.replace("-", " ")
				.replace(".", " ")
				.replace("'", " ")
				.replace(",", " ")
				.replace("\"", " ")
				.replace(",", " ")
				.replace("(", " ")
				.replace(")", " ")
				.replace("?", " ")
				.replace("!", " ")
				.replace(":", " ")
				.replace("\u2026", " ")
				.replace("\u2019", " ");
	}
}
