package br.com.matrixoperations.matrix;

import br.com.matrixoperations.exception.MatrixOperationException;

/**
 * This class is the implementation of the interface IMatrixOperations
 * 
 * @author LuisDaniel
 *
 */
public class MatrixOperations implements IMatrixOperations {

	/**
	 * Constructor
	 */
	public MatrixOperations() {
	}

	@Override
	public double[][] scalarMultiplication(double[][] matrix, double scalar) {
		int lines = matrix.length;
		int columns = matrix[0].length;

		double result[][] = new double[lines][columns];

		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				result[i][j] = scalar * matrix[i][j];
			}
		}

		return result;
	}

	@Override
	public double[] scalarMultiplication(double[] vector, double scalar) {
		int lines = vector.length;

		double[] result = new double[lines];

		for (int i = 0; i < lines; i++) {
			result[i] = scalar * vector[i];
		}

		return result;
	}

	@Override
	public double[][] matrixTransposition(double[][] matrix) {
		int lines = matrix.length;
		int columns = matrix[0].length;

		double[][] result = new double[columns][lines];

		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				result[j][i] = matrix[i][j];
			}
		}

		return result;
	}

	@Override
	public double[][] matrixAddition(double[][] matrixA, double[][] matrixB) throws MatrixOperationException {
		int linesA = matrixA.length;
		int columnsA = matrixA[0].length;

		int linesB = matrixB.length;
		int columnsB = matrixB[0].length;

		if (linesA != linesB || columnsA != columnsB) {
			throw new MatrixOperationException("Matrices must have the same size");
		}

		double[][] result = new double[linesA][columnsA];

		for (int i = 0; i < linesA; i++) {
			for (int j = 0; j < columnsA; j++) {
				result[i][j] = matrixA[i][j] + matrixB[i][j];
			}
		}

		return result;
	}

	@Override
	public double[][] matrixSubtraction(double[][] matrixA, double[][] matrixB) throws MatrixOperationException {
		int linesA = matrixA.length;
		int columnsA = matrixA[0].length;

		int linesB = matrixB.length;
		int columnsB = matrixB[0].length;

		if (linesA != linesB || columnsA != columnsB) {
			throw new MatrixOperationException("Matrices must have the same size");
		}

		double[][] result = new double[linesA][columnsA];

		for (int i = 0; i < linesA; i++) {
			for (int j = 0; j < columnsA; j++) {
				result[i][j] = matrixA[i][j] - matrixB[i][j];
			}
		}

		return result;
	}

	@Override
	public double[][] matrixMultiplication(double[][] matrixA, double[][] matrixB) throws MatrixOperationException {
		int linesA = matrixA.length;
		int columnsA = matrixA[0].length;
		int linesB = matrixB.length;
		int columnsB = matrixB[0].length;

		if (columnsA != linesB) {
			throw new MatrixOperationException("Invalid matrix size. The matrix size must be M X N and N X M");
		}

		double[][] result = new double[linesA][columnsB];

		for (int i = 0; i < linesA; i++) {
			for (int j = 0; j < columnsB; j++) {
				double sum = 0.0;
				for (int k = 0; k < columnsA; k++) {
					sum += matrixA[i][k] * matrixB[k][j];
				}
				result[i][j] = sum;
			}
		}

		return result;
	}

	@Override
	public double[] matrixMultiplication(double[][] matrixA, double[] vectorB) throws MatrixOperationException {
		int linesA = matrixA.length;
		int columnsA = matrixA[0].length;

		int linesB = vectorB.length;

		if (columnsA != linesB) {
			throw new MatrixOperationException("Invalid size. The matrix and vector size must be M X N and N X 1");
		}

		double[] result = new double[linesA];

		for (int i = 0; i < linesA; i++) {
			double sum = 0;
			for (int j = 0; j < linesB; j++) {
				sum += matrixA[i][j] * vectorB[j];
			}
			result[i] = sum;
		}

		return result;
	}

	@Override
	public double[] vectorMultiplication(double[] vectorA, double[] vectorB) throws MatrixOperationException {
		int linesA = vectorA.length;
		int linesB = vectorB.length;

		if (linesA != linesB) {
			throw new MatrixOperationException("Invalid vector size. The vector size must be N and N");
		}

		double result[] = new double[1];

		double sum = 0.0;
		for (int i = 0; i < linesA; i++) {
			sum += vectorA[i] * vectorB[i];
		}
		result[0] = sum;

		return result;
	}

	@Override
	public double determinant(double[][] matrix) throws MatrixOperationException {
		if (matrix.length != matrix[0].length) {
			throw new MatrixOperationException("Invalid size. Matrix must be a square matrix");
		}

		return 0;
	}
}
