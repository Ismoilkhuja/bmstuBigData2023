import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Matrix[] matrices = {
                new Matrix(3),
                new Matrix(4),
                new Matrix(5),
                new Matrix(3, 23),
                new Matrix(6)};

//        Matrix A = new Matrix(3);
//        Matrix B = new Matrix(3);
//        A.print();
//        System.out.println();
//        Matrix C = A.multiply(B);
//        A.print();
//        System.out.println();
//        C.print();
//        System.out.println();
//
//        System.out.println(A.normFirst());
//        System.out.println(A.normSecond());


        int minNormFirstPos = Matrix.minNormFirst(matrices);
        int minNormSecondPos = Matrix.minNormSecond(matrices);

        System.out.println("Матрица с наименьшей первой нормы:");
        matrices[minNormFirstPos].print();
        System.out.println("Первая норма: "+ matrices[minNormFirstPos].normFirst());
        System.out.println("Матрица с наименьшей второй нормы:");
        matrices[minNormSecondPos].print();
        System.out.println("Вторая норма: "+ matrices[minNormSecondPos].normSecond());


    }
}