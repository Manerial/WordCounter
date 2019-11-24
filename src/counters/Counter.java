package counters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import utilities.BasicFunctions;

public abstract class Counter {
	protected int nbOccurencesMin = 0;
	protected int nbOccurencesMax = 0;
	protected Map<String, Integer> elementMap;

	/**
	 * Create an empty WordCounter
	 */
	protected Counter() {
		resetElementMap();
	}

	protected void resetElementMap() {
		elementMap = new TreeMap<String, Integer>();
	}

	protected Map<String, Integer> getElementMap() {
		return elementMap;
	}

	protected int getElementOccurences(String element) {
		return elementMap.get(element);
	}

	protected int getNbOccurencesMin() {
		return nbOccurencesMin;
	}

	protected void setNbOccurencesMin(int nbOccurencesMin) {
		this.nbOccurencesMin = nbOccurencesMin;
	}

	protected int getNbOccurencesMax() {
		return nbOccurencesMax;
	}

	protected void setNbOccurencesMax(int nbOccurencesMax) {
		this.nbOccurencesMax = nbOccurencesMax;
	}

	/**
	 * Add a list of words to this LetterCounter
	 * 
	 * @param wordslist : the list to add
	 */
	protected void addElements(String[] elementlist) {
		for(String element : elementlist) {
			this.addElement(element);
		}
	}

	/**
	 * Add a new word to this WordCounter
	 * 
	 * @param word : the word to add
	 */
	protected void addElement(String element) {
		element = element.toLowerCase();
		if(elementMap.containsKey(element)) {
			elementMap.put(element, elementMap.get(element) + 1);
		} else {
			elementMap.put(element, 1);
		}
	}
	
	protected boolean checkElement(String element) {
		return true;
	}
	
	public void saveStats(String filePath) throws IOException {
		PrintWriter pr = BasicFunctions.getPrinterWriter(filePath, true);
		Iterator<String> iteratorElements = elementMap.keySet().iterator();
		int amountElements = 0;
		int sizeElementMap = 0;
		while(iteratorElements.hasNext()) {
			String element = iteratorElements.next().toString();
			if(checkElement(element)) {
				amountElements += elementMap.get(element);
				sizeElementMap++;
			}
		}
		pr.println("Amount of elements : " + amountElements);
		pr.println("Number of distinct elements : " + sizeElementMap);
		pr.close();
	};
	
	public void saveElementOccurences(String filePath) throws IOException {
		PrintWriter pr = BasicFunctions.getPrinterWriter(filePath, true);
		Iterator<String> iteratorElements = elementMap.keySet().iterator();
		while(iteratorElements.hasNext()) {
			String element = iteratorElements.next().toString();
			int nbOccurrences = elementMap.get(element);
			if(checkElement(element)) {
				pr.println("Occurence of " + element + " " + nbOccurrences);
			}
		}
		pr.close();
	};


	/**
	 * Fill a WordCounter using a simple text
	 * 
	 * @param filePath : The path of the file to use
	 */
	public void fill(String text) {
		String[] elementslist = BasicFunctions.specialSplitString(text);
		this.addElements(elementslist);
	}


	/**
	 * Fill the WordCounter using a text file
	 * 
	 * @param filePath : The path of the file to use
	 * @return the WordCounter filled with the text file
	 * @throws IOException : All the IO exceptions
	 */
	public void fillWithFile(String filePath) throws IOException {
		BufferedReader br = BasicFunctions.getBufferReader(filePath);
		String line;
		while ((line = br.readLine()) != null) {
			String[] elementslist = BasicFunctions.specialSplitString(line);
			this.addElements(elementslist);
		}
	}
}
