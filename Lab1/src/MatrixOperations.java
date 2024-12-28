public class MatrixOperations {

    public short[][] addMatrices(short[][] A, short[][] B) {
        // Перевірка на відповідність розмірів матриць
        if (A.length != B.length || A[0].length != B[0].length) {
            throw new IllegalArgumentException("Матриці повинні мати однакові розміри.");
        }

        int rows = A.length;
        int cols = A[0].length;
        short[][] result = new short[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (short) (A[i][j] + B[i][j]);
            }
        }
        return result;
    }

    public short sumOfMaxInColumns(short[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        short sum = 0;

        for (int j = 0; j < cols; j++) {
            short maxInColumn = matrix[0][j];

            // Знаходимо максимальний елемент в стовпці
            for (int i = 1; i < rows; i++) {
                if (matrix[i][j] > maxInColumn) {
                    maxInColumn = matrix[i][j];
                }
            }
            sum += maxInColumn;
        }
        return sum;
    }

    public void printMatrix(short[][] matrix) {
        for (short[] row : matrix) {
            for (short elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
