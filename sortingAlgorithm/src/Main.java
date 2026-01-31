public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = ArrayMaker.randomLinearArray(1000);
        new InsertionSort(arr.clone(),1);
        new BubbleSort(arr.clone(),1);
        new CocktailShakerSort(arr.clone(),1);
    }
}