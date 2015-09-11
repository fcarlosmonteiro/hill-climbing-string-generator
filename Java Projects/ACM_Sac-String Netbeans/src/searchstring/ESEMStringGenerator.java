package searchstring;

import java.util.ArrayList;

import br.unesp.stringsearch.databases.Acm;
import br.unesp.stringsearch.databases.Ieee;
import br.unesp.stringsearch.databases.ScienceDirect;
import br.unesp.stringsearch.databases.Scopus;
import br.unesp.stringsearch.databases.SpringerLink;
import br.unesp.stringsearch.databases.WebScience;

public class ESEMStringGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<String> part1 = new ArrayList<String>();
		part1.add("Software");
		part1.add("System");
		part1.add("Program");
		part1.add("Asset");
		part1.add("Application");
		part1.add("Artifact");
		part1.add("test-teting");
		
		ArrayList<String> part2 = new ArrayList<String>();
		part2.add("reuse");
		part2.add("reusable");
		part2.add("reusability");
		part2.add("test-teting");
		
		
		ArrayList<String> part3 = new ArrayList<String>();
		part3.add("visualization");
		part3.add("visual");
		part3.add("visualisation");
		part3.add("test-teting");
		
		
		
		
		System.out.println(" --------Saidas --------");
		
	
		System.out.println("IEEE: "+Ieee.generate(part1, part2, part3));
		
		/*
		 * A partir daqui prodemos implementar os critérios ... 
		 * 
		 * 
		 * 
		 */
		
		
		
		
		
		
		

	}

}
