package wordCounterUtility;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
		Set<String> keySet =  wordMap.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext()) {
			String key = iter.next().toString();
			if(lengthMatch(key)) {
				int nbOccurrences = wordMap.get(key);
				if(occurencesMatch(nbOccurrences)) {
					System.out.println(key + " " + nbOccurrences);
				}
			}
		}
	}

	/**
	 * Display a global report of all words
	 */
	public void displayWordNumber() {
		Set<String> keySet = wordMap.keySet();
		Iterator<String> iter = keySet.iterator();
		int amountWords = 0;
		int sizeWordMap = 0;
		while(iter.hasNext()) {
			String key = iter.next().toString();
			if(lengthMatch(key)) {
				amountWords += wordMap.get(key);
				sizeWordMap++;
			}
		}
		System.out.println("Nombre de mots : " + amountWords);
		System.out.println("Nombre de mots différents : " + sizeWordMap);
	}
	
	public boolean occurencesMatch(int occurrences) {
		return occurrences >= nbOccurencesMin && occurrences <= nbOccurencesMax;
	}
	
	public boolean lengthMatch(String word) {
		return word.length() >= minLength;
	}
}
