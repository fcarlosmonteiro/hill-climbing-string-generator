package searchstring.testing;

import java.util.ArrayList;

import searchstring.Neiborhood;
import searchstring.SearchStringClass;

public class UsingNeighborhoodInPractice {



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<String> part1; 
		ArrayList<String> part2; 
		ArrayList<String> part3; 

		part1 = new ArrayList<String>();
		part2 = new ArrayList<String>();
		part3 = new ArrayList<String>();

		part1.add("study"); part1.add("system");
                //part1.add("software"); part1.add("program"); 
                //part1.add("test-testing"); part1.add("asset");
               // part1.add("application");    
		

		part2.add("reuse"); part2.add("sofwtare testing"); part2.add("test oracle"); 
                part2.add("reusable"); part2.add("reusability");part2.add("test2-testing2");

		part3.add("visualizaton"); part3.add("visualisaton"); part3.add("visual");part3.add("test3-testing3");


		System.out.println("RAFA, esse eh um exemplo de GERACAO com uma String de 3 PARTES ....");
		SearchStringClass s1 = new SearchStringClass(part1, part2, part3);
		Neiborhood nbTesting = new Neiborhood(s1);


		System.out.println("################### NB 01 ###################\n\n");
		nbTesting.generateNbSOne();		
		System.out.println("################### NB 02 ###################\n\n");
		nbTesting.generateNbSTwo();		
		System.out.println("################### NB 03 ###################\n\n");
		nbTesting.generateNbSThree();
		System.out.println("################### NB 04 ###################\n\n");
		nbTesting.generateNbSFour();		
		System.out.println("################### NB 05 ###################\n\n");
		nbTesting.generateNbFive();	
		System.out.println("################### NB 06 ###################\n\n");
		nbTesting.generateNbSSix();

		/*
		System.out.println("RAFA, a seguir segue eh um exemplo de GERACAO de uma 
                
               String de 2 PARTES ....");

		ArrayList<String> part1Ex2; 
		ArrayList<String> part2Ex2; 
		ArrayList<String> part3Ex3;

		part1Ex2 = new ArrayList<String>();
		part2Ex2 = new ArrayList<String>();
		part3Ex3 = new ArrayList<String>();

		System.out.println("Size S1"+part1Ex2.size());
		System.out.println("Size S2"+part2Ex2.size());
		System.out.println("Size S3"+part3Ex3.size());





		part1Ex2.add("self-adaptation");
		part1Ex2.add("self-adaptive software");
		part1Ex2.add("self-adaptive system");
		part1Ex2.add("self-adaptive systems");
		part1Ex2.add("self-application");
		part1Ex2.add("self-properties");
		part1Ex2.add("self-property");


		part2Ex2.add("MDA");
		part2Ex2.add("MDD");
		part2Ex2.add("MDE");
		part2Ex2.add("MDSD");
		part2Ex2.add("model based");
		part2Ex2.add("model driven");
		part2Ex2.add("model-based");


		SearchStringClass s1 = new SearchStringClass(part1Ex2, part2Ex2, part3Ex3);
		Neiborhood nbTesting = new Neiborhood(s1);


		System.out.println("################### NB 01 ###################\n\n");
		nbTesting.generateNbSOne();		
		System.out.println("################### NB 02 ###################\n\n");
		nbTesting.generateNbSTwo();		
		System.out.println("################### NB 03 ###################\n\n");
		nbTesting.generateNbSThree();
		System.out.println("################### NB 04 ###################\n\n");
		nbTesting.generateNbSFour();		
		System.out.println("################### NB 05 ###################\n\n");
		nbTesting.generateNbFive();	
		System.out.println("################### NB 06 ###################\n\n");
		nbTesting.generateNbSSix();

		 */

	}

}
