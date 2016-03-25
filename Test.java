import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
	private Scanner input1;
	private int questionCount;
	//HashMap hash;
	Map<Integer, Question> hash;

	public Test() 
	{
		System.out.println("Lets Set Up Your Test Object...");
		System.out.println("*******************************");

		fillMap();
		printTestSummary();
		fillQuestionData();
	}
	
	public void fillMap()
	{
		//enter number of questions
		System.out.println("Please enter how many questions were on your test: ");
		input1 = new Scanner(System.in);
		int input = input1.nextInt();
		if(input < 1)  //bad test
		{
			System.out.println("This is not a valid test.");
			System.exit(1);
		}
		else
		{
			//initialize hashMap with size of test
			questionCount = input;
			hash = new HashMap<Integer, Question>();
		}
		System.out.println("Number of questions: " + questionCount);
		//record how many 
		//fill the map with Question objects with specific parts
		for(int i = 1; i < questionCount + 1; i++)
		{
			//formatting
			System.out.println("");


			System.out.println("How many parts does question: "+i+" have?");
			System.out.println("******(true/false=1)******");
			int temp = input1.nextInt();
			Question tempQ = new Question(temp);
			hash.put(i, tempQ);
		}
	}

	public void fillQuestionData() 
	{
		System.out.println("We now need to know how much each sub-question was worth.");
		System.out.println("**********************");
		
		for (int i = 1; i < questionCount + 1; i++)
		{
			System.out.println("Enter worth of part:" + i);
			for(int j = 0; j < hash.get(i).parts.length; j++)
			{
				
			}
		}
	}
	
	public void printTestSummary() 
	{
		//format
		System.out.println("");
		System.out.print("Your Test:");

		//print entire hash 
		for (int i = 1; i < questionCount + 1; i++)
		{
            System.out.print("  Q->"+ i + "." + hash.get(i).partsNum);  
		}
		System.out.println("");
	}

	private static class Question
	{
		//instance variable
		private int partsNum;
		private double credit;
		private Part[] parts;

		//constructor for root
		public Question( int numParts)
		{
			partsNum = numParts;
			parts = new Part[partsNum];
			
			System.out.println(partsNum);
			for (int i = 0; i < partsNum; i++)
			{
				parts[i] = new Part();
			}
		}
		public double getCredit()
		{
			double result = 0.0;
			
			return result;
		}
		private static class Part
		{
			private int points;
			private int credit;
			public Part()
			{
				
			}
		}
	}

}



