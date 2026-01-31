import javax.swing.*;

public class BubbleSort extends Sorter {
    public BubbleSort(int[] data, int speed) {
        super(data, speed);
        visualizer.getFrame().setTitle("Bubble Sort");
    }


    @Override
    public void sort() {
        visualizer.startTimer();
        int latestSwap = data.length - 1;
        int endInterval;
        for(int i = 0; i < data.length; i++) {

            endInterval = latestSwap;
            latestSwap = -1;
            for(int j = 0; j < endInterval; j++) {
                visualizer.getPanel().setHighlight(j,j + 1);
                sleep();
                if(data[j] > data[j + 1]) {
                    swap(j,j + 1);
                    latestSwap = j + 1;
                }
            }
            if(latestSwap == -1) {break;}
        }
        visualizer.pauseTimer();

    }


}
