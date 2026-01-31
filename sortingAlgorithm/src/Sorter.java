public abstract class Sorter {
    Visualizer visualizer;
    int[] data;
    int speed;

    public Sorter(int[] data, int speed) {
        this.data = data;
        this.speed = speed;
        this.visualizer = new Visualizer(data,"Loading");
        new Thread(this::sort).start();
        this.visualizer.startTimer();

    }

    public int[] swap(int start, int end) {
        int temp = this.data[start];
        this.data[start] = this.data[end];
        this.data[end] = temp;
        return this.data;
    }

    public abstract void sort();

}
