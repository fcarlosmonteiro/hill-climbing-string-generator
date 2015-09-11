package br.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import br.unesp.stringsearch.databases.Ieee;
import searchstring.Neiborhood;
import searchstring.SearchStringClass;



public class Main {

	public static void main(String[] args) throws Exception{
		ArrayList<String> part1 = new ArrayList<String>();
		ArrayList<String> part2 = new ArrayList<String>();
		ArrayList<String> part3 = new ArrayList<String>();

		if (args.length != 2)
		{
			System.out.println("Missing or extra arguments!!!");
			System.out.println("Missing argument: args[0] or args[1] are missing");
			System.out.println("Try again later ... ");
			System.exit(0);
		}
		else
		{
			FileInputStream fstream = new FileInputStream(args[0]);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			int partNum = 0;
					String strLine;
			while ((strLine = br.readLine()) != null)   {
				if (strLine.equals(""))
				{	
					partNum++;
				}
				else{ // else 0
					switch (partNum) {
					case 0:
						part1.add(strLine.toLowerCase().trim());
						break;
					case 1:
						part2.add(strLine.toLowerCase().trim());
						break;
					case 2:
						part3.add(strLine.toLowerCase().trim());
						break;
					default:
						break;
					}
				} // end else 0
			}// end while
			br.close();
		}// end else	
		
		
		//Saving original String
		if (readAndSaveOriginalString(args[1]));
			//System.out.println("Original string saved succesfully ... ");
		else
			System.out.println("Something is wrong with the original String ...");
		
		
		SearchStringClass sReal = new SearchStringClass(part1, part2, part3);
		Neiborhood nbTesting = new Neiborhood(sReal);
		//System.out.println("################### NB 01 ###################\n\n");
		nbTesting.generateNbSOne();		
		//System.out.println("################### NB 02 ###################\n\n");
		nbTesting.generateNbSTwo();		
		//System.out.println("################### NB 03 ###################\n\n");
		nbTesting.generateNbSThree();
		//System.out.println("################### NB 04 ###################\n\n");
		nbTesting.generateNbSFour();
		
		
	}
	
	
	public static boolean readAndSaveOriginalString(String originalPath) throws IOException
	{
		ArrayList<String> part1 = new ArrayList<String>();
		ArrayList<String> part2 = new ArrayList<String>();
		ArrayList<String> part3 = new ArrayList<String>();
		
		FileInputStream fstream = new FileInputStream(originalPath);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		int partNum = 0;
				String strLine;
		while ((strLine = br.readLine()) != null)   {
			if (strLine.equals(""))
			{	
				partNum++;
			}
			else{ // else 0
				switch (partNum) {
				case 0:
					part1.add(strLine.toLowerCase().trim());
					break;
				case 1:
					part2.add(strLine.toLowerCase().trim());
					break;
				case 2:
					part3.add(strLine.toLowerCase().trim());
					break;
				default:
					break;
				}
			} // end else 0
		}// end while
		br.close();
		
		
		String searchString;
		
		if (part3.size() > 0)
			searchString  = Ieee.generate(part1, part2, part3);			
		else
			searchString  = Ieee.generate(part1, part2);
		
		
		
		File confFile = null;
		try{
			confFile = new File("OriginalString"+File.separatorChar+"Original"+".txt"); 
			confFile.getParentFile().mkdirs();
		}catch(Exception e2)
		{
			System.err.println("Impossible to create "+e2);
			System.exit(0);	
		}


		try (PrintStream out = new PrintStream(new FileOutputStream(confFile))) {
			out.print(searchString);
			//System.out.println("File created succesfully");
			return true;
		}catch (Exception e) {
			System.err.println("Impossible to create "+e);
			System.exit(0);
		}
		
		return false;
	}
	
}
