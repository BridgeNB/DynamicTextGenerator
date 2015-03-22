/**
 * CS 180 - Dynamic Generation Project
 * 
 * Prefix class that represents prefixes used in a Dynamic Text Generator. A
 * prefix can have a fixed but arbitrary number of context words.
 *
 * @author (Your Name) <(YourEmail@purdue.edu)>
 * 
 * @lab (Your Lab Section)
 * 
 * @version (Today's Date)
 *
 */
public class Prefix {
	
	private int Prelen;
	
	private int numPre;
	private String[] prefix;
	private int numSuff;
	private String[] suffix;
	
	public static int numStartArray;
	static private String[] startArray;
	
	

	/**
	 * The array of prefix strings that denote the start of a sentence is an
	 * array of empty strings. This method must be called and the array must be
	 * initialized every time the program is trained on a new file so that the
	 * array will have the correct length (i.e. correct number of elements).
	 * <P>
	 * If this method is not called every time a new file is trained, the
	 * program may inexplicably fail (especially if the length of the prefix has
	 * been changed).
	 */
	
	public static void initializeSentenceStartArray() {
		// TODO: remove exception and add code here
		// throw new UnsupportedOperationException();
		startArray = new String[numStartArray];
		
	}

	/**
	 * Returns a String[] whose contents are used to retrieve the
	 * Start-of-Sentence Prefix object.
	 * <P>
	 * This Start-of-Sentence Prefix object is special in that is used to
	 * determine the first word in a dynamically generated sentence.
	 * 
	 * @return A <b>copy</b> of the prefix strings array initialized by
	 *         {@link #initializeSentenceStartArray()}
	 */
	public static String[] getStartOfSentencePrefixes() {
		// TODO: remove exception and add code here
		// throw new UnsupportedOperationException();
		return startArray;
	}

	/**
	 * Constructor that takes an array of prefix strings as an argument
	 * 
	 * @param prefixStrings
	 *            The array of prefix strings
	 */
	public Prefix(String[] prefixStrings) {
		// TODO: remove exception and add code here
		//throw new UnsupportedOperationException();
		prefix = prefixStrings;
	}

	/**
	 * Returns the number of suffixes that this Prefix object contains
	 * 
	 * @return The number of suffixes of this prefix object
	 */
	public int getNumSuffixes() {
		// TODO: remove exception and add code here
		// throw new UnsupportedOperationException();
		return numSuff;
	}

	/**
	 * Returns the number of prefixes that this Prefix object contains
	 * 
	 * @return The number of of prefix strings of this prefix object
	 */
	public int getNumPrefixes() {
		// TODO: remove exception and add code here
		// throw new UnsupportedOperationException();
		return prefix.length;
	}

	/**
	 * Returns the prefix string at a specified index.
	 * 
	 * @param index
	 *            The location of the desired prefix string
	 * @return The prefix string at this given location
	 */
	public String getPrefixString(int index) {
		// TODO: remove exception and add code here
		// throw new UnsupportedOperationException();
		return prefix[index];
	}

	/**
	 * Returns the suffix string at a specified index
	 * 
	 * @param index
	 *            The location of the desired suffix string
	 * @return The suffix string at this given location
	 */
	public String getSuffixString(int index) {
		// TODO: remove exception and add code here
		// throw new UnsupportedOperationException();
		return suffix[index];
	}

	/**
	 * Selects a random suffix from the array of suffixes. This function is
	 * integral to the sentence generation stage. It should use Math.random() to
	 * select a valid index for the array of suffixes, and then return the
	 * string at that index.
	 * <P>
	 * Warning: If the suffix array is empty (i.e. suffixes.length == 0), this
	 * method will throw an {@link ArrayIndexOutOfBoundsException}. Therefore,
	 * before calling this method, you may want to check the number of suffixes
	 * first.
	 * 
	 * @return - A random suffix string (from the suffix strings array)
	 */
	public String getRandomSuffix() {
		// TODO: remove exception and add code here
		// generate a random list
		// use that value as the index and return the suffix in
		// that location
		// throw new UnsupportedOperationException();
		if (suffix.length == 0) {
			throw new ArrayIndexOutOfBoundsException();
		} 
		
		int range = getNumSuffixes() + 1;
		int rm = (int)Math.random() * range;
		
		return suffix[rm];
	}

	/**
	 * Adds a suffix string to the array of all possible suffixes that appear
	 * after this prefix. This method allows for multiple copies of the same
	 * string to be added to the array.
	 * 
	 * @param str
	 *            The string suffix (word appearing directly after this prefix)
	 */
	public void addSuffix(String str) {
		// TODO: remove exception and add code here
		// throw new UnsupportedOperationException();
		// public static void addTrainedTexts(String filename) {		
			if ( numSuff >= suffix.length) {
				String[] temp = new String[2 * suffix.length];
				for (int i = 0; i < suffix.length; ++i)
					temp[i] = suffix[i];
				suffix = temp;
			}
			
			suffix[numSuff++] = str;
	}

	/**
	 * Determines equality among Prefix objects. Two Prefix objects are
	 * considered equal if they both have the exact same string prefixes in the
	 * same order.
	 * 
	 * @param obj
	 *            Object to determine equality against
	 */
	public boolean equals(Object obj) {
		// TODO: remove exception and add code here
		//throw new UnsupportedOperationException();
		boolean result = true;
		
		if (!(obj instanceof Prefix)) {
			result = false;
		}
		
			Prefix pf = (Prefix)obj;
			
		if (this.getNumPrefixes() != pf.getNumPrefixes()) {
			result = false;
		}
		
		for (int i = 0; i < this.getNumPrefixes(); i++){
			if (!this.getPrefixString(i).equals(pf.getPrefixString(i))) {
				result = false;
				break;
			}
		}
		
		return result;
		           
	}

	/**
	 * The string form of a prefix object is its list of prefixes converted to a
	 * whitespace delimited string
	 */
	public String toString() {
		// TODO: remove exception and add code here
		String deString = null;
		for(int i = 0; i < prefix.length; i++) {
			deString = deString + getPrefixString(i) + " ";
		}
		return deString;
	}
}
