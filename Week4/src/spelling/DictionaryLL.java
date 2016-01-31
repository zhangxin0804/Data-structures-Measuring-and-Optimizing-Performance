package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
    // TODO: Add a constructor
	public DictionaryLL(){
		dict = new LinkedList<String>();
	}
	
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
	/*
	 Your dictionary should store all words as lower case words, 
	 i.e. they should be converted to lower case before you put them in. 
	 */
	
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	if( word == null || word.length() == 0 ){
    		return false;
    	}
    	word = word.toLowerCase();
    	if( !isWord(word) ){
    		this.dict.add(word);
    	}
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size() {
        // TODO: Implement this method
        return this.dict.size();
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
    	// private LinkedList<String> dict;
    	for(String word: dict){
    		if( word.equals(s) ){
    			return true;
    		}
    	}
        return false;
    }

    
}
