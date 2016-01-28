package textgen;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word) {
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord() {
		return word;
	}

	public void addNextWord(String nextWord) {
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator) {
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		int size = nextWords.size();
		int i = generator.nextInt(size); // 产生的随机数为0-size的整数,不包括size。
	    return nextWords.get(i);
	}
	
	// 输出current word 以及 list of next words
	// 方便测试和debug
	public String toString() {
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}



/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator) {
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}

	/** Train the generator by adding the sourceText */
	/*
	Markov Text Generation depends on an initial source text to mimic. 
	This method takes in String to train the Markov Text Generator.
	*/
	@Override
	public void train(String sourceText) {
		// TODO: Implement this method
		if( sourceText == null || sourceText.length() == 0 ){
			return;
		}
		String[] words = sourceText.split("[ ]+"); // 注意test cases中，words之间可能有多个空格
		starter = words[0];
		for(int i = 1; i < words.length; i++){
			String crtWord = words[i];
			ListNode prevNode = isExist(words[i-1], wordList);
			if( prevNode == null ){
				prevNode = new ListNode(words[i-1]);
				wordList.add(prevNode);
			}
			prevNode.addNextWord(crtWord);
		}
		// setup the "starter" word and to make sure the last word also points to the start word.
		ListNode prevNode = isExist(words[words.length-1], wordList);
		if( prevNode == null ){
			prevNode = new ListNode(words[words.length-1]);
			wordList.add(prevNode);
		}		
		prevNode.addNextWord(starter);
	}
	
	// helper function
	private ListNode isExist(String crtWord, List<ListNode> wordList){
		int size = wordList.size();
		for(int i = 0; i < size; i++){
			ListNode node = wordList.get(i);
			if( node.getWord().equals(crtWord) ){
				return node;
			}
		}
		return null;
	}
	/** 
	 * Generate the number of words requested.
	 */
	/*
	 The goal of Markov Text Generation is to be able to generate text which resembles the source in a reasonable way. 
	 The method generateText returns such text as a String of words, the length of which is determined by numWords. 
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		if( numWords < 0 ){
			throw new IllegalArgumentException("Illegal Argument");
		}
		if( numWords == 0 ){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		String crtWord = starter;
		sb.append(crtWord + " ");
		numWords--; // 先减去starter word占据的一个
		while( numWords-- > 0 ){
			ListNode node = isExist(crtWord, wordList);
			String next = node.getRandomNextWord(rnGenerator);
			sb.append(next + " ");
			crtWord = next;
		}
		return sb.toString();
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString() {
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	/*
	 You may wish to use a Markov Text Generator multiple times with different source text. 
	 The method retrain acts just like train, except it removes the existing training before
	 */
	@Override
	public void retrain(String sourceText) {
		// TODO: Implement this method.
		wordList = new LinkedList<ListNode>();
		starter = "";
		train(sourceText);	
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args) {
		// feed the generator a fixed random value for repeatable behavior
		/*
		String textString = "hi there hi Leo";
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		gen.train(textString);
		System.out.println(gen);
		*/
		
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		
	}

}

