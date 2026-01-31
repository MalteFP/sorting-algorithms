import java.util.ArrayList;

public class ArrayMaker {



    public static int[] randomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        return arr;
    }


    public static int[] randomLinearArray(int length) {
        int[] arr = new int[length];
        ArrayList<Integer> sortedArray = new ArrayList();
        for (int i = 0; i < length; i++) {
            sortedArray.add(i);
        }
        for (int i = 0; i < length; i++) {
            int randIndex = (int) (Math.random() * sortedArray.size());
            arr[i] = sortedArray.get(randIndex);
            sortedArray.remove(randIndex);
        }
        return arr;
    }
}
