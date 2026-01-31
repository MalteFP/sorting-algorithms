public class InsertionSort extends Sorter{
    public InsertionSort(int[] data, int speed) {
        super(data, speed);
        this.visualizer.getFrame().setTitle("Insertion Sort");
    }

    @Override
    public void sort() {
        for(int i = 1; i < data.length; i++){

            int key = data[i];
            int j = i - 1;
            while(j >= 0 && data[j] > key){
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                this.visualizer.getPanel().setHighlight(i,j);
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = key;
        }
        visualizer.pauseTimer();
    }
}
