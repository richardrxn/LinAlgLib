public class Matrix {
    private final int aRows;
    private final int aColumns;
    private final double[][] aMatrix;


    // Constructor that takes in only the amount of rows and columns
    // Java has default values for arrays of 0's, which is useful in practice
    public Matrix(int pRows, int pColumns) {
        this.aRows = pRows;
        this.aColumns = pColumns;
        this.aMatrix = new double[pRows][pColumns];
    }

    // Copy Constructor
    public Matrix(Matrix pMatrix) {
        this.aRows = pMatrix.aRows;
        this.aColumns = pMatrix.aColumns;
        this.aMatrix = pMatrix.aMatrix;
    }

    // Constructor if the user provides an already matrix looking array
    public Matrix(double[][] pMatrix) {
        assert pMatrix != null;
        if (pMatrix.length == 0) {
            throw new RuntimeException("Cannot copy empty matrix");
        }

        for (int i = 0; i <= pMatrix.length; i++) {

            if (pMatrix[i].length != pMatrix[0].length) {
                throw new RuntimeException("Provided matrix of different sized rows");
            }
        }

        this.aMatrix = pMatrix.clone();
        this.aRows = pMatrix.length;
        this.aColumns = pMatrix[0].length;
    }

    public double[][] getaMatrix() {
        return aMatrix.clone();
    }

    public void setMatrixValue(int pRowIndex, int pColumnIndex, double pValue) {
        this.aMatrix[pRowIndex][pColumnIndex] = pValue;
    }

    public double getMatrixValue(int pRowIndex, int pColumnIndex) {
        return this.aMatrix[pRowIndex][pColumnIndex];
    }

    public int getaColumns() {
        return aColumns;
    }

    public int getaRows() {
        return aRows;
    }
    // test
}
