import java.util.Scanner;

public class MarsRover {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter M :");
		int M = sc.nextInt();
		System.out.println("Enter N :");
		
		int N = sc.nextInt();	
		CalculateShortestPath.initializegrid(M,N );

		System.out.println("Enter number of Obstacles :");
		int P = sc.nextInt();
		
		for(int i=0;i<P;i++)
		{
			System.out.println("Enter coordinates of obstacle "+ (i+1));
			int ox = sc.nextInt();
			int oy = sc.nextInt();
			CalculateShortestPath.setObstacle(ox, oy);
			
		}
		System.out.println("Enter coordinate of Rare Element :");
		Integer i = sc.nextInt();
		Integer j = sc.nextInt();
		
		System.out.println("Enter x coordinate of US Rover: ");
		Integer x1 = sc.nextInt();
		System.out.println("Enter y coordinate of US Rover: ");
		Integer y1 = sc.nextInt();
		System.out.println("Enter direction for US Rover: ");
		Integer dirUS = sc.nextInt();
		
		int shortestPathUS = CalculateShortestPath.calculatePath(x1,y1,i,j);
		
		System.out.println("Enter x coordinate of Russia Rover: ");
		Integer x2 = sc.nextInt();
		System.out.println("Enter y coordinate of Russia Rover: ");
		Integer y2 = sc.nextInt();
		System.out.println("Enter direction for Russia Rover: ");
		Integer dirRus = sc.nextInt();
		
		int shortestPathRussia = CalculateShortestPath.calculatePath(x2,y2,i,j);
		
		if (shortestPathUS != Integer.MAX_VALUE) 
			System.out.println("Shortest Path for US Rover "+ shortestPathUS); 
		else
			System.out.println(-1); 
		
		if (shortestPathRussia != Integer.MAX_VALUE) 
			System.out.println("Shortest Path for Russia Rover "+ shortestPathRussia); 
		else
			System.out.println(-1); 
		
		if(shortestPathUS < shortestPathRussia)
			
			System.out.println("US is winner");
		
		else if(shortestPathUS > shortestPathRussia)
		  System.out.println("Russia is winner");
		
		else if(shortestPathUS == shortestPathRussia)
			System.out.println("Tie");
		else
			System.out.println(-1);
		
	}

}