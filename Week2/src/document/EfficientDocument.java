package document;

import java.util.List;

/** 
 * A class that represents a text document
 * It does one pass through the document to count the number of syllables, words, 
 * and sentences and then stores those values.
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class EfficientDocument extends Document {

	private int numWords;  // The number of words in the document
	private int numSentences;  // The number of sentences in the document
	private int numSyllables;  // The number of syllables in the document
	
	public EfficientDocument(String text)
	{
		super(text);
		processText();
	}
	
	
	/** Return true if this string is a word (as opposed to punctuation)
	 * @param tok The string to check
	 * @return true if tok is a word, false otherwise. */
	/*
 	The idea behind this method is that it takes a string that either contains sentence ending punctuation, 
 	or does not contain sentence ending punctuation. You’ll be able to use this method for counting the number of 
 	words AND the number of sentences. (If you are keeping either words OR sentence ending punctuation, if a token isn’t 
 	a word, what is it?) Pay special attention to the case where the last sentence does not end in a sentence-ending punctuation. 
 	It should still be counted as a sentence, but you'll need to handle that case carefully...
	 */
	private boolean isWord(String tok)
	{
	    // Note: This is a fast way of checking whether a string is a word
	    // You probably don't want to change it.
		return !(tok.indexOf("!") >=0 || tok.indexOf(".") >=0 || tok.indexOf("?")>=0);
	}
	
	
    /** Passes through the text one time to count the number of words, syllables and 
     * sentences, and set the member variables appropriately.
     * Words, sentences and syllables are defined as described below. 
     */
	/*
	This method should make ONE pass through the tokens list and count the number of words, sentences and syllables 
	in the document. It should store these values in the appropriate member variables so that when the method is over, 
	they never have to be re-calculated.
	 */
	private void processText()
	{
		// Provide this first line in the starter code.  
		// Words are only strings of letters.  No numbers.
		List<String> tokens = getTokens("[!?.]+|[a-zA-Z]+");
		int cntWords = 0;
		int cntSentences = 0;
		int cntSyllables = 0;
		for(int i = 0; i < tokens.size(); i++){
			if( isWord(tokens.get(i)) ){
				// 记得先全部转换成小写以后，再统一处理！！！
				String lowerCase = tokens.get(i).toLowerCase();
				cntSyllables += countSyllables(lowerCase);
				cntWords++;
				/*
		 		Pay special attention to the case where the last sentence does not end in a sentence-ending punctuation. 
		 		It should still be counted as a sentence, but you'll need to handle that case carefully...
				*/
				if( i == tokens.size()-1 ){
					cntSentences++;
				}
			}else{
				cntSentences++;
			}
		}

		this.numWords = cntWords;
		this.numSentences = cntSentences;
		this.numSyllables = cntSyllables;
		// TODO: Finish this method.  Remember the countSyllables method from 
		// Document.  That will come in handy here.
	}
	
	
	/**
	 * Get the number of words in the document.
	 * "Words" are defined as contiguous strings of alphabetic characters
	 * i.e. any upper or lower case characters a-z or A-Z
	 * 
	 * @return The number of words in the document.
	 */
	@Override
	public int getNumWords() {
		//TODO: write this method.  Hint: It's simple
		return this.numWords;
	}

	/**
	 * Get the number of sentences in the document.
	 * Sentences are defined as contiguous strings of characters ending in an 
	 * end of sentence punctuation (. ! or ?) or the last contiguous set of 
	 * characters in the document, even if they don't end with a punctuation mark.
	 * 
	 * @return The number of sentences in the document.
	 */
	@Override
	public int getNumSentences() {
        //TODO: write this method.  Hint: It's simple
		return this.numSentences;
	}

	/**
	 * Get the number of syllables in the document.
	 * Words are defined as above.  Syllables are defined as:
	 * a contiguous sequence of vowels, except for a lone "e" at the 
	 * end of a word if the word has another set of contiguous vowels, 
	 * makes up one syllable.   y is considered a vowel.
	 * @return The number of syllables in the document.
	 */
	@Override
	public int getNumSyllables() {
        //TODO: write this method.  Hint: It's simple
		return this.numSyllables;
	}
	
	// Can be used for testing
	// We encourage you to add your own tests here.
	public static void main(String[] args)
	{
	    testCase(new EfficientDocument("This is a test.  How many???  "
                + "Senteeeeeeeeeences are here... there should be 5!  Right?"),
                16, 13, 5);
        testCase(new EfficientDocument(""), 0, 0, 0);
        testCase(new EfficientDocument("sentence, with, lots, of, commas.!  "
                + "(And some poaren)).  The output is: 7.5."), 15, 11, 4);
        testCase(new EfficientDocument("many???  Senteeeeeeeeeences are"), 6, 3, 2); 
        testCase(new EfficientDocument("Here is a series of test sentences. Your program should "
				+ "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
				+ "the correct amount of syllables (example, for example), "
				+ "but most of them will."), 49, 33, 3);
		testCase(new EfficientDocument("Segue"), 2, 1, 1);
		testCase(new EfficientDocument("Sentence"), 2, 1, 1);
		testCase(new EfficientDocument("Sentences?!"), 3, 1, 1);
		testCase(new EfficientDocument("Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad."),
		         32, 15, 1);
		
	}
	

}
