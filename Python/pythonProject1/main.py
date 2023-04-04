# Implement k nearest neighbours algorithm.
#
# Program should take arguments k, train_file, test_file, where:
#
# k -  number of nearest neighbours
# train_file - path to file with  training set
# test_file - path to file with test set
#
# Your program should print each observation from the test set (attributes and correct class) and the class predicted by the algorithm.
# In the last line, the program should print the accuracy, i.e. the percentage of correct answers.
#
#
# -------------------------
# -------------------------
#
# Example of output:
#
# 1.2, 2.2, 3.1, 4.1, iris-virginica  predicted: iris-virginica
# 1.2, 0.2, 3.1, 0.0, iris-setosa     predicted: iris-virginica
# 0.3, 0.1, 1.1, 2.0, iris-setosa     predicted: iris-setosa
# 0.3, 0.1, 1.3, 2.1, iris-setosa     predicted: iris-setosa
#
# Accuracy: 75.0 %
#
# --------------------------------
# --------------------------------
#
# Next, provide a user interface (it can be text) so you can choose:
# change k
# enter custom observation and predict it's class based on training set (you can't simply add it to test file)
# quit
#
#
# Program should be universal, i.e. it should work on any correct input data, of any dimension, if  attributes are numerical excluding the decision attribute.
#
#
#
#
#
#
import numpy


def fileRead(txt):
    caseListVal = []
    caseName = []
    with open(txt, 'r') as file:
        for line in file:
            myCase = line.strip().split(',')
            caseListVal.append([float(val) for val in myCase[:-1]])
            caseName.append(myCase[-1])
    return numpy.array(caseListVal), numpy.array(caseName)


def euclid(x1, x2):
    return numpy.sqrt((numpy.sum(pow(x1 - x2, 2))))


def nearest(k, testVal, trainVal, trainName):
    distData = []

    for x in range(len(trainVal)):
        cDist = euclid(trainVal[x], testVal)
        distData.append((trainVal[x], trainName[x], cDist))

    return sorted(distData, key=lambda distD: distD[2])[:k]


def acc(near):
    accuracies = {}

    for x in range((len(near))):
        caseName = near[x][1]
        if caseName in accuracies:
            accuracies[caseName] += 1
        else:
            accuracies[caseName] = 1
    return sorted(accuracies)[0]


def test(k):
    count = 0
    trainVal, trainName = fileRead('train.txt')
    testVal, testName = fileRead('test.txt')

    for x in range(len(testVal)):
        near = nearest(k, testVal[x], trainVal, trainName)
        guessedName = acc(near)
        realName = testName[x]
        if guessedName == testName[x]:
            count += 1
        print("{}, {}, {}, {}, {} predicted: {}".format(*testVal[x], realName, guessedName))
    print("Accuracy: {approx:.2f}".format(approx=(count / len(testVal)) * 100))


def display():
    trainVal, trainName = fileRead('train.txt')
    testVal, testName = fileRead('test.txt')

    print("Enter k val")
    k = int(input())

    test(k)

    while True:

        choice = input('\n1.Input new k value\n2.Enter custom prediction\n3.Quit\n')
        if choice == '1':
            print("Enter k val")
            k = int(input())
            test(k)

        if choice == '2':
            observ = input('Enter in form: sepal len, sepal width, petal len, petal width\n')
            arr = numpy.array([float(case) for case in observ.strip().split(',')])
            near = nearest(k, testVal, arr, testName)
            pred = acc(near)
            print("Predicted: {}".format(pred))

        if choice == '3':
            print("Closing....")
            break


if __name__ == '__main__':
    display()
