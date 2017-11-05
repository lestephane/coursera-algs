enum Status {
    FULL, OPEN;
}

public class Percolation {
    private final int n;
    private final int[] grid;

    /**
     * create n-by-n grid, with all sites blocked
     * @param n
     */
    public Percolation(int n) {
        if (n < 1) throw new IllegalArgumentException("invalid n (must be at least 1)");
        this.n = n;
        this.grid = new int[n*n];
    }

    /**
     * open site (row, col) if it is not open already
     * @param row
     * @param col
     */
    public    void open(int row, int col) {
        checkBounds(row, col);
    }

    private void checkBounds(int row, int col) {
        if (row < 1) throw new IllegalArgumentException("invalid row (must be at least 1)");
        if (row > n) throw new IllegalArgumentException(String.format("invalid row (must be at most %s)", n));
        if (col < 1) throw new IllegalArgumentException("invalid column (must be at least 1)");
        if (col > n) throw new IllegalArgumentException(String.format("invalid column (must be at most %s)", n));
    }

    /**
     * is site (row, col) open?
     * @param row
     * @param col
     * @return true if it is open, false if it isn't
     */
    public boolean isOpen(int row, int col) {
       return siteIs(row, col, Status.OPEN);
    }

    private boolean siteIs(int row, int col, Status status) {
        checkBounds(row, col);
        int ordinal = status.ordinal();
        int pos = sitePosition(row, col);
        return grid[pos] == ordinal;
    }

    private int sitePosition(int row, int col) {
        return (row - 1) * n + (col - 1);
    }

    /**
     * is site (row, col) full?
     * @param row
     * @param col
     * @return true if it is, false if it isn't full
     */
    public boolean isFull(int row, int col) {
        return siteIs(row, col, Status.FULL);
    }

    /**
     * @return number of open sites
     */
    public     int numberOfOpenSites() {
        return isOpen(1, 1)? 1 : 0;
    }

    /**
     * does the system percolate?
     * @return true if it does, false if it doesn't
     */
    public boolean percolates() {
        return numberOfOpenSites() == 1;
    }

    /**
     * // test client (optional)

     * @param args
     */
    public static void main(String[] args) {

    }
}