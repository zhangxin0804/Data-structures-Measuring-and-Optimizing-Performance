package document;

import java.util.List;

/** 
 * A naive implementation of the Document abstract class. 
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class BasicDocument extends Document 
{
	/** Create a new BasicDocument object
	 * 
	 * @param text The full text of the Document.
	 */
	public BasicDocument(String text)
	{
		super(text);
		
	}
	
	
	
	/**
	 * Get the number of words in the document.
	 * "Words" are defined as contiguous strings of alphabetic characters
	 * i.e. any upper or lower case characters a-z or A-Z
	 * 
	 * @return The number of words in the document.
	 */
	/*
	 A word is any contiguous sequence of one or more alphabetical characters. 
	 We will completely ignore numbers when we count words, and you can assume you will not have any strings 
	 that combine numbers and letters. 
	 */
	@Override
	public int getNumWords()
	{
		//TODO: Implement this method.  See the Module 1 support videos 
		String pattern = "[a-zA-Z]+";
		List<String> tokenizeByWords = getTokens(pattern);
	    return tokenizeByWords.size();
	}
	
	/**
	 * Get the number of sentences in the document.
	 * Sentences are defined as contiguous strings of characters ending in an 
	 * end of sentence punctuation (. ! or ?) or the last contiguous set of 
	 * characters in the document, even if they don't end with a punctuation mark.
	 * 
	 * @return The number of sentences in the document.
	 */
	
	/*
	This method counts and returns the number of sentences in the document. 
	A sentence is any sequence of characters ending in one or more end of line punctuation marks, or the last sequence of characters 
	in a document, even if they don’t end with an end of line punctuation mark. An end of line punctuation mark includes a period (.),
	an exclamation point (!) and a question mark (?). That’s it. Notice that we provide a main method that gives you several 
	examples/test cases.
	 */
	/*
	注意：下面这种正则表达式来断句的话，会有些corner case处理不当。
	Our REGEX are pretty naive. For example, the word 7.5 causes real problems for our expressions as a “.” usually denotes 
	the end of a sentence. 
	 */
	@Override
	public int getNumSentences()
	{
	    //TODO: Implement this method.  See the Module 1 support videos 
		// protected List<String> getTokens(String pattern)
		
		String pattern = "[^!.?]+";
		List<String> tokenizeBySentence = getTokens(pattern); // getTokens是从父类(抽象类)Document类中继承来的。
        return tokenizeBySentence.size();
	}
	
	/**
	 * Get the number of syllables in the document.
	 * Words are defined as above.  Syllables are defined as:
	 * a contiguous sequence of vowels, except for a lone "e" at the 
	 * end of a word if the word has another set of contiguous vowels, 
	 * makes up one syllable.   y is considered a vowel.
	 * @return The number of syllables in the document.
	 */
	/*
	 Each contiguous sequence of one or more vowels is a syllable, 
	 with the following exception: a lone "e" at the end of a word is not considered a syllable unless the word 
	 has no other syllables. You should consider y a vowel
	 
	 Under these rules the words “the”, “fly”, “yes”, “cave” and “double” all have 1 syllable, but "segue" has two syllables. 
	 Notice that this isn’t exactly correct (“double” actually has 2 syllables), but it’s close enough for our purposes. 
	 Here are some more examples with the number of syllables your method should return to help you: "contiguous" (3 syllables), 
	 "sleepy" (2 syllables), "obvious" (2 syllables), "toga" (2 syllables). Notice that our rules get a lot wrong, especially 
	 when you have more than 2 vowels in a row, but these are the rules we will test you against.
	 */
	@Override
	public int getNumSyllables()
	{
	    //TODO: Implement this method.  See the Module 1 support videos 
		String pattern = "[a-zA-Z]+";
		List<String> tokenizeByWords = getTokens(pattern);
		int numSyllables = 0;
		for(int i = 0; i < tokenizeByWords.size(); i++){
			// protected int countSyllables(String word), 继承自父类Document这个抽象类, 作用就是一个可以被继承下去的helper函数。
			String lowerCase = tokenizeByWords.get(i).toLowerCase();
			numSyllables += countSyllables( lowerCase );
		}
        return numSyllables;
	}
	
	
	/* The main method for testing this class. 
	 * You are encouraged to add your own tests.  */
	public static void main(String[] args)
	{
		testCase(new BasicDocument("This is a test.  How many???  "
		        + "Senteeeeeeeeeences are here... there should be 5!  Right?"),
				16, 13, 5);
		testCase(new BasicDocument(""), 0, 0, 0);
		testCase(new BasicDocument("sentence, with, lots, of, commas.!  "
		        + "(And some poaren)).  The output is: 7.5."), 15, 11, 4);
		testCase(new BasicDocument("many???  Senteeeeeeeeeences are"), 6, 3, 2);
		testCase(new BasicDocument("Here is a series of test sentences. Your program should "
				+ "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
				+ "the correct amount of syllables (example, for example), "
				+ "but most of them will."), 49, 33, 3);
		testCase(new BasicDocument("Segue"), 2, 1, 1);
		testCase(new BasicDocument("Sentence"), 2, 1, 1);
		testCase(new BasicDocument("Sentences?!"), 3, 1, 1);
		testCase(new BasicDocument("Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad."),
		         32, 15, 1);	
	}
	
}
