public abstract class Sorter {
    Visualizer visualizer;
    Thread thread;
    int[] data;
    int speed;

    public Sorter(int[] data, int speed) {
        this.data = data;
        this.speed = speed;
        this.visualizer = new Visualizer(data,"Loading");
        thread = new Thread(this::sort);
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


    public abstract void sort();

}
