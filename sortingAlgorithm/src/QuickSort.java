import java.util.Random;

public class QuickSort extends Sorter{

    private static final Random random = new Random();

    public QuickSort(int[] data, int speed) {
        super(data, speed);
        visualizer.getFrame().setTitle("Quick Sort");
    }

    @Override
    public void sort() {
        quickSort(0, data.length - 1);
    }

    public void quickSort(int left, int right) {
        if (left < right) {
            visualizer.getPanel().setHighlight(left, right);
            int pivot = randomPartition(left, right);
            visualizer.getPanel().setHighlight(pivot,right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
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


    public void swap(int start, int end) {
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
    }
}
