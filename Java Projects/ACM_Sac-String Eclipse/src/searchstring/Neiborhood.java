package searchstring;


import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.atteo.evo.inflector.English;

import br.unesp.stringsearch.databases.Ieee;

/**
 * Esta classe vai gerar string genéricas modificadas a partir da String original.
 * A geração depende do número da vizinhança a ser passada como parâmetro para o método construtor 
 * da classe.
 * 
 * 
 */
public class Neiborhood {

	private SearchStringClass searchString; 
	private int sizeOfStringPart1;
	private int sizeOfStringPart2;
	private int sizeOfStringPart3;

	/**
	 * Método construtor
	 * 
	 * @param searchString = Classe com a String de pesquisa
	 * @param sizeOfNeighborhood = número de vizinhos. Hbaitualmente 2 ou 4 
	 */
	public Neiborhood(SearchStringClass searchString)
	{
		this.searchString = searchString;
		//setSizeOfNeighborhood(sizeOfNeighborhood);
		setSizeOfStringPart1(searchString.getPart1().size());
		setSizeOfStringPart2(searchString.getPart2().size());
		setSizeOfStringPart3(searchString.getPart3().size());
		erasePreviousDiretoryes();

	}

	private boolean erasePreviousDiretoryes()
	{
		File f;

		for (int i=1; i<=6; i++)
		{
			f = new File ("NB0"+i);
			if (f.exists())
			{
				removeDirectory(f);
			}

		}

		return false;
	}



	public SearchStringClass getSearchString()
	{
		return searchString; 	
	}

	/**
	 * Retira um termo da populacao (primeira parte da String). 
	 * Eh chamado "n" vezes de acordo com o num de keywords
	 * 
	 * @param searchString
	 * @return 
	 */
	private String generateNeighborOne(int order)
	{   String newString = null;
	ArrayList<String> firstPart = searchString.getPart1();		
	String removed = firstPart.remove(order);
	if (searchString.getTriplePartSearchString())
	{
		newString = Ieee.generate(firstPart, searchString.getPart2(), searchString.getPart3());
	}
	else
		newString = Ieee.generate(firstPart, searchString.getPart2());

	firstPart.add(order, removed);
	return newString;	
	}
//system application
	public void generateNbSOne()
	{
		//for (int i=0; i<sizeOfStringPart1; i++)
		//{
		//	saveNeighborToFile("NB01",  i  , generateNeighborOne(i));
		//}
            int lastIndex = searchString.getPart1().size()-1;	
            saveNeighborToFile("NB01",  lastIndex  , generateNeighborOne(lastIndex));
	}


	public void generateNbSTwo()
	{
		//ArrayList<String> partOne = searchString.getPart1();
		ArrayList<String> partTwo = searchString.getPart2();
		ArrayList<String> partThree = searchString.getPart3();

		//generateNeighborTwo(partOne, 1);		
		if (!generateNeighborTwo(partTwo, 2))
                {
                    if (searchString.getTriplePartSearchString())
			generateNeighborTwo(partThree, 3);
                }
	}



	private boolean generateNeighborTwo(ArrayList<String> array, int part)
	{
            /*
		if (!array.isEmpty() && !array.equals(null))
		{
			for (int i=0; i<array.size(); i++)
			{
				String kw = (String) array.get(i);			
				if (kw.contains("-"))
				{	
					array.set(i, kw.replaceAll("-"," "));
					saveNeighborToFile("NB02", i, part, genString(array,i, part));
					array.set(i, kw);

				}else if (kw.contains(" "))
				{
					array.set(i, kw.replaceAll(" ", "-"));
					saveNeighborToFile("NB02", i, part, genString(array,i, part));
					array.set(i, kw);

				}
			}
		}
		else
		{
			System.err.println("Empity array");
		}
                */
            
            if (!array.isEmpty() && !array.equals(null))
		{
			for (int i=0; i<array.size(); i++)
			{
				String kw = (String) array.get(i);			
				if (kw.contains("-"))
				{	
					array.set(i, kw.replaceAll("-"," "));
					saveNeighborToFile("NB02", i, part, genString(array,i, part));
					array.set(i, kw);
                                        return true;

				}else if (kw.contains(" "))
				{
					array.set(i, kw.replaceAll(" ", "-"));
					saveNeighborToFile("NB02", i, part, genString(array,i, part));
					array.set(i, kw);
                                        return true;

				}
			}
                        return false;
		}
		else
		{
			System.err.println("Empity array");
                         return false;
		}
        }

