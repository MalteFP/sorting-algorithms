import java.util.ArrayList;
import java.util.Random;

public class ArrayMaker {



    public static int[] randomArray(int length) {
        Random rand = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(length);
        }
        return arr;
    }


    public static int[] randomLinearArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            int temp = arr[i];
            int j = rand.nextInt(i + 1);
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
