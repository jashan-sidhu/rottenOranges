public class Main {
    public static void main(String[] args) {

        rottenOrange orange = new rottenOrange();
        int [][]A;
        A = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("Ans : " + orange.checkTime(A));

    }
}