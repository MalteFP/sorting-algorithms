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
        thread = new Thread(this::runTread);
    }

    public int[] swap(int start, int end) {
        int temp = this.data[start];
        this.data[start] = this.data[end];
        this.data[end] = temp;
        return this.data;
    }

    public void sleep() {
        try {
            Thread.sleep(this.speed);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void runTread()
    {
        stopwatch.start();
        this.sort();
        stopwatch.stop();
    }


    public abstract void sort();

}
