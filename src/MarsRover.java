import java.util.Scanner;

public class MarsRover {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//Enter M value 
		int M = sc.nextInt();
		
		//Enter N value 
		
		int N = sc.nextInt();	
		CalculateShortestPath.initializegrid(M,N );

	    //Enter number of Obstacles
		int P = sc.nextInt();
		
		//input for getting coordinates of obstacles
		for(int i=0;i<P;i++)
		{
	
			int ox = sc.nextInt();
			int oy = sc.nextInt();
			CalculateShortestPath.setObstacle(ox, oy);
			
		}
	
		Integer i = sc.nextInt();
		Integer j = sc.nextInt();
		
		
		Integer x1 = sc.nextInt();
		Integer y1 = sc.nextInt();
		String dirUS = sc.next();
		
		int shortestPathUS = CalculateShortestPath.calculatePath(x1,y1,i,j);
		
		
		Integer x2 = sc.nextInt();
	
		Integer y2 = sc.nextInt();
	
		String dirRus = sc.next();
		
		int shortestPathRussia = CalculateShortestPath.calculatePath(x2,y2,i,j);
		
		if (shortestPathUS != Integer.MAX_VALUE) 
			System.out.println(shortestPathUS); 
		else
			System.out.println("NA"); 
		
		if (shortestPathRussia != Integer.MAX_VALUE) 
			System.out.println(shortestPathRussia); 
		else
			System.out.println("NA"); 
		
		if(shortestPathUS < shortestPathRussia)
			
			System.out.println("US");
		
		else if(shortestPathUS > shortestPathRussia)
		  System.out.println("Russia");
		
		else if(shortestPathUS == shortestPathRussia)
			System.out.println("Tie");
		else
			System.out.println(-1);
		
	}

}