public class MinElement {

    public static int find() {
        int[][] x = {{20, 34, 2}, {9, 12, 18}, {3, 4, 5}};
        int min = x[0][0];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (x[i][j] < min) {
                    min = x[i][j];
                }
            }
        }
        return min;
    }
}
