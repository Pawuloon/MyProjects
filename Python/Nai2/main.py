import random
import numpy as np


def read(file):
    myNums = []
    myNames = []
    with open(file, 'r') as txt:
        for line in txt:
            row = line.strip().split(',')
            myNums.append([float(value) for value in row[:-1]])
            myNames.append(row[-1])
    return np.array(myNums), np.array(myNames)


def binaryPredictor(row, weights, bias):
    activationPoint = bias
    activationPoint += sum(weights[x] * row[x] for x in range(len(row)))
    return 1 if activationPoint >= 0 else 0


def weightsInitializer(trainData):
    return [random.uniform(-1, 1) for _ in range(len(trainData[0]))]


def biasInitializer():
    return random.uniform(-1, 1)


def adjustWeights(testData, weights, bias, learningRate, className):
    correctCount = 0
    for i in range(len(testData[0])):
        row = testData[0][i]
        prediction = binaryPredictor(row, weights, bias)
        error = (testData[1][i] == className) - prediction
        bias += learningRate * error

        for x in range(len(row)):
            weights[x] += learningRate * error * row[x]

        if prediction == (testData[1][i] == className):
            correctCount += 1

    return correctCount / float(len(testData[0]))


def perceptron(fileTrain, fileTest, learningRate, epochs, className):
    trainDataNumbers, trainDataLabels = read(fileTrain)
    testDataNumbers, testDataLabels = read(fileTest)

    binaryTrainDataLabels = np.array([int(label == className) for label in trainDataLabels])
    binaryTestDataLabels = np.array([int(label == className) for label in testDataLabels])

    weights = weightsInitializer(trainDataNumbers)
    bias = biasInitializer()

    label = set(trainDataLabels)
    name = 0 if className == list(label)[0] else 1

    for epoch in range(epochs):
        acc = adjustWeights((trainDataNumbers, binaryTrainDataLabels), weights, bias, learningRate, name)
        print("\nEpoch number: {}\nAccuracy on training data: {:.2f}%".format(epoch + 1, acc * 100))
        acc_test = adjustWeights((testDataNumbers, binaryTestDataLabels), weights, bias, learningRate, name)
        print("Accuracy on test data: {:.2f}%".format(acc_test * 100))
        # ASK
        random.shuffle(trainDataNumbers)


def display(testTxt, trainingTxt, learningRate, Epoch):
    classData, classNames = read(testTxt)
    names = set(classNames)
    if len(names) > 2:
        raise ValueError("Too many classes have been detected")
    choice = input("Choose class name from given\n1." + list(names)[0] + "\n2." + list(names)[1] + '\n')
    cN = ''
    if choice == '1':
        cN = list(names)[0]
    if choice == '2':
        cN = list(names)[1]
    perceptron(trainingTxt, testTxt, learningRate, Epoch, cN)


if __name__ == "__main__":

    learn = float(input("Input learning rate\n"))
    epochIN = int(input("Input epoch\n"))
    test = input("Choose one test:\n")

    if test == '1':
        display("irisTest.txt", "irisTraining.txt", learn, epochIN)
    else:
        display("exampleTest.txt", "exampleTrain.txt", learn, epochIN)
