package searchstring.testing;



import java.util.ArrayList;

public class TestingNeighborhood {

	ArrayList<String> part1; 
	ArrayList<String> part2; 
	ArrayList<String> part3; 
	
	
	
		public void settingStrings()
	{
		part1 = new ArrayList<String>();
		part2 = new ArrayList<String>();
		part3 = new ArrayList<String>();
	//cobaia a ser utilizada... Disponível em http://www.cos.ufrj.br/~schots/papers/schots2014a.pdf
		part1.add("software"); part1.add("system");  part1.add("program"); 
		part1.add("asset"); part1.add("application"); part1.add("artifact");
		
		part2.add("reuse"); part2.add("reusable"); part2.add("reusability");
		
		part3.add("visualizaton"); part3.add("visualisaton"); part3.add("visual");
		
	}
	
	
	
	
}
