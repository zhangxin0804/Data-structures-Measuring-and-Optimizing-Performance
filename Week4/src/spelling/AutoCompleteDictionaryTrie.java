package spelling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
    /*
     You should convert each word to lowercase before inserting it into the trie. 
     When you look for a word in the trie, you should look for the all lowercase version of the word. 
     * **/
	public boolean addWord(String word)
	{
		if( word == null || word.length() == 0 ){
			return false;
		}
		word = word.toLowerCase();
	    //TODO: Implement this method.
		if( !isWord(word) ){
			TrieNode crt = root;
			for(int i = 0; i < word.length(); i++){
				char c = word.charAt(i);
				if( crt.getChild(c) != null ){
					crt = crt.getChild(c);
				}else{
					crt = crt.insert(c);
				}
			}
			crt.setEndsWord(true);
			this.size++;
			return true;
		}
		
	    return false;
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
	    return this.size;
	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
		// TODO: Implement this method
		if( s == null || s.length() == 0 ){
			return false;
		}
		s = s.toLowerCase();
		TrieNode crt = root;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if( crt.getChild(c) == null ){
				return false;
			}else{
				crt = crt.getChild(c);
			}
		}
		if( crt.endsWord() ){
			return true;
		}
		return false;
	}

	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     
     /*
      1. If the prefix itself is a valid word, it should be included in the list of returned words.
      2. 注意：测试文件中，有可能传入prefix为空字符串。因此不能直接看成是错误返回，而是要以Trie的root开始往下predict
      */
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    
    	 List<String> res = new ArrayList<String>();
    	 /*
    	 if( prefix == null || prefix.length() == 0 ){
    		 return res;
    	 }
    	 */
    	 prefix = prefix.toLowerCase();
    	 TrieNode crt = root;
    	 for(int i = 0; i < prefix.length(); i++){
    		 char c = prefix.charAt(i);
    		 if( crt.getChild(c) == null ){
    			 return res;
    		 }
    		 crt = crt.getChild(c);
    	 }
    	 Queue<TrieNode> queue = new LinkedList<TrieNode>();
    	 queue.offer(crt);
    	 
    	 while( !queue.isEmpty() && res.size() < numCompletions ){
    		 int size = queue.size();
    		 for(int i = 0; i < size; i++){
    			 TrieNode tmp = queue.poll();
    			 if(tmp.endsWord() && res.size() < numCompletions ){
    				 res.add(tmp.getText());
    			 }
    			 Set<Character> branch = tmp.getValidNextCharacters();
    			 for(Character tmpChar: branch){
    				 queue.offer(tmp.getChild(tmpChar));
    			 }
    		 }
    	 }
    	 
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 
         return res;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}