import java.util.Arrays;

public class MergeSort extends Sorter{
    public MergeSort(int[] data, int speed) {
        super(data, speed);
        visualizer.getFrame().setTitle("Merge Sort");
    }

    @Override
    public void sort() {
        visualizer.startTimer();
        mergeSort(data, 0, data.length - 1);
        visualizer.pauseTimer();
    }


    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {return;}
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int indicesInLeft = mid - left + 1;
        int indicesInRight = right - mid;

        int[] L = Arrays.copyOfRange(arr, left, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);


        int l = 0, r = 0, a = left;

        while (l < indicesInLeft && r < indicesInRight) {
            visualizer.getPanel().setHighlight(left + l, right + r);
            sleep();

            if (L[l] < R[r]) {
                arr[a] = L[l];
                l++;
            } else  {
                arr[a] = R[r];
                r++;
            }
            a++;
        }
        while (l < indicesInLeft) {
            visualizer.getPanel().setHighlight(left + l, a);
            sleep();

            arr[a] = L[l];
            l++;
            a++;
        }
        while (r < indicesInRight) {
            visualizer.getPanel().setHighlight(mid + 1 + r, a);
            sleep();

            arr[a] = R[r];
            r++;
            a++;
        }
    }
}
