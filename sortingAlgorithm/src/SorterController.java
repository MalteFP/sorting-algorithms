import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SorterController extends JFrame {
    private ArrayList<Sorter> sorters = new ArrayList<>();

    public SorterController() {
        setTitle("Sorter Controller");
        setSize(200,100);
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
        int[] baseData = ArrayMaker.randomArray(100);

        sorters.add(new BubbleSort(baseData.clone(),10));
        sorters.add(new InsertionSort(baseData.clone(),10));
        sorters.add(new MergeSort(baseData.clone(),10));
        sorters.add(new CocktailShakerSort(baseData.clone(),10));

    }


}