	private String genString(ArrayList<String> array, int part, int order)
	{
		String newNeighbor = null;

		if (order ==1)
		{
			if (searchString.getTriplePartSearchString())
				newNeighbor = Ieee.generate(array, searchString.getPart2(), searchString.getPart3());
			else
				newNeighbor = Ieee.generate(array, searchString.getPart2());

		}
		else if (order ==2)
		{
			if (searchString.getTriplePartSearchString())
				newNeighbor = Ieee.generate(searchString.getPart1(), array, searchString.getPart3());
			else
				newNeighbor = Ieee.generate(searchString.getPart1(), array);	

		}
		else if (order ==3 && searchString.getTriplePartSearchString())
		{
			newNeighbor = Ieee.generate(searchString.getPart1(), searchString.getPart2(), array);

		}
		else{
			System.err.println("Wrong order ... ");
		}


		return newNeighbor;
	}




	private String generationSupportSteemer(int order)
	{
		ArrayList<String> firstPart = searchString.getPart1();		
		String toBeReplaced =   firstPart.get(order);
		
                System.out.println(" --- "+toBeReplaced);
                
		Stemmer stKW = new Stemmer();		
		String radical = stKW.stemmerMyKeyWord(toBeReplaced);
                
                //System.out.println(" -- RADICAL -- "+radical);
		
                radical = setLastChar(radical);
                
		//firstPart.set(order, radical);
                 firstPart.set(order, radical+"*");
		String newString;
		if (searchString.getTriplePartSearchString())
			newString = Ieee.generate(firstPart, searchString.getPart2(), searchString.getPart3());
		else 
			newString = Ieee.generate(firstPart, searchString.getPart2());

		firstPart.set(order, toBeReplaced);

		return newString;	

	}
	
	private String setLastChar(String term)
        {
            char last;
            last = term.charAt(term.length()-1);
            if ((last == 'a')||(last == 'e')||(last == 'i')||(last == 'o')
                    ||(last == 'u'))
            {
                term = term.substring(0, term.length()-1);
            }   
            
            
            return term;
        }
	private String generateKWPlural (int order)
	{
            /*
		ArrayList<String> firstPart = searchString.getPart1();		
		String toBeReplaced =   firstPart.get(order);
		
		String plural = English.plural(toBeReplaced);
		
		firstPart.set(order, plural);
		String newString;
		if (searchString.getTriplePartSearchString())
			newString = Ieee.generate(firstPart, searchString.getPart2(), searchString.getPart3());
		else 
			newString = Ieee.generate(firstPart, searchString.getPart2());

		firstPart.set(order, toBeReplaced);
            

		return newString;	
                */
            ArrayList<String> firstPart = searchString.getPart1();	
            System.out.println(" --- "+firstPart.get(0));
		String toBeReplaced =   firstPart.get(order);
		
		String plural = English.plural(toBeReplaced);
		
		//firstPart.set(order, plural);
                firstPart.add(order+1, plural);
		String newString;
		if (searchString.getTriplePartSearchString())
			newString = Ieee.generate(firstPart, searchString.getPart2(), searchString.getPart3());
		else 
			newString = Ieee.generate(firstPart, searchString.getPart2());

		//firstPart.set(order, toBeReplaced);
                 firstPart.remove(order+1);

		return newString;	
            
		
	}
	

	//substituir cada termos da populacao pelo plural usando uma API de plurais em inglês
	public void generateNbSThree()
	{
		//for (int i=0; i<sizeOfStringPart1; i++)
		//{
		//	saveNeighborToFile("NB03",  i  , generateKWPlural(i));
		//}
         
                 saveNeighborToFile("NB03", 0  , generateKWPlural(0));   
	}

	
	/*
	 * Stemmer st1 = new Stemmer();
		
		System.out.println(" Study "+ st1.stemmerMyKeyWord("study"));
		System.out.println(" Testing "+ st1.stemmerMyKeyWord("Testing"));
		System.out.println(" Tester "+ st1.stemmerMyKeyWord("Tester"));
		System.out.println(" Method "+ st1.stemmerMyKeyWord("Method"));
		System.out.println(" Engineering "+ st1.stemmerMyKeyWord("Engineering"));
	 */
	
	
	//substituir cada termos da populacao por seu radical + coringa "*"
	public void generateNbSFour()
	{
		//for (int i=0; i<sizeOfStringPart1; i++)
		//{
			//saveNeighborToFile("NB04",  i  , generationSupportSteemer(i));
	///}
            
            saveNeighborToFile("NB04",  0  , generationSupportSteemer(0));
	}



