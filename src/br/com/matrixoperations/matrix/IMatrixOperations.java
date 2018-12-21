package br.com.matrixoperations.matrix;

import br.com.matrixoperations.exception.MatrixOperationException;

/**
 * IMatrixOperations
 * 
 * Public Interface that defines the service contract.
 * This interface is implemented in MatrixOperations class.
 * 
 * @author Luis Daniel Assulfi
 *
 */
public interface IMatrixOperations {

	/**
	 * Calculation of the scalar multiplication of a matrix.
	 * 
	 * @param matrix double
	 * @param scalar double
	 * @return result of the scalar multiplication
	 */
	public double[][] scalarMultiplication(double[][] matrix, double scalar);
	
	/**
	 * Calculation of the scalar multiplication of a vector	
	 * @param vector double
	 * @param scalar double
	 * @return result of the scalar multiplication
	 */
	public double[] scalarMultiplication(double[] vector, double scalar);
	
	/**
	 * Calculation of the transpose matrix
	 * 
	 * @param matrix double
	 * @return the transposed matrix
	 */
	public double[][] matrixTransposition(double[][] matrix);
	
	/**
	 * Calculates the addition between two matrices. The matrices must have the same size.
	 * 
	 * @param matrixA double
	 * @param matrixB double
	 * @return the result of the addition between two matrices.
	 * @throws MatrixOperationException
	 */
	public double[][] matrixAddition(double[][] matrixA, double[][] matrixB) throws MatrixOperationException;
	
	/**
	 * Calculates the subtraction between two matrices. The matrices must have the same size.
	 * 
	 * @param matrixA
	 * @param matrixB
	 * @return the result of the subtraction between two matrices.
	 * @throws MatrixOperationException
	 */
	public double[][] matrixSubtraction(double[][] matrixA, double[][] matrixB) throws MatrixOperationException;
	
	/**
	 * Calculates the multiplication between two matrices
	 * 
	 * @param matrixA double M x N size
	 * @param matrixB double N x P size
	 * @return matrix M x P
	 * @throws MatrixOperationException
	 */
	public double[][] matrixMultiplication(double[][] matrixA, double[][] matrixB) throws MatrixOperationException;
	
	/**
	 * Calculates the multiplication between a matrix and a vector
	 * 
	 * @param matrixA double M X N size
	 * @param vectorB double N x 1 size
	 * @return vector M x 1
	 * @throws MatrixOperationException
	 */
	public double[] matrixMultiplication(double[][] matrixA, double[] vectorB) throws MatrixOperationException;
	
	/**
	 * Calculates 
	 * 
	 * @param vectorA double N size
	 * @param vectorB double N size
	 * @return vector size 1
	 * @throws MatrixOperationException
	 */
	public double[] vectorMultiplication(double[] vectorA, double[] vectorB) throws MatrixOperationException;
	
	public double determinant(double[][] matrix) throws MatrixOperationException;
}
