public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = ArrayMaker.randomLinearArray(200);
        new BubbleSort(arr,1);
        new CocktailShakerSort(arr,1);

    }
}