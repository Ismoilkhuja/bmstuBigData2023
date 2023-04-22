import java.util.Arrays;
import java.util.Random;

public class Matrix {
    public int size;
    private int[][] array;

    public Matrix(int size){
        if (size < 0)
            throw new IllegalArgumentException("Ошибка: параметр size должен быть >= 0");

        this.size = size;
        array = new int[size][size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = rand.nextInt(10) - 5;
            }
        }
    }

    public Matrix(int size, int fill){
        if (size < 0)
            throw new IllegalArgumentException("Ошибка: параметр size должен быть >= 0");

        this.size = size;
        array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = fill;
            }
        }
    }

    public Matrix(Matrix obj){
        size = obj.size;
        array = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = obj.array[i][j];
            }
        }
    }
    public Matrix add (Matrix obj){
        if (obj.size != this.size){
            throw new IllegalArgumentException("Ошибка: размеры матриц не одинаковы");
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.array[i][j] += obj.array[i][j];
            }
        }
        return this;
    }

    public Matrix sub(Matrix obj){
        if (obj.size != this.size){
            throw new IllegalArgumentException("Ошибка: размеры матриц не одинаковы");
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.array[i][j] -= obj.array[i][j];
            }
        }
        return this;
    }

    public Matrix multiply(Matrix obj){
        if (obj.size != this.size){
            throw new IllegalArgumentException("Ошибка: размеры матриц не одинаковы");
        }

        int[][] tmp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tmp[i][j] = this.array[i][j];
            }
        }

        int sum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += tmp[i][k] * obj.array[k][j];
                }
                this.array[i][j] = sum;
            }
        }
        return this;
    }

    public int normFirst(){
        int max = 0;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            max += this.array[0][i];
        }

        for (int i = 1; i < size; i++) {
            sum = 0;
            for (int j = 0; j < size; j++) {
                sum += Math.abs(this.array[i][j]);

            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public int normSecond(){
        int max = 0;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            max += this.array[i][0];
        }

        for (int i = 1; i < size; i++) {
            sum = 0;
            for (int j = 0; j < size; j++) {
                sum += Math.abs(this.array[j][i]);

            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static int minNormFirst(Matrix[] objs){
        int min = objs[0].normFirst();
        int pos = 0;
        int tmp;
        for (int i = 1; i < objs.length; i++) {
            if ((tmp = objs[i].normFirst()) < min){
                min = tmp;
                pos = i;
            }
        }
        return pos;
    }

    public static int minNormSecond(Matrix[] objs){
        int min = objs[0].normSecond();
        int pos = 0;
        int tmp;
        for (int i = 1; i < objs.length; i++) {
            if ((tmp = objs[i].normSecond()) < min){
                min = tmp;
                pos = i;
            }
        }
        return pos;
    }
    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
