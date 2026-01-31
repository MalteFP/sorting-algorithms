public class InsertionSort extends Sorter{
    public InsertionSort(int[] data, int speed) {
        super(data, speed);
        visualizer.getFrame().setTitle("Insertion Sort");
    }

    @Override
    public void sort() {
        visualizer.startTimer();
        for(int i = 1; i < data.length; i++){

            int key = data[i];
            int j = i - 1;
            while(j >= 0 && data[j] > key){
                sleep();
                this.visualizer.getPanel().setHighlight(i,j);
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = key;
        }
        visualizer.pauseTimer();
    }
}
