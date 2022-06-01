//Given an array of balls, where the color of the balls can only be Red, Green or Blue,
// sort the balls such that all the Red balls are grouped on the left side,
// all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side.
// (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

/**
 * implementation
 */
public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        if(array == null || array.length <= 1){
            return array;
        }
        int redBound = 0; //exclusive -1
        int greenBound = 0; //exclusive 0
        int blueBound = array.length -1 ;
        while(greenBound <= blueBound){
            if(array[greenBound] == -1){
                swap(array, redBound ++, greenBound ++);
            }else if(array[greenBound] == 0){
                greenBound ++ ;
            }else{
                swap(array, greenBound , blueBound--);
            }
        }
        return array;
    }
    private void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
