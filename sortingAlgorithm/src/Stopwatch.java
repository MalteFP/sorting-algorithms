public class Stopwatch {
    private long startTime = 0;
    private long endTime = 0;
    private boolean running = false;

    public void start() {
        startTime = System.nanoTime();
        running = true;
    }

    public void stop() {
        if (running) {
            endTime = System.nanoTime();
            running = false;
        }
    }

    public void reset() {
        startTime = 0;
        endTime = 0;
        running = false;
    }

    public long elapsedNanos() {
        return running ? System.nanoTime() - startTime : endTime - startTime;
    }

    public double elapsedMillis() {
        return elapsedNanos() / 1_000_000.0;
    }

    public double elapsedSeconds() {
        return elapsedNanos() / 1_000_000_000.0;
    }
}
