package 排序;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @Author qiximiao
 * @Date 2020-12-06
 */
public class MaopaoSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 7, 2};
        sort(arr);
        Arrays.asList(arr);
    }

    static public void sort(int[] arr){
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    exchnge(arr, j);
                }
            }
        }
    }

    private static void exchnge(int[] arr, int j) {
        int t= arr[j];
        arr[j]= arr[j +1];
        arr[j +1]= t;
    }
}
