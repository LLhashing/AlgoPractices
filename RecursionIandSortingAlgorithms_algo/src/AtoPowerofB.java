//Evaluate a to the power of b,
// assuming both a and b are integers and b is non-negative.

/**
 * Solution
 */
public class AtoPowerofB {
    public long power(int a, int b) {
        if(b == 0){
            return 1;
        }else if (b ==1){
            return a;
        }
        int odd = b%2;
        long half = a*power(a,b/2-1);
        if(odd == 0){
            return half*half;
        }else{
            return half*half*a;
        }
    }
}
