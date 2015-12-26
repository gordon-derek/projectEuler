package projectEuler.P002;

/**
 * Derek Gordon
 * 12/21/2015
 */
public class P2 {

    private static final int MAX = 4000000;

    public static void main(String[] args) {
        System.out.println(Integer.toString(fibSumEvens(MAX)));
    }

    private static boolean isEven(int num) {return num%2==0;}

    private static int fibSumEvens(int limit){
        int low = 1;
        int high = 2;
        int sum = 2;

        while(high <= limit){
            int temp = high;
            high += low;
            low = temp;
            if(isEven(high))
                sum += high;
        }

        return sum;
    }

}
