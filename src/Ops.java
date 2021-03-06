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

    public Matrix setValue(Matrix pMatrix, int pRowIndex, int pColumnIndex, double pValue) {
        pMatrix.setMatrixValue(pRowIndex, pColumnIndex, pValue);
        return pMatrix;
    }

    public Matrix getRowMatrix(Matrix pMatrix, int pRowIndex) {
        Matrix result = new Matrix(1, pMatrix.getaColumns());
        for (int y = 0; y <= pMatrix.getaColumns(); y++) {
            result.setMatrixValue(0, y, pMatrix.getMatrixValue(pRowIndex, y));
        }
        return result;
    }

    public Matrix getColumnMatrix(Matrix pMatrix, int pColumnIndex) {
        Matrix result = new Matrix(pMatrix.getaRows(), 1);
        for (int i = 0; i <= pMatrix.getaRows(); i++) {
            result.setMatrixValue(i, 0, pMatrix.getMatrixValue(i, pColumnIndex));
        }
        return result;
    }

    // Row Addition using
    // Row1 + aRow2
    public Matrix rowReduce(Matrix pMatrix, int pRow1, double a, int pRow2) {
        for (int y = 0; y <= pMatrix.getaColumns(); y++) {
            pMatrix.setMatrixValue(pRow1, y, pMatrix.getMatrixValue(pRow1, y) + a * pMatrix.getMatrixValue(pRow2, y));
        }
        return pMatrix;
    }

    public Matrix scalarMultiplication(double pScalar, Matrix pMatrix) {
        for (int i = 0; i <= pMatrix.getaRows(); i++) {
            for (int y = 0; y <= pMatrix.getaColumns(); y++) {
                setValue(pMatrix, i, y, pMatrix.getMatrixValue(i, y) * pScalar);
            }
        }
        return pMatrix;
    }

    // Methods to multiply matrices together
    public double vectorDotProduct(Matrix pMatrix1, Matrix pMatrix2) {
        if (pMatrix1.getaColumns() == pMatrix2.getaRows() && pMatrix1.getaRows() == 1 && pMatrix2.getaColumns() == 1) {
            int result = 0;
            for (int y = 0; y <= pMatrix1.getaColumns(); y++) {
                result += pMatrix1.getMatrixValue(0, y) * pMatrix2.getMatrixValue(y, 0);
                }
            return result;
        } else {
            throw new RuntimeException("Cannot get dot product of differently sized vertices");
        }
    }

    public Matrix matrixMultiplication(Matrix pMatrix1, Matrix pMatrix2) {
        if (pMatrix1.getaColumns() == pMatrix2.getaRows()) {
            Matrix result = new Matrix(pMatrix1.getaRows(), pMatrix2.getaColumns());

            for (int i = 0; i <= pMatrix1.getaRows(); i++) {
                Matrix matrix1row = getRowMatrix(pMatrix1, i);

                for (int y = 0; y <= pMatrix1.getaColumns(); y++) {
                    Matrix matrix2column = getColumnMatrix(pMatrix2, y);
                    result.setMatrixValue(i, y, vectorDotProduct(matrix1row, matrix2column));
                }
            }

            return result;
        }
        else {
            throw new RuntimeException("Matrices of incompatible sizes");
        }
    }

    // I find the determinant by finding the Upper form of the matrix, works for any kind, but gets increasingly
    // slow for large n (basically n >= 4)
    public double matrixDeterminant(Matrix pMatrix) {
        if (pMatrix.getaRows() == pMatrix.getaColumns()) {
            double result = 1;
            for (int i = 0; i <= pMatrix.getaRows(); i++) {
                for (int y = i + 1; y <= pMatrix.getaRows(); y++) {
                    double factor = pMatrix.getMatrixValue(i - 1, i - 1) / pMatrix.getMatrixValue(y, i - 1);
                    rowReduce(pMatrix, i, -factor, y);
                }
                result *= pMatrix.getMatrixValue(i, i);
            }

            return result;

        } else {
            throw new RuntimeException("Can only take determinants of square matrices");
        }

    }


}
