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
        //int[] baseData1 = ArrayMaker.randomArray(2500);
        int[] baseData2 = ArrayMaker.randomLinearArray(10);

        sorters.add(new BubbleSort(baseData2.clone(),100));
        sorters.add(new InsertionSort(baseData2.clone(),1));
        sorters.add(new MergeSort(baseData2.clone(),100));
        sorters.add(new MergeSort(baseData2.clone(),1));
        sorters.add(new CocktailShakerSort(baseData2.clone(),1));

    }


}
