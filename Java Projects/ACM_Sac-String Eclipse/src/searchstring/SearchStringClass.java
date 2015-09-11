package searchstring;

import java.util.ArrayList;

public class SearchStringClass {
	
	private ArrayList<String> part1 = new ArrayList<String>();
	private ArrayList<String> part2 = new ArrayList<String>();
	private ArrayList<String> part3 = new ArrayList<String>();
	private int allOfKeywords;
	
	//test OKAY
	public SearchStringClass(ArrayList<String> part1, ArrayList<String> part2, ArrayList<String> part3)
	{
		setPart1(part1);
		setPart2(part2);
		setPart3(part3);
		
		if (part3.size() == 0)
			setTriplePartSearchString (false);			
		else
			setTriplePartSearchString (true);
		
		allOfKeywords = part1.size()+ part2.size() + part3.size();
	}
	
	public int getAllOfKeywords() {
		return allOfKeywords;
	}

	public ArrayList<String> getPart1() {
		return part1;
	}

	public void setPart1(ArrayList<String> part1) {
		this.part1 = part1;
	}

	public ArrayList<String> getPart2() {
		return part2;
	}

	public void setPart2(ArrayList<String> part2) {
		this.part2 = part2;
	}

	public ArrayList<String> getPart3() {
		return part3;
	}

	public void setPart3(ArrayList<String> part3) {
		this.part3 = part3;
	}

	private boolean triplePartSearchString = false;
	
	private void setTriplePartSearchString (boolean triplePartSearchString)
	{
		this.triplePartSearchString = triplePartSearchString;
	}
	
	public boolean getTriplePartSearchString()
	{
		return triplePartSearchString;
	}
	
	
	public int getNumberOfDash()
	{
		int numOfDash = 0;
		String aux;
		for (int i=0; i<part1.size(); i++)
			numOfDash += countOccurrences(part1.get(i), '-');
		
		for (int i=0; i<part2.size(); i++)
			numOfDash += countOccurrences(part2.get(i), '-'); 
		
		for (int i=0; i<part3.size(); i++)
			numOfDash += countOccurrences(part3.get(i), '-'); 
		
		
		return numOfDash;
	}
	
	
	public int countOccurrences(String word, char needle)
	{
	    int count = 0;
	    for (int i=0; i < word.length(); i++)
	    {
	        if (word.charAt(i) == needle)
	        {
	             count++;
	        }
	    }
	    return count;
	}
	
}
