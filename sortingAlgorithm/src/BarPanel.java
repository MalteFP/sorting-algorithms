import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class BarPanel extends JPanel {
    private int[] values = {};
    private Graphics g;
    private int hightlightA = 0;
    private int hightlightB = 0;
    private int max;





    public void showArray(int[] values){
        this.values = values;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
    }

    public void setHighlight(int hightlightA, int hightlightB){
        this.hightlightA = hightlightA;
        this.hightlightB = hightlightB;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;

        if(values == null || values.length == 0) {
            System.out.println("Something went wrong");
            return;
        }

        int width = getWidth();
        int height = getHeight();

        if(width > values.length) {
            visualizeWithMorePixels(width,height,max);
        } else {
            visualizeWithLessPixels(width,height,max);
        }


    }

    private void visualizeWithMorePixels(int width, int height, int max) {
        double xRatio = (double)width / (double)values.length;
        int barWidth = (int) Math.ceil(Math.max(xRatio, 1));

        for(int i = 0; i < values.length; i++) {
            int barHeight = (int) ((values[i] / (double) max) * (height));

            if(i == hightlightA || i == hightlightB) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }

            g.fillRect((int)(i * xRatio) , height - barHeight, barWidth, barHeight);
        }
    }

    private void visualizeWithLessPixels(int width, int height, int max) {
        double ratio = (double) values.length / width;

        for (int x = 0; x < width; x++) {
            int start = (int) (x * ratio);
            int end   = (int) ((x + 1) * ratio);

            if (end > values.length) end = values.length;

            int localMax = values[start];



            int barHeight = (int) ((localMax / (double) max) * height);

            if(start < hightlightA && hightlightA < end || start < hightlightB && hightlightB < end) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }

            g.fillRect(x, height - barHeight, 1, barHeight);
        }
    }


    public void setValues(int[] newValues) { this.values = newValues; repaint();}



}
