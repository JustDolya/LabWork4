import java.util.*;

public class Main {
    public static int[][] inputArr(int n) {
        Random random = new Random();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
        return array;
    }

    public static void printArr(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] array = inputArr(8);
        printArr(array);
        int gap = array.length;
        while (gap != 1){
            if(gap > 1){
                gap = gap * 10 / 13;
            }
            else {
                gap = 1;
            }
            for (int i = gap; i < array.length; i++){
                if (array[i - gap][i - gap] > array[i][i]){
                    int tmp = array[i][i];
                    array[i][i] = array[i - gap][i - gap];
                    array[i - gap][i - gap] = tmp;
                }
            }
        }
        System.out.println("Массив с отсортированной главной диагональю:");
        printArr(array);
    }
}