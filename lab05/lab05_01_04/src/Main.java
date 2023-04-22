import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Matrix[] matrices = new Matrix[5];

        try {
            matrices[0] = new Matrix(3);
            matrices[1] = new Matrix(4);
            matrices[2] = new Matrix(5);
            matrices[3] = new Matrix(3, 23);
            matrices[4] = new Matrix(6);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        for (int i = 0; i < matrices.length; i++) {
            matrices[i].print();
            System.out.println();
        }

        /* Инициализация объекта с отрицательным размером
        try {
            Matrix A = new Matrix(-235);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1); // завершение программы с кодом ошибки 1
        }
        */

        /* Инициализация объекта с большим значением
        try {
            Matrix C = new Matrix(100000000);
        } catch (OutOfMemoryError e){
            System.out.println("Ошибка: недостаточно памяти для создания объекта.");
            System.exit(1); // завершение программы с кодом ошибки 1
        }
        */
        Matrix A = new Matrix(2);
        try {
            Matrix tmp1 = new Matrix(2);
            Matrix tmp2 = new Matrix(2);
            tmp1.add(tmp2);
            A = tmp1;
        } catch (Exception e){
            e.printStackTrace();
        }
        A.print();
        System.out.println();

        Matrix B = new Matrix(3);
        Matrix C = new Matrix(4);
        B.print();
        System.out.println();
        C.print();
        System.out.println();
        try{
            B.multiply(C);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        B.print();


        System.out.println(A.normFirst());
        System.out.println(A.normSecond());


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