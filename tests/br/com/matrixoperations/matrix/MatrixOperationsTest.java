package br.com.matrixoperations.matrix;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.matrixoperations.exception.MatrixOperationException;

public class MatrixOperationsTest {

	IMatrixOperations operations;

	@Before
	public void setup() {
		operations = new MatrixOperations();
	}

	@Test
	public void mustCasculateMatrixScalarMultiplication() {
		double[][] matrix = { { 1, 1 }, { 1, 1 } };
		double scalar = 2;

		double[][] expectedResult = { { 2, 2 }, { 2, 2 } };

		double[][] result = operations.scalarMultiplication(matrix, scalar);

		Assert.assertThat(result, CoreMatchers.is(expectedResult));
	}

	@Test
	public void mustCasculateVectorScalarMultiplication() {
		double[] vector = { 1, 1 };
		double scalar = 2;

		double[] expectedResult = { 2, 2 };

		double[] result = operations.scalarMultiplication(vector, scalar);

		Assert.assertThat(result, CoreMatchers.is(expectedResult));
	}

	@Test
	public void mustCalculateTransposeMatrix() {
		double[][] matrix = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		double[][] expectedResult = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };

		double[][] result = operations.matrixTransposition(matrix);

		Assert.assertThat(result, CoreMatchers.is(expectedResult));
	}

	@Test
	public void mustCalculateTheSumOfTwoMatrices() throws MatrixOperationException {
		double[][] matrixA = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		double[][] matrixB = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		double[][] expectedResult = { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 } };

		double[][] result = operations.matrixAddition(matrixA, matrixB);

		Assert.assertThat(result, CoreMatchers.is(expectedResult));
	}

	@Test
	public void mustThrowAnExceptionForTheSumOfDifferentSizeMatrices() {
		double[][] matrixA = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		double[][] matrixB = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		try {
			double[][] result = operations.matrixAddition(matrixA, matrixB);
			Assert.fail("Must have thrown an Expection");
		} catch (Exception e) {
			Assert.assertThat(e.getMessage(), CoreMatchers.is("Matrices must have the same size"));
		}
	}

	@Test
	public void mustCalculateTheSubtractionOfTwoMatrices() throws MatrixOperationException {
		double[][] matrixA = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		double[][] matrixB = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		double[][] expectedResult = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		double[][] result = operations.matrixSubtraction(matrixA, matrixB);

		Assert.assertThat(result, CoreMatchers.is(expectedResult));
	}

	@Test
	public void mustThrowAnExceptionForTheSubtractionOfDifferentSizeMatrices() {
		double[][] matrixA = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		double[][] matrixB = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		try {
			double[][] result = operations.matrixSubtraction(matrixA, matrixB);
			Assert.fail("Must have thrown an Expection");
		} catch (Exception e) {
			Assert.assertThat(e.getMessage(), CoreMatchers.is("Matrices must have the same size"));
		}
	}

	@Test
	public void mustCalculateTheMultiplicationOfTwoMatrices() throws MatrixOperationException {
		double[][] matrixA = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		double[][] matrixB = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		double[][] expectedResult = { { 3, 3, 3 }, { 3, 3, 3 }, { 3, 3, 3 } };

		double[][] result = operations.matrixMultiplication(matrixA, matrixB);

		Assert.assertThat(result, CoreMatchers.is(expectedResult));
	}

	@Test
	public void mustThrowAnExceptionForTheMultiplicationOfDifferentSizeMatrices() {
		double[][] matrixA = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		double[][] matrixB = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		try {
			double[][] result = operations.matrixMultiplication(matrixA, matrixB);
			Assert.fail("Must have thrown an Expection");
		} catch (Exception e) {
			Assert.assertThat(e.getMessage(),
					CoreMatchers.is("Invalid matrix size. The matrix size must be M X N and N X M"));
		}
	}

	@Test
	public void mustCalculateTheMultiplicationOfAMatrixAndAVector() throws MatrixOperationException {
		double[][] matrix = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		double[] vector = { 1, 1, 1 };

		double[] expectedResult = { 3, 3, 3 };

		double[] result = operations.matrixMultiplication(matrix, vector);

		Assert.assertThat(result, CoreMatchers.is(expectedResult));
	}

	@Test
	public void mustThrowAnExceptionForTheMultiplicationOfDifferentSizeMatriceAndVector() {
		double[][] matrix = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
		double[] vector = { 1, 1, 1 };

		try {
			double[] result = operations.matrixMultiplication(matrix, vector);
			Assert.fail("Must have thrown an Expection");
		} catch (Exception e) {
			Assert.assertThat(e.getMessage(),
					CoreMatchers.is("Invalid size. The matrix and vector size must be M X N and N X 1"));
		}
	}

	@Test
	public void mustCalculateTheMultiplicationOfTwoVectors() throws MatrixOperationException {
		double[] vectorA = { 1, 1, 1 };
		double[] vectorB = { 1, 1, 1 };

		double[] expectedResult = { 3 };

		double[] result = operations.vectorMultiplication(vectorA, vectorB);

		Assert.assertThat(result, CoreMatchers.is(expectedResult));
	}

	@Test
	public void mustThrowAnExceptionForTheMultiplicationOfDifferentSizeVectors() {
		double[] vectorA = { 1, 1, 1 };
		double[] vectorB = { 1, 1, 1, 1 };

		try {
			double[] result = operations.vectorMultiplication(vectorA, vectorB);
			Assert.fail("Must have thrown an Expection");
		} catch (Exception e) {
			Assert.assertThat(e.getMessage(), CoreMatchers.is("Invalid vector size. The vector size must be N and N"));
		}
	}

	@Test
	public void mustCalculateTheDeterminantOfAMatrix() throws MatrixOperationException {
		double[][] matrix = { { 1, 2, 3 }, { 2, 1, 2 }, { 3, 2, 1 } };

		double expectedResult = 8.0;

		double result = operations.determinant(matrix);

		Assert.assertThat(result, CoreMatchers.is(expectedResult));
	}

	@Test
	public void mustThrowAnExceptionForTheCalculationOfANonSquareMatrix() {
		double[][] matrix = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		try {
			double result = operations.determinant(matrix);
			Assert.fail("Must have thrown an Expection");
		} catch (Exception e) {
			Assert.assertThat(e.getMessage(), CoreMatchers.is("Invalid size. Matrix must be a square matrix"));
		}
	}
}
