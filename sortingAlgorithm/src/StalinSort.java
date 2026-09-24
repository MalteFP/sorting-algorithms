public class StalinSort extends Sorter {
    public StalinSort(int[] data, String[] text, int speed) {
        super(data, text, speed);
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
