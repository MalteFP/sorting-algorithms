import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SorterController extends JFrame {
    private ArrayList<Sorter> sorters = new ArrayList<>();

    public SorterController() {
        setTitle("Sorter Controller");
        setSize(300,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton startButton = new JButton("Start ALL sorters");

        startButton.addActionListener(e -> {
            for (Sorter sorter : sorters) {
                sorter.thread.start();

            }
        });

        add(startButton);
        setVisible(true);

        createSorters();

    }

    private void createSorters() {
        int[] baseData = ArrayMaker.randomArray(500000000);
        //int[] baseData = ArrayMaker.randomLinearArray(500000000);
        //sorters.add(new BubbleSort(baseData.clone(),10));
        //sorters.add(new InsertionSort(baseData.clone(),0));
        //sorters.add(new MergeSort(baseData.clone(),0));
        //sorters.add(new CocktailShakerSort(baseData.clone(),10));
        //sorters.add(new BogoSort(baseData.clone(),0));

        //sorters.add(new MergeSort(baseData,0));
        //sorters.add(new QuickSort(baseData,0));
        //sorters.add(new CountingSort(baseData,0));

        baseData = null;

    }


}
