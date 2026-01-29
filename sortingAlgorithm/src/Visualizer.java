import javax.swing.JFrame;

public class Visualizer {

    private BarPanel panel;
    private int[] data;

   public Visualizer(int[] data) {
       this.data = data;
       JFrame frame = new JFrame("Sorting Visualizer");

       panel = new BarPanel();
       panel.setHighlight(0);
       frame.add(panel);

       frame.setSize(600, 400);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);

       panel.showArray(data);

   }


   public BarPanel getPanel() {
       return panel;
   }

   public void setData(int[] data) {
       this.data = data;
       panel.showArray(data);
   }

   public void getData(int[] data) {
       this.data = data;
   }

}
