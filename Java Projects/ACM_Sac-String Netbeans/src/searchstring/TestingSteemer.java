package searchstring;

public class TestingSteemer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stemmer st1 = new Stemmer();
		
		System.out.println(" Study "+ st1.stemmerMyKeyWord("study"));
		System.out.println(" Testing "+ st1.stemmerMyKeyWord("Testing"));
		System.out.println(" Tester "+ st1.stemmerMyKeyWord("Tester"));
		System.out.println(" Method "+ st1.stemmerMyKeyWord("Method"));
		System.out.println(" Engineering "+ st1.stemmerMyKeyWord("Engineering"));
		
		
	}

}
