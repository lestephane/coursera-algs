import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PercolationTests {
    @Nested
    class BoundaryTests {
        Percolation percolation = new Percolation(1);

        /*
            out of range: row < 1 : throws IllegalArgumentException
            out of range: row > n : throws IllegalArgumentException
         */
        @Test
        public void open_outOfRangeRow_lessThanOne() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.open(0, 1), "row < 1");

            assertThat(e.getMessage(), is("invalid row (must be at least 1)"));
        }

        @Test
        public void open_outOfRangeRow_overN() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.open(2, 1), "row > n");

            assertThat(e.getMessage(), is("invalid row (must be at most 1)"));
        }

        @Test
        public void isOpen_outOfRangeRow_lessThanOne() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(0, 1), "row < 1");

            assertThat(e.getMessage(), is("invalid row (must be at least 1)"));
        }

        @Test
        public void isOpen_outOfRangeRow_overN() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(2, 1), "row > n");

            assertThat(e.getMessage(), is("invalid row (must be at most 1)"));
        }

        @Test
        public void isFull_outOfRangeRow_lessThanOne() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.isFull(0, 1), "row < 1");

            assertThat(e.getMessage(), is("invalid row (must be at least 1)"));
        }

        @Test
        public void isFull_outOfRangeRow_overN() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.isFull(2, 1), "row > n");

            assertThat(e.getMessage(), is("invalid row (must be at most 1)"));
        }

        @Test
        public void open_outOfRangeColumn_lessThanOne() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.open(1, 0), "col < 1");

            assertThat(e.getMessage(), is("invalid column (must be at least 1)"));
        }

        @Test
        public void open_outOfRangeColumn_overN() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.open(1, 2), "col > n");

            assertThat(e.getMessage(), is("invalid column (must be at most 1)"));
        }

        @Test
        public void isOpen_outOfRangeColumn_lessThanOne() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(1, 0), "col < 1");

            assertThat(e.getMessage(), is("invalid column (must be at least 1)"));
        }

        @Test
        public void isOpen_outOfRangeColumn_overN() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.isOpen(1, 2), "col > n");

            assertThat(e.getMessage(), is("invalid column (must be at most 1)"));
        }

        @Test
        public void isFull_outOfRangeColumn_lessThanOne() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.isFull(1, 0), "col < 1");

            assertThat(e.getMessage(), is("invalid column (must be at least 1)"));
        }

        @Test
        public void isFull_outOfRangeColumn_overN() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> percolation.isFull(1, 2), "col > n");

            assertThat(e.getMessage(), is("invalid column (must be at most 1)"));
        }
    }

    @Nested
    class ConstructorTests {
        @Test
        public void constructor_outOfRangeN_lessThan1() {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Percolation(0));

            assertThat(e.getMessage(), is("invalid n (must be at least 1)"));
        }
    }

    @Nested
    class ExtraSmallPercolationTests {
        @Test
        public void constructor_whenNIsOne_initalilzesOneBlockedCell() {
            Percolation percolation = new Percolation(1);

            assertThat(percolation.isOpen(1, 1), is(false));
            assertThat(percolation.isFull(1, 1), is(true));
            assertThat(percolation.numberOfOpenSites(), is(0));
            assertThat(percolation.percolates(), is(false));
        }
    }
}