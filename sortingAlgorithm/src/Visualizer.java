import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.awt.*;


public class Visualizer {
    private Stopwatch stopwatch;
    private BarPanel panel;
    private int[] data;
    private String windowTitle;
    private JFrame frame;
    private Timer timer;
    private int seconds;
    private JLabel timerLabel;

   public Visualizer(int[] data, String windowTitle, Stopwatch stopwatch) {
       this.data = data;
       this.windowTitle = windowTitle;
       this.frame = new JFrame(this.windowTitle);
       this.stopwatch = stopwatch;


       timerLabel = new JLabel("Time: 0 ms");
       frame.add(timerLabel, BorderLayout.NORTH);


       panel = new BarPanel();
       frame.add(panel, BorderLayout.CENTER);

       frame.setSize(600, 400);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);

       panel.showArray(data);

   }


   public BarPanel getPanel() {
       return panel;
   }



   public JFrame getFrame() {
       return frame;
   }

   public void pauseTimer() {
       timer.stop();
   }

   public void startTimer() {
       timer.start();
   }

   public void visualize() {
       panel.repaint();
       timerLabel.setText("Time: " + stopwatch.elapsedMillis()  + " ms");
   }

}
