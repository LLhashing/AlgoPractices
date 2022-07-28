//Given a target integer T, a non-negative integer K and an integer array
// A sorted in ascending order, find the K closest numbers to T in A.
// If there is a tie, the smaller elements are always preferred.

/**
 * Solution
 */
public class KClosestInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        if(array == null || array.length == 0 || k < 0){
            return null;
        }
        int left = largestSmallerEqual(array,target);
        int[] sol = new int[k];
        int right = left +1;
        for(int i = 0; i < k; i ++){
            if(right >= array.length || left >=0 && Math.abs(array[left]-target) <= array[right]-target){
                sol[i] = array[left --];
            }else{
                sol[i] = array[right ++];
            }
        }
        return sol;
    }

    public int largestSmallerEqual (int[] array, int target){
        int left = 0;
        int right = array.length-1;
        while(left < right -1){
            int mid = left + (right -left)/2;
            if(array[mid] >= target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(array[right] < target){
            return right;
        }else{
            return left;
        }
        //return Math.abs(array[left]-target) > Math.abs(array[right]-target) ? right :left;
    }
}
