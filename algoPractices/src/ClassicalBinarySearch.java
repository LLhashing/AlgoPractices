//Given a target integer T and an integer array A sorted in ascending order,
// find the index i such that A[i] == T or return -1 if there is no such index.

/**
 * Solution
 */
public class ClassicalBinarySearch {
    public int binarySearch(int[] array, int target) {
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length -1;
        while(left <= right){
            int mid = left +(right-left)/2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] >target){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
}
