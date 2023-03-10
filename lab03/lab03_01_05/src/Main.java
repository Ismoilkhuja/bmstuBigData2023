public class Main {
    public static void main(String[] args) {

        Matrix A = new Matrix(3, 3);
        Matrix[] matrices = {
                new Matrix(1, 5),
                new Matrix(4, 5),
                new Matrix(6, 3),
                new Matrix(6, 6)
        };

        for (int i = 0; i < matrices.length; i++) {
            matrices[i].swapByCol(4);
        }

        A.print();
        System.out.println();
        Matrix.swapByCol(A, 3);
        if (A.square() == 0)
            A.print();

    }
}