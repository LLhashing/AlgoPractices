//Given a integer dictionary A of unknown size,
// where the numbers in the dictionary are sorted in ascending order,
// determine if a given target integer T is in the dictionary.
// Return the index of T in A, return -1 if T is not in A.

/**
 * Solution
 */
public class SearchInUnknownSizedSortedArray {
    public int search(Dictionary dict, int target) {
        int left = 0;
        int right = 1;
        while(dict.get(left) != null && dict.get(right) != null && dict.get(right) < target){
            left = right;
            right = right*2;
        }
        while(left <= right){
            int mid = left+(right-left)/2;
            if(dict.get(mid) == null){
                right = mid-1;
            }else if(dict.get(mid) == target){
                return mid;
            }else if(dict.get(mid) < target){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return -1;

    }
}
