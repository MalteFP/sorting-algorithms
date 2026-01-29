public class ArrayMaker {
    public static int[] randomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        return arr;
    }
}
