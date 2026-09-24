import javax.swing.*;

public class BubbleSort extends Sorter {
    public BubbleSort(int[] data, String[] text, int speed) {
        super(data, text, speed);
        visualizer.getFrame().setTitle("Bubble Sort");
    }


    @Override
    public void sort() {
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
