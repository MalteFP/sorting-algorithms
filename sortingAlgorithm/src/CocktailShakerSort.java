public class CocktailShakerSort extends Sorter {


    public CocktailShakerSort(int[] data, int speed) {
        super(data, speed);
        this.visualizer.getFrame().setTitle("Cocktail Shaker Sort");
    }

    @Override
    public void sort() {
        int startInterval = 0;
        int endInterval = this.data.length - 1;

        while (startInterval < endInterval) {
            int lastSwap = 0;

            for (int j = startInterval; j < endInterval; j++) {
                this.visualizer.getPanel().setHighlight(j, j + 1);
                if (this.data[j] > this.data[j + 1]) {
                    swap(j, j + 1);
                    lastSwap = j;
                }

                try { Thread.sleep(speed); }
                catch (InterruptedException e) { throw new RuntimeException(e); }
            }

            if (lastSwap == 0) break;

            endInterval = lastSwap;

            lastSwap = 0;
            for (int j = endInterval; j > startInterval; j--) {
                this.visualizer.getPanel().setHighlight(j, j + 1);

                if (this.data[j] < this.data[j - 1]) {
                    swap(j, j - 1);
                    lastSwap = j;
                }

                try { Thread.sleep(speed); }
                catch (InterruptedException e) { throw new RuntimeException(e); }
            }

            startInterval = lastSwap;
        }

        this.visualizer.pauseTimer();
    }

}