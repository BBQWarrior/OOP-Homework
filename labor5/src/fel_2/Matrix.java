package fel_2;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.min;

public class Matrix {
    private double[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = new double[this.rows][this.columns];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = Arrays.copyOf(data[i], data[i].length);
        }
    }

    public Matrix(Matrix mat) {
        this.rows = mat.rows;
        this.columns = mat.columns;
        this.data = new double[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            this.data[i] = Arrays.copyOf(mat.data[i], mat.data[i].length);
        }
    }

    public void fillRandom(double a, double b) {
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = rand.nextDouble() * (b - a) + a;
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res.append(String.format("%10.3f", data[i][j]) + ", ");
            }
            res.append("\n");
        }
        return res.toString();
    }

    public void printMatrix() {
        System.out.print(this.toString());
    }

    public static Matrix add(Matrix a, Matrix b) {
        if (a.columns != b.columns || a.rows != b.rows) {
            return null;
        }
        Matrix res = new Matrix(a.rows, a.columns);
        for (int i = 0; i < res.rows; i++) {
            for (int j = 0; j < res.columns; j++) {
                res.data[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        return res;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.columns != b.rows || a.rows != b.columns) {
            return null;
        }

        Matrix res = new Matrix(min(a.rows, b.rows), min(a.columns, b.columns));
        for (int i = 0; i < res.rows; i++) {
            for (int j = 0; j < res.columns; j++) {
                res.data[i][j] = 0;
                for (int k = 0; k < a.rows; k++) {
                    res.data[i][j] += a.data[i][k] * b.data[k][j];
                }
            }
        }
        return res;
    }

    public static Matrix transpose(Matrix in) {
        Matrix res = new Matrix(in.columns, in.rows);
        for (int i = 0; i < res.rows; i++) {
            for (int j = 0; j < res.columns; j++) {
                res.data[i][j] = in.data[j][i];
            }
        }
        return res;
    }
}
