import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SorterController extends JFrame {
    private ArrayList<Sorter> sorters = new ArrayList<>();

    public SorterController() throws IOException {
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

    private void createSorters() throws IOException {
        int[] baseData = ArrayMaker.randomLinearArray(10);
        //int[] baseData = ArrayMaker.randomLinearArray(500000000);
        //sorters.add(new BubbleSort(baseData.clone(),10));
        //sorters.add(new InsertionSort(baseData.clone(),0));
        //sorters.add(new MergeSort(baseData.clone(),0));
        //sorters.add(new CocktailShakerSort(baseData.clone(),10));
        //sorters.add(new BogoSort(baseData.clone(),0));

        //sorters.add(new ThanosSort(ArrayMaker.randomLinearArray(10),0));

        //sorters.add(new InsertionSort(baseData.clone(),10));
        String file = "fiktive_virksomheder_100.csv";

        String line;

        BufferedReader br = new BufferedReader(new FileReader(file));

        br.readLine();

        ArrayList<Integer> totalVærdi = new ArrayList<>();
        ArrayList<Integer> fortjenesteForÅret = new ArrayList<>();
        ArrayList<Double> procentsatsForForøgelseAfVærdiFraSidsteÅr = new ArrayList<>();
        ArrayList<String> text = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            text.add(parts[0]);
            totalVærdi.add(Integer.parseInt(parts[1]));
            procentsatsForForøgelseAfVærdiFraSidsteÅr.add(Double.parseDouble(parts[2]));
        }

        int[] totalVærdiArr =  new int[totalVærdi.size()];
        for (int i = 0; i < totalVærdi.size(); i++) {
            totalVærdiArr[i] = totalVærdi.get(i);
        }

        String[] textArr =  new String[text.size()];
        for (int i = 0; i < text.size(); i++) {
            textArr[i] = text.get(i);
        }

        int[] procentsatsForForøgelseAfVærdiFraSidsteÅrArr =  new int[procentsatsForForøgelseAfVærdiFraSidsteÅr.size()];
        for (int i = 0; i < text.size(); i++) {
            procentsatsForForøgelseAfVærdiFraSidsteÅrArr[i] = (int) Math.round(procentsatsForForøgelseAfVærdiFraSidsteÅr.get(i) * 100);
        }



        sorters.add(new QuickSort(procentsatsForForøgelseAfVærdiFraSidsteÅrArr, textArr,10));
        //sorters.add(new QuickSort(baseData.clone(),10));

        baseData = null;

    }


}
