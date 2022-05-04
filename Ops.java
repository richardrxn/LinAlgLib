public class Ops {
    // Client would only have access to the Ops class, they have no knowledge of the existence of the Matrix class

    // A few methods for the creation of matrices
    public Matrix createMatrix(int pRows, int pColumns) {
        return new Matrix(pRows, pColumns);
    }

    public Matrix copyMatrix(Matrix pMatrix) {
        return new Matrix(pMatrix);
    }

    public Matrix convertMatrix(double[][] pMatrixArray) {
        return new Matrix(pMatrixArray);
    }

    public Matrix setValue(Matrix pMatrix, int pRow, int pColumn, double pValue) {
        pMatrix.setMatrixValue(pRow, pColumn, pValue);
        return pMatrix;
    }


}
