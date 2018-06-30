import java.util.Arrays;

/**
 * 类名称：TestSortMethod<br>
 * 类描述：<br>
 * 创建时间：2018年05月12日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public class TestSortMethod {
    public static void main(String[] args) {
        int num = 12;
        final int[] arr = {100,1,99,3,900,22,789,10,34,17};
        //for (int i = 0; i < num; i++) {
            //arr[i] = (int) (Math.random() * 1000) + 1;
        //}
        //simple qsort
        System.out.println(arr.length);
        simpleQsort(arr,0,arr.length -1);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[binarySearch(arr,17,0,arr.length -1 )]);
    }

    public static void simpleQsort(int[] arr, int left, int right){
        if (arr == null || arr.length <= 1 || left >= right) {
            return;
        }
        /**
         *  or idx = new Random.nextInt(right - left + 1) + left;
         */
        int idx = (left + right) / 2;
        int i = left, j = right, pivot = arr[idx];
        while(i < j){
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        //此处有些人可能考虑 i+1， j-1，这样会导致部分排序没有完成，是错误的。
        simpleQsort(arr, i, right);
        simpleQsort(arr, left, j);
    }

    /**
     *
     * @param arr
     * @param value
     * @param left
     * @param right  right 初次必须是length - 1 ，否则某些case下会有错误，如{1,2,3} --> 3
     * @return
     */
    public static int binarySearch(int[] arr, int value, int left, int right) {
        if (arr == null || left > right) {
            return -1;
        }
        int idx = (left + right) / 2;
        if (arr[idx] == value) {
            return idx;
        }
        if (arr[idx] > value) {
            idx = binarySearch(arr, value, left, idx - 1);
            //注意此处必须是if else ，否则会多次匹配，导致去index = -1报错
        }else if(arr[idx] < value){
            idx = binarySearch(arr, value, idx + 1, right);
        }
        return idx;
    }
}