	// adicionar o termo plural de cada kw da intervencao
	private String generateNeighborFive(int order)
	{
		ArrayList<String> firstPart = searchString.getPart1();		
		String toPlural =   firstPart.get(order);
		//API que acha o plural
		firstPart.add(order+1, toPlural+"s");
                

		String newString;
		if (searchString.getTriplePartSearchString())
			newString = Ieee.generate(firstPart, searchString.getPart2(), searchString.getPart3());
		else
			newString = Ieee.generate(firstPart, searchString.getPart2());	

		firstPart.remove(order+1);

		return newString;	
	}


	public void generateNbFive()
	{
		for (int i=0; i<sizeOfStringPart1; i++)
		{
			saveNeighborToFile("NB05",  i  , generateNeighborFive(i));
		}	
	}




	public void generateNbSSix()
	{
		for (int i=0; i<sizeOfStringPart2; i++)
		{
			saveNeighborToFile("NB06",  i  , generateNeighborSix(i));
		}
	}

	//retirar um item da intervencao
	public String generateNeighborSix(int order)
	{
		ArrayList<String> secondPart = searchString.getPart2();		
		String removed = secondPart.remove(order);
		String newString;

		if (searchString.getTriplePartSearchString())
			newString = Ieee.generate(searchString.getPart1(), secondPart, searchString.getPart3());
		else
			newString = Ieee.generate(searchString.getPart1(), secondPart); 	

		secondPart.add(order, removed);

		return newString;	
	}





	public int getSizeOfStringPart1() {
		return sizeOfStringPart1;
	}

	private void setSizeOfStringPart1(int sizeOfStringPart1) {
		this.sizeOfStringPart1 = sizeOfStringPart1;
	}

	public int getSizeOfStringPart2() {
		return sizeOfStringPart2;
	}

	private void setSizeOfStringPart2(int sizeOfStringPart2) {
		this.sizeOfStringPart2 = sizeOfStringPart2;
	}

	public int getSizeOfStringPart3() {
		return sizeOfStringPart3;
	}

	private void setSizeOfStringPart3(int sizeOfStringPart3) {
		this.sizeOfStringPart3 = sizeOfStringPart3;
	}

	/*private int countOccurrences(String word, char needle)
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
	}*/
	
	
	
	

	private void saveNeighborToFile(String neighbor, int order, String searchString)
	{
		File confFile = null;
		try{
			confFile = new File(neighbor+File.separatorChar+"Nb"+order+".txt"); 
			confFile.getParentFile().mkdirs();
		}catch(Exception e2)
		{
			System.err.println("Impossible to create "+e2);
			System.exit(0);	
		}


		try (PrintStream out = new PrintStream(new FileOutputStream(confFile))) {
			out.print(searchString);
		}catch (Exception e) {
			System.err.println("Impossible to create "+e);
			System.exit(0);
		}
		System.out.println("File created succesfully");
	}

	private void saveNeighborToFile(String neighbor, int order, int part, String searchString)
	{
		File confFile = null;
		try{
			confFile = new File(neighbor+File.separatorChar+"Nb"+part+"-"+order+".txt"); 
			confFile.getParentFile().mkdirs();
		}catch(Exception e2)
		{
			System.err.println("Impossible to create "+e2);
			System.exit(0);	
		}


		try (PrintStream out = new PrintStream(new FileOutputStream(confFile))) {
			out.print(searchString);
		}catch (Exception e) {
			System.err.println("Impossible to create "+e);
			System.exit(0);
		}
		System.out.println("File created succesfully");
	}


	public static boolean removeDirectory(File directory) {

		// System.out.println("removeDirectory " + directory);

		if (directory == null)
			return false;
		if (!directory.exists())
			return true;
		if (!directory.isDirectory())
			return false;

		String[] list = directory.list();

		// Some JVMs return null for File.list() when the
		// directory is empty.
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				File entry = new File(directory, list[i]);

				//        System.out.println("\tremoving entry " + entry);

				if (entry.isDirectory())
				{
					if (!removeDirectory(entry))
						return false;
				}
				else
				{
					if (!entry.delete())
						return false;
				}
			}
		}

		return directory.delete();
	}


}

/**

  self-adaptation OR self-adaptive software OR self-adaptive system OR self-adaptive systems 
  OR self-application OR self-properties OR self-property

  AND

  MDA OR MDD OR MDE OR MDSD OR model based OR model driven OR model-based OR model-driven


 **/


