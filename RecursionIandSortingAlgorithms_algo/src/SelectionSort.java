//The selection sort algorithm sorts an array by repeatedly finding the minimum element
// from unsorted part and putting it at the beginning.
// The algorithm maintains two subarrays in a given array.

/**
 * implementation
 * Time Complexity: O(n2) as there are two nested loops.
 * Auxiliary Space: O(1)
 */
public class SelectionSort {
    public int[] solve(int[] array) {
        if(array == null || array.length <=1){
            return array;
        }
        for(int i = 0; i < array.length-1; i ++){
            int cur = i;
            for(int j = i+1; j< array.length; j++){
                if(array[j] < array[cur]){
                    cur = j;
                }
            }
            swap(array,i,cur);
        }
        return array;
    }
    private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
