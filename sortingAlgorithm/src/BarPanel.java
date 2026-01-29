import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class BarPanel extends JPanel {
    private int[] values = {};
    private Integer hightlight = null;


    public void showArray(int[] values){
        this.values = values;
        repaint();
    }

    public void setHighlight(int hightlight){
        this.hightlight = hightlight;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(values == null || values.length == 0 || hightlight == null) {
            System.out.println("Something went wrong");
            return;
        }

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / values.length;

        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }

        for(int i = 0; i < values.length; i++) {
            int barHeight = (int) ((values[i] / (double) max) * (height - 20));

            if(i == hightlight || i == hightlight + 1) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }

            g.fillRect(i * barWidth, height - barHeight, barWidth - 2, barHeight);
        }



    }

    public void setValues(int[] newValues) { this.values = newValues; repaint();}



}
