import java.util.Random;

public class Matrix {
    private int m;
    private int n;

    int[][] array;

    public Matrix(int m, int n){
        if (m <= 0 || n<= 0)
            return;
        this.m = m;
        this.n = n;
        array = new int[m][n];
        Random rand = new Random();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = rand.nextInt(20) - 10;
            }
        }
    }

    public Matrix(int m, int n, int fill){
        if (m <= 0 || n<= 0)
            return;
        this.m = m;
        this.n = n;
        array = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = fill;
            }
        }
    }

    public void print(){
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.printf("%3d ", this.array[i][j]);
            }
            System.out.println();
        }
    }

    public static int swapByCol(Matrix obj, int k){
        if (k > obj.n)
            return -1;
        int min = 0;
        int max = 0;

        for (int i = 1; i < obj.m; i++) {
            if (obj.array[min][k - 1] > obj.array[i][k - 1])
                min = i;
            if (obj.array[max][k - 1] < obj.array[i][k - 1])
                max = i;
        }

        int tmp = 0;
        for (int i = 0; i < obj.n; i++) {
            tmp = obj.array[min][i];
            obj.array[min][i] = obj.array[max][i];
            obj.array[max][i] = tmp;
        }

        return 0;
    }

    public int swapByCol(int k){
        if (k > this.n){
            System.out.println("Ошибка: Заданный номер столбца за пределом матрицы.");
            return -1;
        }

        int min = 0;
        int max = 0;

        for (int i = 1; i < this.m; i++) {
            if (this.array[min][k - 1] > this.array[i][k - 1])
                min = i;
            if (this.array[max][k - 1] < this.array[i][k - 1])
                max = i;
        }

        int tmp = 0;
        for (int i = 0; i < this.n; i++) {
            tmp = this.array[min][i];
            this.array[min][i] = this.array[max][i];
            this.array[max][i] = tmp;
        }

        return 0;
    }
    
    public int square(){
        if (this.m != this.n){
            System.out.println("Ошибка: Возведение в квадрат матрицы с разными количествами строк и столбцов невозможно");
            return -1;
        }

        int size = this.m;
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
                    sum += tmp[i][k] * tmp[k][j];
                }
                this.array[i][j] = sum;
            }
        }
        
        return 0;
    }



}
