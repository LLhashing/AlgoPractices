//Given an array of integers, move all the 0s to the right end of the array.
//The relative order of the elements in the original array does not need to be maintained.

/**
 * Implementation
 */
public class Move0sToEndI {
    public int[] moveZero(int[] array) {
        if(array == null || array.length <= 1){
            return array;
        }
        int leftBound = 0;
        int rightBound = array.length -1;
        while(leftBound <= rightBound){
            if(array[leftBound] != 0){
                leftBound ++;
            }else if(array[rightBound] == 0){
                rightBound --;
            }else{
                swap(array,leftBound ++,rightBound --);
            }
        }
        return array;
    }
    private void swap (int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
