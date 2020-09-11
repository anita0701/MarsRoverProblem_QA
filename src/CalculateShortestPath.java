import java.util.*; 

class CalculateShortestPath

{ 
	static int ROW; 
	static int COL;
	static int mat[][];


	//To store rover cell coordinates 
	static class Point 
	{ 
		int x; 
		int y;

		public Point(int x, int y) 
		{ 
			this.x = x; 
			this.y = y; 
		} 
	}; 


	// A Data Structure for queue used in BFS 
	static class queueNode 
	{ 
		Point pt; // The cordinates of a cell 
		int dist; // cell's distance of from the source 

		public queueNode(Point pt, int dist) 
		{ 
			this.pt = pt; 
			this.dist = dist; 
		} 
	}; 


	static boolean isValid(int row, int col) 
	{ 

		return (row >= 0) && (row < ROW) && 
				(col >= 0) && (col < COL); 
	} 


	static int rowNum[] = {-1, 0, 0, 1}; 
	static int colNum[] = {0, -1, 1, 0}; 

	// function to find the shortest path between Rover and rareElement. 
	static int BFS(int mat[][], Point src, 
			Point dest) 
	{ 
		if (mat[src.x][src.y] != 1 || 
				mat[dest.x][dest.y] != 1) 
			return -1; 

		boolean [][]visited = new boolean[ROW][COL]; 

		visited[src.x][src.y] = true; 

		Queue<queueNode> q = new LinkedList<>(); 

		queueNode s = new queueNode(src, 0); 
		q.add(s);

		while (!q.isEmpty()) 
		{ 
			queueNode curr = q.peek(); 
			Point pt = curr.pt; 

			// If we have reached the rareElement Coordinates,we are done 
			if (pt.x == dest.x && pt.y == dest.y) 
				return curr.dist; 

			q.remove(); 

			for (int i = 0; i < 4; i++) 
			{ 
				int row = pt.x + rowNum[i]; 
				int col = pt.y + colNum[i]; 


				if (isValid(row, col) && 
						mat[row][col] == 1 && 
						!visited[row][col]) 
				{ 
					visited[row][col] = true; 
					queueNode Adjcell = new queueNode(new Point(row, col), 
							curr.dist + 1 ); 
					q.add(Adjcell); 
				} 
			} 
		} 

		// Return -1 if RareElement cannot be reached 
		return -1; 
	} 


    //Initialize GRID
	public static void initializegrid(int M,int N)
	{
		CalculateShortestPath.ROW=M;
		CalculateShortestPath.COL=N;
		CalculateShortestPath.mat = new int[M][N];

		for(int a=0;a<M;a++)
		{
			for(int b=0;b<N;b++)
			{
				mat[a][b]=1;

			}
		}


	}
    //set obstacles in grid
	public static void setObstacle(int ox,int oy)
	{
		mat[ox][oy]=0;
	}

	// calculateShortestDistance 
	public static int calculatePath(int x,int y,int i,int j) 
	{ 

		Point RoverCoordinate =  new CalculateShortestPath.Point(x, y); 
		Point RareElementCoordinate = new CalculateShortestPath.Point(i, j); 
		int dist = BFS(mat, RoverCoordinate, RareElementCoordinate); 
		return dist;

	} 

} 
