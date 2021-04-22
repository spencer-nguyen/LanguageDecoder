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

		while(scnrWord.hasNextLine()) {
			
			wordLine   = scnrWord.nextLine();
			wordAndKey = wordLine.split(" ", 2);
			decoder.insert(wordAndKey[0], wordAndKey[1]);
		}
		
		scnrWord.close();
		
		while(scnrEncoded.hasNextLine()) {
			
			encodedLine = scnrEncoded.nextLine();
			
			Scanner parseEncoded = new Scanner(encodedLine);
			
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
