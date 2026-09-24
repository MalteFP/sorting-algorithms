import java.util.ArrayList;
import java.util.Random;

public class ThanosSort extends Sorter {

    public ThanosSort(int[] data, String[] text, int speed) {
        super(data, text, speed);
        visualizer.getFrame().setTitle("Thanos Sort");
    }

    @Override
    public void sort() {
        Random rand = new Random();
        ArrayList<Integer> index = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            index.add(i);
        }
        while(true) {
            boolean tempIsSorted = true;
            for(int i = 0; i < index.size() - 1; i++){
               if(data[index.get(i)] > data[index.get(i+1)]){
                    visualizer.getPanel().setHighlight(index.get(i),index.get(i+1));
                    tempIsSorted = false;
                    sleep();
                }
            }
            if(tempIsSorted){
                break;
            }
            for(int i = 0; i < index.size()/2; i++){
                int col = rand.nextInt(index.size());
                visualizer.getPanel().setHighlight(index.get(col),index.get(col));
                sleep();
                data[index.get(col)] = 0;
                index.remove(col);
            }


        }
    }
}
