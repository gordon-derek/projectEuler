// Derek Gordon
// 12/21/2015

package projectEuler.P1;

public class P1 {
	private final static int MAX = 1000;
	
	public static void main(String[] args){
		//add all multiples of 3 and 5, subtract the duplicates
		int multipleSum = sum(3,MAX) + sum(5,MAX) - sum(15,MAX);
		System.out.println(Integer.toString(multipleSum));
	}
	
	//add num to itself until limit is hit
	//add on each iteration to sum.
	private static int sum(int num, int limit){
		int sum = 0;
		for(int i = num; i < limit; i+=num){
			sum += i;
		}
		
		return sum;
	}
}
