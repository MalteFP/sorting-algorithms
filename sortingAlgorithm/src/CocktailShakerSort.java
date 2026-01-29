public class CocktailShakerSort {
    private Visualizer visualizer;
    private int[] data;

    public CocktailShakerSort(int[] startData) throws InterruptedException {
        this.data = startData;
        visualizer = new Visualizer(startData);

        new Thread(() -> {
            try {
                runSort();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

    public void runSort() throws InterruptedException {
        boolean isSorted = false;
        boolean hasSwapped;

        while (!isSorted) {
            hasSwapped = false;
            for (int i = 0; i < this.data.length - 1; i++) {
                Thread.sleep(1);
                visualizer.getPanel().setHighlight(i);
                if (this.data[i] > this.data[i + 1]) {
                    swap(data, i, i + 1);
                    hasSwapped = true;
                }
            }
            for (int i = this.data.length - 2; i > 0; i--) {
                Thread.sleep(1);
                visualizer.getPanel().setHighlight(i);
                if (this.data[i] > this.data[i + 1]) {
                    swap(data, i, i + 1);
                    hasSwapped = true;
                }
            }

            if (!hasSwapped) {
                isSorted = true;
            }
        }
    }


    public int[] swap(int[] data, int start, int end) {
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        return data;
    }
}
