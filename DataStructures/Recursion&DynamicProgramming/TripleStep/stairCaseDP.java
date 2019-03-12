import java.util.*;
public class stairCaseDP	{
	public static void main(String[] args)	{
		System.out.println("Start");
		int[] memo = new int[4];
		Arrays.fill(memo, -1);
		System.out.println("Number of ways : " + dp(3, memo));
	}

	public static int dp(int n, int[] memo)	{
		if(n < 0)
			return 0;
		else if(n == 0)
			return 1;
		if(memo[n] < 0)
			memo[n] = dp(n - 1, memo) + dp(n - 2, memo) + dp(n - 3, memo);
		return memo[n];

	}
}