//It picks an element as pivot and partitions the
// given array around the picked pivot.
//put x at its correct position in sorted array
// and put all smaller elements (smaller than x) before x,
// and put all greater elements (greater than x) after x

/**
 * Implementation
 *
 */
public class QuickSort {
    public int[] quickSort(int[] array) {
        if(array == null || array.length <= 1){
            return array;
        }
        quickSort(array, 0, array.length-1);
        return array;
    }
    private void quickSort(int[] array, int left, int right){
        if (left >= right){
            return;
        }
        int pivotPos = partition(array,left, right);
        quickSort(array, left, pivotPos);
        quickSort(array, pivotPos+1, right);
    }
    private int partition(int[] array, int left,int right){
        int pivotIndex = pivotIndex(left, right);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right -1;
        while(leftBound<=rightBound){
            if(array[leftBound] < pivot){
                leftBound ++;
            }else if(array[rightBound] >= pivot){
                rightBound --;
            }else{
                swap(array,leftBound,rightBound);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }
    private int pivotIndex(int left, int right){
        return (int)(Math.random()*(right-left+1))+left;
    }
    private void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
