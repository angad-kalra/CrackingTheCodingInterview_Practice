import java.util.*;
public class RobotDP	{
	public static void main(String[] args)	{
		System.out.println("Start");
		int k = 2;
		int rows = 3;
		int columns = 7;
		boolean[][] grid = new boolean[rows][columns];
		for(int i = 0; i< rows; i++)
			Arrays.fill(grid[i], true);
		grid[2][5] = false;
		grid[1][3] = false;
		List<Point> path = findPath(grid);
		for(Point p : path)	{
			System.out.print("(" + p.row + "," + p.column + ") -> ");
		}

	}

	public static List<Point> findPath(boolean[][] grid)	{
		if(grid.length == 0)
			return null;
		List<Point> path = new ArrayList<>();
		if(pathExists(grid, grid.length - 1, grid[0].length - 1, path, new HashSet<Point>()))
			return path;
		else
			return null;

	}

	public static boolean pathExists(boolean[][] grid, int row, int col, List<Point> path, Set<Point> failedPoints)	{
		
		if(row<0 || col<0 || !grid[row][col])
			return false;

		Point p = new Point(row, col);

		if(failedPoints.contains(p))		//visited and path does not exist
			return false;
		boolean atOrigin = (row == 0 && col == 0);

		if(atOrigin || pathExists(grid, row-1, col, path, failedPoints) || pathExists(grid, row, col-1, path, failedPoints))	{
			path.add(p);
			return true;
		}

		failedPoints.add(p);
		return false;
	}

}

class Point 	{
	int row;
	int column;

	Point(int r, int c)	{
		row = r;
		column = c;
	}
}