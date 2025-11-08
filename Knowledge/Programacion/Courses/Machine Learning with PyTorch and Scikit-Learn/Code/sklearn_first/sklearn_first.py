from sklearn import datasets #To import Iris Dataset
import matplotlib.pyplot as plt
from matplotlib.colors import ListedColormap
import numpy as np
import sklearn.linear_model as linear_models 
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split

#Plot Regions

def plot_decision_regions(X, y, classifier, test_idx=None, resolution=0.2):
    markers = ('o', 's', '^', 'v', '<')
    colors = ('red', 'blue', 'lightgreen', 'gray', 'cyan')
    cmap = ListedColormap(colors[:len(np.unique(y))])

    x1_min, x1_max = X[:, 0].min() - 1, X[:, 0].max() + 1
    x2_min, x2_max = X[:, 1].min() - 1, X[:, 1].max() + 1
    xx1, xx2 = np.meshgrid(np.arange(x1_min, x1_max, resolution),
                           np.arange(x2_min, x2_max, resolution))
    lab = classifier.predict(np.array([xx1.ravel(), xx2.ravel()]).T)
    lab = lab.reshape(xx1.shape)
    plt.contourf(xx1, xx2, lab, alpha=0.3, cmap=cmap)
    plt.xlim(xx1.min(), xx1.max())
    plt.ylim(xx2.min(), xx2.max())

    for idx, cl in enumerate(np.unique(y)):
        plt.scatter(x=X[y == cl, 0],
                    y=X[y == cl, 1],
                    alpha=0.8,
                    c=colors[idx],
                    marker=markers[idx],
                    label=f'Class {cl}',
                    edgecolor='black')

    if test_idx is not None:
        X_test, y_test = X[test_idx, :], y[test_idx]
        plt.scatter(X_test[:, 0], X_test[:, 1],
                    c='none', edgecolor='black', alpha=1.0,
                    linewidth=1, marker='o',
                    s=100, label='Test set')

#Import Data

iris = datasets.load_iris()
X = iris.data[:,0:2]
y = iris.target

#Scale Standard Data

sc = StandardScaler()
X = sc.fit_transform(X)

#Import Perceptron

clf = linear_models.Perceptron(eta0=0.1, random_state=1)

# Split training data and test data
indices = np.arange(len(X))
X_train, X_test, idx_train, idx_test = train_test_split(
    X, indices, test_size=0.3, random_state=1
)
y_train = y[idx_train]
y_test  = y[idx_test]

#Fit model with training data

clf.fit(X_train, y_train)

#Plot regions

plot_decision_regions(X, y, clf, idx_test, 0.2)
plt.xlabel(iris.feature_names[0] + " (standarized)")
plt.ylabel(iris.feature_names[1] + " (standarized)")
plt.legend()
plt.show()