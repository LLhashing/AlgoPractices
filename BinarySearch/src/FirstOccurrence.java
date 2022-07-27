//Given a target integer T and an integer array A sorted in ascending order,
// find the index of the first occurrence of T in A or return -1 if there is no such index.

/**
 * Solution
 */
public class FirstOccurrence {
    public int firstOccur(int[] array, int target) {
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length-1;
        while(left < right -1){
            int mid = left + (right-left)/2;
            if(array[right] >= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        if(array[left] == target){
            return left;
        }
        if(array[right] == target){
            return right;
        }
        return -1;
    }
}
