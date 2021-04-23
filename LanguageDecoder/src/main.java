/*********************************************************************** 
  Student Name: Spencer Nguyen
  File Name: LanguageDecoder
  Assignment Number: Project 3
  Course: COP5416

This file accepts a "key" text file for a language decoder. It will
automatically build a tree with the key. It will also accept encoded 
messages and automatically decode and print the message.
************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Tree decoder = new Tree();

		String wordsKeyTxt  = "words.txt";
		String encodedTxt   = "encoded.txt";
		String wordLine     = "";
		String encodedLine  = "";
		String encodedWord  = "";
		String[] wordAndKey = new String[2];
		
		File wordFile    = new File(wordsKeyTxt);
		File encodedFile = new File(encodedTxt);
		
		Scanner scnrWord    = new Scanner(wordFile);
		Scanner scnrEncoded = new Scanner(encodedFile);

		/* Build tree based on the decoder key. */
		while(scnrWord.hasNextLine()) {
			wordLine   = scnrWord.nextLine();
			wordAndKey = wordLine.split(" ", 2);
			decoder.insert(wordAndKey[0], wordAndKey[1]);// the first component is the word and the second component is the symbol
		}
		scnrWord.close();
		
		/* Traverse tree and print decoded text. */
		while(scnrEncoded.hasNextLine()) {
			encodedLine = scnrEncoded.nextLine();
			
			Scanner parseEncoded = new Scanner(encodedLine);
			
			/* Get each word from a line. */
			while(parseEncoded.hasNext()) {
				encodedWord = parseEncoded.next();
				decoder.search(encodedWord);
			}
			parseEncoded.close();
			System.out.println();		
		}
		scnrEncoded.close();	
	}
}
