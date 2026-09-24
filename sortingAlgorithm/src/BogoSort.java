import java.util.Random;

public class BogoSort extends Sorter {
    public BogoSort(int[] data, String[] text, int speed) {
        super(data, text, speed);
        visualizer.getFrame().setTitle("Bogo Sort");
    }

    @Override
    public void sort() {
        Random rand = new Random();
        boolean isSorted = false;
        while (!isSorted) {
            for (int i = 0; i < data.length; i++) {
                int temp = data[i];
                int j = rand.nextInt(i + 1);
                data[i] = data[j];
                data[j] = temp;

                String temp_2 = text[i];
                text[i] = text[j];
                text[j] = temp_2;

                visualizer.getPanel().setHighlight(i,j);
                sleep();
            }
            boolean tempIsSorted = true;
            for(int i = 0; i < data.length - 1; i++){
                if(data[i] > data[i+1]){
                    visualizer.getPanel().setHighlight(i,i+1);
                    tempIsSorted = false;
                    sleep();
                }
            }
            if(tempIsSorted){
                isSorted = true;
            }
        }


    }
}
