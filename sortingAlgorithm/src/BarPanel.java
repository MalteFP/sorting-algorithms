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
            System.out.println("MORE");
        } else {
            visualizeWithLessPixels(width,height,max);
            System.out.println("LESS");
        }


    }

    private void visualizeWithMorePixels(int width, int height, int max) {
        double xRatio = (double)width / (double)values.length;
        int barWidth = (int) Math.max(xRatio, 1);

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
        int elementRation = (int) Math.ceil((double) values.length /width);

        for(int i = 0; i < width; i++) {
            try {
                int barHeight = (int) ((values[i  * elementRation] / (double) max) * (height));
                g.fillRect(i , height - barHeight, 1, barHeight);
            }catch(ArrayIndexOutOfBoundsException _){}

        }
    }

    public void setValues(int[] newValues) { this.values = newValues; repaint();}



}
