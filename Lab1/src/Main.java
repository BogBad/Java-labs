public class Main {
    public static void main(String[] args) {
        short[][] matrixA = {
                {1, 4, 1},
                {4, 8, 7},
                {0, 0, 5}
        };

        short[][] matrixB = {
                {7, 3, 2},
                {1, 5, 9},
                {3, 5, 4}
        };

        MatrixOperations matrixOperations = new MatrixOperations();

        try {
            short[][] matrixC = matrixOperations.addMatrices(matrixA, matrixB);

            System.out.println("Матриця C (A + B):");
            matrixOperations.printMatrix(matrixC);

            short sum = matrixOperations.sumOfMaxInColumns(matrixC);
            System.out.println("\nСума найбільших елементів кожного стовпця: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
