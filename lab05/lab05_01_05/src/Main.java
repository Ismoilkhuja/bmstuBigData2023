public class Main {
    public static void main(String[] args) {

        // В случае создание объекта при генерации исключения, программа должна останавливаться
        // поэтому исключения не обрабатываются
        Matrix A = new Matrix(3, 3);
//        Matrix C = new Matrix(3, -5);
        Matrix[] matrices = {
                new Matrix(1, 5),
                new Matrix(4, 5),
                new Matrix(6, 3),
                new Matrix(6, 6)
        };

        for (int i = 0; i < matrices.length; i++) {
            try{
                matrices[i].swapByCol(4);
            } catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }
        A.print();
        System.out.println();
        try{
            Matrix.swapByCol(A, 3);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }


        try{
            A.square();
        } catch (Exception e){
            e.printStackTrace();
        }
        A.print();

    }
}