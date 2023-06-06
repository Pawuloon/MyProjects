

import numpy as np
import pandas as pd


def Task1():
    df = pd.read_csv("Data/Task_1.csv", sep=";")

    matrix = np.array(df)
    matrix = matrix.astype(float)
    numCells = matrix.size

    numRows = matrix.shape[0]
    numCols = matrix.shape[1]

    mean = np.mean(matrix)
    median = np.median(matrix)
    variance = np.var(matrix)

    matrix = matrix.flatten()
    arrNoMISS = matrix[~np.isnan(matrix)]

    meanNoMISS = np.mean(arrNoMISS)
    medianNoMISS = np.median(arrNoMISS)
    varianceNoMISS = np.var(arrNoMISS)

    print("Number of cells in the matrix:{} \n"
          "Number of rows in the matrix:{} \n"
          "Number of columns in the matrix:{} \n"
          "Mean of the matrix:{} \n"
          "Median of the matrix:{} \n"
          "Variance of the matrix:{} \n"
          "Mean of the matrix without missing values:{} \n"
          "Median of the matrix without missing values:{} \n"
          "Variance of the matrix without missing values:{} \n"
          .format(numCells, numRows, numCols, mean, median, variance, meanNoMISS, medianNoMISS, varianceNoMISS))


def Task2():
    matrix = np.array(pd.read_csv("Data/Task_2.csv", sep=";", header=None))
    matrix = matrix.astype(float)

    eigenVal, eigenVec = np.linalg.eig(matrix)
    invMatrix = np.linalg.inv(matrix)

    print("Eigenvalues: \n {} \n"
          "Eigenvectors: \n {} \n"
          "Inverse matrix: \n {} \n"
          "Determinant: \n {} \n"
          "Rank: \n {} \n"
          .format(eigenVal, eigenVec, invMatrix, np.linalg.det(matrix), np.linalg.matrix_rank(matrix)))



def Task3(fileName):
    data = np.array(pd.read_csv(fileName, sep=",", header=None))

    data = data.astype(float)

    norm = np.linalg.norm(data, axis=0)

    nomralizeMatrix = data / norm[np.newaxis, :]

    similarityMatrix = np.dot(nomralizeMatrix, nomralizeMatrix.T)

    pairWiseEuclidDist = np.sqrt(np.sum((data[:, np.newaxis] - data) ** 2, axis=2))

    U, S, V = np.linalg.svd(data)
    reducedRank = np.dot(U[:, :2] * S[:2], V[:2, :])

    frobeniusNorm = np.linalg.norm(data, ord='fro')

    print("Normalized matrix: \n {} \n"
          "Similarity matrix: \n {} \n"
          "Pairwise Euclidean distance: \n {} \n"
          "Reduced rank: \n {} \n"
          "Frobenius norm: \n {} \n"
          .format(nomralizeMatrix, similarityMatrix, pairWiseEuclidDist, reducedRank, frobeniusNorm))


def Task4():
    data = np.array(pd.read_csv('Data/Task_4A.csv', sep=' ', header=None))

    data = data.astype(float)

    mean = np.mean(data, axis=0)
    std = np.std(data, axis=0)

    normalizedMatrix = (data - mean) / std

    covarianceMatrix = np.cov(normalizedMatrix)

    matrixB = np.array(pd.read_csv("Data/Task_4B.csv", sep=",", header=None))
    matrixC = np.array(pd.read_csv("Data/Task_4C.csv", sep=",", header=None))

    matrixMult = np.dot(matrixB, matrixC)

    eps = np.finfo(float).eps
    matrixLog = np.log(data + eps)

    print("Normalized matrix: \n {} \n"
          "Covariance matrix: \n {} \n"
          "Matrix multiplication: \n {} \n"
          "Matrix logarithm: \n {} \n"
          .format(normalizedMatrix, covarianceMatrix, matrixMult, matrixLog))


if __name__ == '__main__':
    print("This is Task 1: \n")
    Task1()
    print("This is Task 2: \n")
    Task2()
    print("This is Task 3A: \n")
    Task3('Data/Task_3_matrix_A.csv')
    print("This is Task 3B: \n")
    Task3('Data/Task_3_matrix_B.csv')
    print("This is Task 4: \n")
    Task4()
