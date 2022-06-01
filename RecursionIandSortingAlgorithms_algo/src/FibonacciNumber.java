//Get the Kth number in the Fibonacci Sequence.
// (K is 0-indexed, the 0th Fibonacci number is 0
// and the 1st Fibonacci number is 1).

/**
 * Solution
 */
public class FibonacciNumber {
    public int fibonacci(int K) {
        if(K == 0){
            return 0;
        }else if(K == 1){
            return 1;
        }
        return fibonacci(K-1)+fibonacci(K-2);
    }
}
