public class CocktailShakerSort extends Sorter {


    public CocktailShakerSort(int[] data, int speed) {
        super(data, speed);
        visualizer.getFrame().setTitle("Cocktail Shaker Sort");
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

                sleep();
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

                sleep();
            }

            startInterval = lastSwap;
        }
    }

    public int[] swap(int start, int end) {
        int temp = this.data[start];
        this.data[start] = this.data[end];
        this.data[end] = temp;
        return this.data;
    }

}