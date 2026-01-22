from sklearn.linear_model import LogisticRegression
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.colors import ListedColormap
from sklearn import datasets #To import Iris Dataset
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split

#Import Data

iris = datasets.load_iris()
X = iris.data[:,2:4]
y = iris.target

#Scale Standard Data

sc = StandardScaler()
X = sc.fit_transform(X)

# Split training data and test data
indices = np.arange(len(X))
X_train, X_test, idx_train, idx_test = train_test_split(
    X, indices, test_size=0.3, random_state=1
)
y_train = y[idx_train]
y_test  = y[idx_test]

weights, params = [], []
for c in np.arange(-5, 5):
    lr = LogisticRegression(
        C=10.**c,
        solver='lbfgs',
        max_iter=1000
    )
    lr.fit(X_train, y_train)
    weights.append(lr.coef_[1])
    params.append(10.**c)
weights = np.array(weights)
plt.plot(params, weights[:, 0],
         label='Petal length')
plt.plot(params, weights[:, 1], linestyle='--',
         label='Petal width')
plt.ylabel('Weight coefficient')
plt.xlabel('C')
plt.legend(loc='upper left')
plt.xscale('log')
plt.show()