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
	 * @param wordCounter : the WordCounter to fill
	 * @param filePath : the path of the file to use
	 * @return the WordCounter filled with the text file
	 */
	public static WordCounter fillWordCounter(WordCounter wordCounter, String filePath) {		
		try {
			BufferedReader br = readFile(filePath);
			String line;
			while ((line = br.readLine()) != null) {
				String[] wordslist = getWordListFromString(line);
				for(String word : wordslist) {
					wordCounter.addWord(word);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wordCounter;
	}

	public static BufferedReader readFile(String path) throws FileNotFoundException {
		InputStream ips = new FileInputStream(path);
		InputStreamReader ipsr = new InputStreamReader(ips);
		return new BufferedReader(ipsr);
	}
	
	/**
	 * Split a string on spaces
	 * 
	 * @param string : the string to split
	 * @return the list of words in the string
	 */
	public static String[] getWordListFromString(String string) {
		return replaceSpaceChar(string).split(" ");
	}
	
	/**
	 * Replace the space characters
	 * ("-", ",", "'", ".", "(", ")", "[", "]", etc...)
	 * by spaces
	 * 
	 * @param string : the string to use
	 * @return the string without space-characters
	 */
	public static String replaceSpaceChar(String string) {
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
