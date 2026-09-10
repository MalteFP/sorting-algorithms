public class StalinSort extends Sorter {
    public StalinSort(int[] data, int speed) {
        super(data, speed);
        visualizer.getFrame().setTitle("Stalin Sort");
    }

    @Override
    public void sort() {
        int compare = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < compare) {
                data[i] = 0;
            } else {
                compare = data[i];
            }
            sleep();
        }
    }
}
