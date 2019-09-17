package wordCounterUtility;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter {
	private int minLength = 0;
	private int nbOccurencesMin = 0;
	private int nbOccurencesMax = 0;
	private Map<String, Integer> wordMap;

	/**
	 * Create an empty WordCounter
	 */
	public WordCounter() {
		resetWordMap();
	}

	/**
	 * Add a new word to this WordCounter
	 * 
	 * @param word : the word to add
	 */
	public void addWord(String word) {
		word = word.toLowerCase();
		if(wordMap.containsKey(word)) {
			wordMap.put(word, wordMap.get(word) + 1);
		} else {
			wordMap.put(word, 1);
		}
	}

	/**
	 * Add a list of words to this WordCounter
	 * 
	 * @param wordslist
	 */
	public void addWords(String[] wordslist) {
		for(String word : wordslist) {
			this.addWord(word);
		}
	}

	public void setWordMap(Map<String, Integer> wordList) {
		this.wordMap = wordList;
	}

	public void resetWordMap() {
		wordMap = new TreeMap<String, Integer>();
	}

	public Map<String, Integer> getWordMap() {
		return wordMap;
	}

	public int getWordOccurences(String word) {
		return wordMap.get(word);
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getNbOccurencesMin() {
		return nbOccurencesMin;
	}

	public void setNbOccurencesMin(int nbOccurencesMin) {
		this.nbOccurencesMin = nbOccurencesMin;
	}

	public int getNbOccurencesMax() {
		return nbOccurencesMax;
	}

	public void setNbOccurencesMax(int nbOccurencesMax) {
		this.nbOccurencesMax = nbOccurencesMax;
	}

	/**
	 * Display the occurrences of all words
	 */
	public void displayWordsOccurences() {
		Iterator<String> iteratorWords = wordMap.keySet().iterator();
		while(iteratorWords.hasNext()) {
			String word = iteratorWords.next().toString();
			int nbOccurrences = wordMap.get(word);
			if(checkLengthMatch(word) && checkOccurencesMatch(nbOccurrences)) {
				System.out.println(word + " " + nbOccurrences);
			}
		}
	}

	/**
	 * Display a global report of all words
	 */
	public void displayWordNumber() {
		Iterator<String> iteratorWords = wordMap.keySet().iterator();
		int amountWords = 0;
		int sizeWordMap = 0;
		while(iteratorWords.hasNext()) {
			String word = iteratorWords.next().toString();
			if(checkLengthMatch(word)) {
				amountWords += wordMap.get(word);
				sizeWordMap++;
			}
		}
		System.out.println("Nombre de mots : " + amountWords);
		System.out.println("Nombre de mots différents : " + sizeWordMap);
	}

	/**
	 * Check the number of occurrences match the conditions
	 * 
	 * @param occurrences : the number of occurrences of a word
	 * @return true if the matching is true
	 */
	public boolean checkOccurencesMatch(int occurrences) {
		return occurrences >= nbOccurencesMin && occurrences <= nbOccurencesMax;
	}

	/**
	 * Check if a word is length enough to match the required minimum length
	 * 
	 * @param word : the word to check
	 * @return true if the word length is greater or equals than the min length
	 */
	public boolean checkLengthMatch(String word) {
		return word.length() >= minLength;
	}
}
