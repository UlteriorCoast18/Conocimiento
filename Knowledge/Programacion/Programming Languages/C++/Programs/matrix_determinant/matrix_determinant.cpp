#include <iostream>
#include <iomanip>    // for std::setw and std::setfill
#include <vector>
#include <cmath>

using namespace std;

const int decimals = 2;

double abs_value(double val){
    if(val >= 0.0) return val;
    else return -val;
}

int max_length_matrix_input(const vector<vector<double>>& matrix){
    int max_length = 0;
    double max_value = 0.0;
    for (const auto& row : matrix) {
        for (double val : row) {
            if(abs_value(val) >= max_value) max_value = abs_value(val); 
        }
    }
    if (max_value != 0.0) return (int) (log(max_value) / log(10)) + 1;
    else return 1;
}

void print_matrix(const vector<vector<double>>& matrix){
    int max = max_length_matrix_input(matrix);
    for (const auto& row : matrix) {
        cout << "[ ";
        for (double val : row) {
            cout << setfill(' ') << setw(max + decimals + 1) << fixed << setprecision(decimals) << val << " ";
        }
        cout << "]" << endl;
    }
}

vector<vector<double>> gen_sec_matrix(const vector<vector<double>>& matrix, int j){
    vector<vector<double>> sec_matrix;
    vector<double> sec_row;
    int row_counter = 0;
    int col_counter;
    for (const auto& row : matrix) {
        if(row_counter != 0){
            col_counter = 0;
            for (double val : row) {
                if(col_counter != j) sec_row.push_back(val);
                col_counter++;
            }
            sec_matrix.push_back(sec_row);
            sec_row.clear();
        }
        row_counter++;
    }
    return sec_matrix;
}

double calculate_det(const vector<vector<double>>& matrix, int n){
    double det = 0;
    double sign;
    if (n > 2){
        vector<vector<double>> sec_matrix;
        for (int i = 0; i < n; i++){
            sign = i % 2 == 0 ? 1.00 : -1.00;
            sec_matrix = gen_sec_matrix(matrix, i);
            det += sign * matrix[0][i] * calculate_det(sec_matrix, n-1);
            sec_matrix.clear();
        }
        return det;
    }
    else if(n == 2) return (matrix[0][0]*matrix[1][1] - matrix[1][0]*matrix[0][1]);
    else if(n == 1) return matrix[0][0];
    return 0;
}

int main(){
    int n = 4;

    vector<vector<double>> matrix = {
        {1,-7,9,0},
        {0,1,1,0},
        {23,-2,1,-90},
        {1,-29,17,0},
    };

    print_matrix(matrix);

    cout << endl << "Determinante: " << calculate_det(matrix, n) << endl;
}