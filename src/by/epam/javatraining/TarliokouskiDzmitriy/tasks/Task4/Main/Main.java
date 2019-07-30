package by.epam.javatraining.TarliokouskiDzmitriy.tasks.Task4.Main;

import by.epam.javatraining.TarliokouskiDzmitriy.tasks.Task4.Matrix.Matrix;
import by.epam.javatraining.TarliokouskiDzmitriy.tasks.Task4.Vector.Vector;

import java.util.Arrays;

/**
 * @author Tarliokouski Dzmitriy
 */
/*
    В английский не очень могу. А искать времени нет ¯\_(ツ)_/¯.
    Create Matrix and Vector objects.
 */
public class Main {
    public static void main(String args[]) {
        double[][] mat ={
                {1,2,6},
                {4,1,4},
                {13,2,12}
        };
        Matrix matrix = new Matrix(mat);
        matrix.printMatrix();
        matrix.transpose();
        matrix.printMatrix();
    }

}
