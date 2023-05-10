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


def euclid(x1, x2):
    return np.sqrt((np.sum(pow(x1 - x2, 2))))


def allNames(names):
    nameCount = {}
    for name in names:
        if name in nameCount:
            nameCount[name] += 1
        else:
            nameCount[name] = 1
    return nameCount


def kmeans(fileName):
    nums, names = read(fileName)

    k = int(input("Input number of k\n"))
    centroids = nums[random.sample(range(len(nums)), k)]
    previous = 0
    x = 0
    while True:
        x += 1
        clusterAss = np.zeros(len(nums), dtype=int)
        distances = []
        purities = []

        for y in range(len(nums)):
            dist = np.array([euclid(nums[y], centroids[currIndex]) for currIndex in range(k)])
            clusterAss[y] = np.argmin(dist)
            distances.append(dist[clusterAss[y]])
        sDist = np.sum(distances)

        for y in range(k):
            clusterNums = nums[clusterAss == y]
            clusterNames = names[clusterAss == y]
            dictor = allNames(clusterNames)
            purities.append('Cluster {}:'.format(y + 1))
            for ket, val in dictor.items():
                purities.append('Purity: Name:{} {}%'.format(ket, val / len(clusterNums) * 100))
        # Update
        centroids = np.array([nums[clusterAss == ind].mean(axis=0) for ind in range(k)])
        print("\nIteration number: {}\nSum of distances: {}\nPurity Percentage: {}".format(x, sDist,
                                                                                           purities))
        if previous != sDist:
            previous = sDist
        else:
            break


if __name__ == '__main__':
    kmeans('data.txt')
