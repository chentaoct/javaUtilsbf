package com.shanghai.utils.sort;

/**
 * Created by 陈涛 on 2017/11/27.
 */
public class BubbleSort2 {
    public static void main(String[] args) {
        int[] array = {1, 8, 2, 5};
        for (int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]<array[j+1]){
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }

        }
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
