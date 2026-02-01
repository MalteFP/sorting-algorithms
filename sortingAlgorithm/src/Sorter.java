import javax.swing.Timer;

public abstract class Sorter {
    protected Visualizer visualizer;
    protected Thread thread;
    protected int[] data;
    protected int speed;
    private Stopwatch stopwatch = new Stopwatch();

    public Sorter(int[] data, int speed) {
        this.data = data;
        this.speed = speed;
        this.visualizer = new Visualizer(data,"Loading", stopwatch);
        thread = new Thread(this::runSorter);
    }



    public void sleep() {
        if(this.speed == 0) {
            return;
        }
        try {
            Thread.sleep(this.speed);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void runSorter() {
        stopwatch.start();
        new Thread(this::RunVisualizer).start();
        this.sort();
        stopwatch.stop();
    }

    public void RunVisualizer() {
        Timer VisualizerClock = new Timer(10, e-> {
            visualizer.visualize();
        });
        VisualizerClock.start();
    }


    public abstract void sort();

}
