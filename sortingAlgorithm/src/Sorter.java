import javax.swing.Timer;

public abstract class Sorter {
    protected Visualizer visualizer;
    protected Thread thread;
    protected int[] data;
    protected String[] text;
    protected int speed;
    private Stopwatch stopwatch = new Stopwatch();
    private Timer VisualizerClock;

    public Sorter(int[] data, String[] text, int speed) {
        this.data = data;
        this.speed = speed;
        this.text = text;
        this.visualizer = new Visualizer(data, text, "Loading", stopwatch);
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
        stopVisualizer();
        visualizer.visualize();
        this.data = null;
    }

    public void RunVisualizer() {
        VisualizerClock = new Timer(10, e-> {
            visualizer.visualize();
        });
        VisualizerClock.start();
    }

    public void stopVisualizer() {
        VisualizerClock.stop();
    }


    public abstract void sort();

}
