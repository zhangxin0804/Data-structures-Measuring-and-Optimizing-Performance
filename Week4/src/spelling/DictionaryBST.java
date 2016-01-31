package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
	
   public DictionaryBST(){
	   dict = new TreeSet<String>();
   }
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
   	/*
   	 Your dictionary should store all words as lower case words, 
   	 i.e. they should be converted to lower case before you put them in.
   	 * */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	if( word == null || word.length() == 0 ){
    		return false;
    	}
    	word = word.toLowerCase();
    	if( isWord(word) ){
    		return false;
    	}
    	dict.add(word);
        return true;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    /*
    Your dictionary should convert a word to lower case before it checks to see whether it is in the Dictionary. 
     * */
    public boolean isWord(String s) {
    	//TODO: Implement this method
    	if( s == null || s.length() == 0 ){
    		return false;
    	}
    	s = s.toLowerCase();
    	if( dict.contains(s) ){
    		return true;
    	}
        return false;
    }

}
