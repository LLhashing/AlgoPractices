//Merge Sort is a Divide and Conquer algorithm.
// It divides the input array into two halves, calls itself for the two halves,
// and then merges the two sorted halves. The merge() function is used for merging two halves.
// The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and arr[m+1..r]
// are sorted and merges the two sorted sub-arrays into one.

/**
 * implementation
 *
 */
public class MergeSort {
    public int[] mergeSort(int[] array) {
        if(array == null || array.length <= 1){
            return array;
        }
        return mergeSort(array, 0, array.length-1);
    }
    private int[] mergeSort(int[] array, int left, int right){
        if(left == right){
            return new int[]{array[left]};
        }
        int mid = left + (right-left)/2;
        int[] leftResult = mergeSort(array, left, mid);
        int[] rightResult = mergeSort(array,mid+1,right);
        return merge(leftResult,rightResult);
    }
    private int[] merge(int[] leftResult, int[] rightResult){
        int left = 0 ;
        int right = 0;
        int index = 0;
        int[] result = new int[leftResult.length+rightResult.length];
        while(left < leftResult.length && right <rightResult.length){
            if(leftResult[left] <= rightResult[right]){
                result[index ++] = leftResult[left ++];
            }else{
                result[index ++] = rightResult[right ++];
            }
        }
        while(left < leftResult.length){
            result[index ++] = leftResult[left ++];
        }
        while(right < rightResult.length){
            result[index ++] = rightResult[right ++];
        }
        return result;
    }
}
