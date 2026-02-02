public class CountingSort extends Sorter{
    public CountingSort(int[] data, int speed) {
        super(data, speed);
        visualizer.getFrame().setTitle("Counting Sort");
    }

    @Override
    public void sort() {
        int maxValue = 0;
        int maxIndex;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > maxValue) {
                maxValue = data[i];
                maxIndex = i;
                sleep();
                visualizer.getPanel().setHighlight(i,maxIndex);
            }
        }


        int[] count = new int[maxValue + 1];
        for (int i = 0; i < data.length; i++) {
            visualizer.getPanel().setHighlight(maxValue, i);
            if (data[i] > maxValue) {
                maxValue = data[i];
                sleep();
            }
            count[data[i]]++;
            sleep();
        }

        int index = 0;
        for (int value = 0; value < count.length; value++) {
            for (int c = 0; c < count[value]; c++) {
                visualizer.getPanel().setHighlight(index, c);
                data[index++] = value;
                sleep();
            }
        }
        count = null;

    }

}
