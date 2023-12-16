

public class SortGrid {
    public static void sortA(Grid g) {
        mergeSortAux(g, 0, g.size() * g.size() - 1);
    }

    public static void sortB(Grid g) {
        mergeSortAux(g, 0, g.size() * g.size() - 1);
    }

    public static void mergeSortAux(Grid grid, int i, int j) {
        if (j - i < 1) {
            return;
        }
        int m = (i + j) / 2;
        mergeSortAux(grid, i, m);
        mergeSortAux(grid, m + 1, j);
        merge(grid, i, m, m + 1, j);
    }

    public static void merge(Grid grid, int a, int b, int x, int y) {
        int k = a;
        int c = a;
        int gridSize = grid.size();
        while (a <= b || x <= y) {
            if (a > b) {
                grid.setTempVal(c / gridSize, c % gridSize, grid.getIntVal(x / gridSize, x % gridSize));
                c++;
                x++;
            } else if (x > y) {
                grid.setTempVal(c / gridSize, c % gridSize, grid.getIntVal(a / gridSize, a % gridSize));
                c++;
                a++;
            } else if (grid.getIntVal(a / gridSize, a % gridSize) <= grid.getIntVal(x / gridSize, x % gridSize)) { // (grid.getVal(a) <= grid.getVal(x)) {
                grid.setTempVal(c / gridSize, c % gridSize, grid.getIntVal(a / gridSize, a % gridSize));
                c++;
                a++;
            } else {
                grid.setTempVal(c / gridSize, c % gridSize, grid.getIntVal(x / gridSize, x % gridSize));
                c++;
                x++;
            }
        }
        for (int i = k; i <= y; i++) {
            grid.setIntVal(i / gridSize, i % gridSize, grid.getTempVal(i / gridSize, i % gridSize));
        }
    }
}

SortGrid.java
2KB