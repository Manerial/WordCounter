package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class BasicFunctions {

	/**
	 * Return a BufferedReader to read a file
	 * 
	 * @param filePath : the file path to read
	 * @return a BufferedReader with the path of the file to read
	 * @throws FileNotFoundException : All the File Not Found exceptions
	 */
	public static BufferedReader getBufferReader(String filePath) throws FileNotFoundException {
		InputStream ips = new FileInputStream(filePath);
		InputStreamReader ipsr = new InputStreamReader(ips, Charset.forName("UTF-8"));
		return new BufferedReader(ipsr);
	}

	/**
	 * Return a BufferedWriter to write into a file
	 * 
	 * @param filePath : the file path to write
	 * @return a BufferedWriter with the path of the file to write
	 * @throws IOException : All the IO exceptions
	 */
	public static PrintWriter getPrinterWriter(String filePath, boolean append) throws IOException {
		OutputStream ops = new FileOutputStream(filePath, append);
		OutputStreamWriter opsw = new OutputStreamWriter(ops, Charset.forName("UTF-8"));
		BufferedWriter bw = new BufferedWriter(opsw);
		return new PrintWriter(bw);
	}
	
	public static void clearFile(String filePath) throws IOException {
		PrintWriter pr = BasicFunctions.getPrinterWriter(filePath, false);
		pr.print("");
		pr.close();
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
