import java.util.Random;

public class QuickSort extends Sorter{

    private static final Random random = new Random();

    public QuickSort(int[] data, String[] text, int speed) {
        super(data, text, speed);
        visualizer.getFrame().setTitle("Quick Sort");
    }

    @Override
    public void sort() {
        quickSort(0, data.length - 1);
    }

    public void quickSort(int left, int right) {
        while (left < right) {
            int pivot = randomPartition(left, right);

            // Recurse on smaller side first
            if (pivot - left < right - pivot) {
                quickSort(left, pivot - 1);
                left = pivot + 1;   // tail recursion eliminated
            } else {
                quickSort(pivot + 1, right);
                right = pivot - 1;  // tail recursion eliminated
            }
        }
    }


    private int randomPartition(int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(randomIndex,right);
        visualizer.getPanel().setHighlight(randomIndex,right);
        return partition(left, right);
    }

    private int partition(int left, int right) {
        int pivot = data[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (data[j] <= pivot) {
                i++;
                sleep();
                swap(i, j);
                visualizer.getPanel().setHighlight(i,j);
            }
        }
        swap(i + 1, right);
        visualizer.getPanel().setHighlight(i + 1,right);
        return i + 1;
    }


    public int[] swap(int start, int end) {
        int temp = this.data[start];
        this.data[start] = this.data[end];
        this.data[end] = temp;

        String temp2 = this.text[start];
        this.text[start] = this.text[end];
        this.text[end] = temp2;

        return this.data;
    }
}
