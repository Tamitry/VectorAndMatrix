package by.epam.javatraining.TarliokouskiDzmitriy.tasks.Task4.Matrix;

import com.sun.prism.image.Coords;
import javafx.geometry.Point2D;
import javafx.util.Pair;

import java.awt.*;

public class Matrix {
    private double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    //Тут не стал делать никаких switch. Просто отдельные методы. Не знаю, как оно лучше, но так проще.
    public Point2D findExtremumMax() {

        double max = matrix[0][0];
        int x=0;
        int y=0;

        if(isEmpty()) {
            System.out.println("Пустаяя матрица.");
            return new Point2D(-1,-1);
        }

        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                if (max<matrix[i][j]) {
                    max = matrix[i][j];
                    x=j;
                    y=i;
                }
            }
        }

        printExtremum(x,y);
        return new Point2D(x,y);
    }

    public Point2D findExtremumMin() {

        double min = matrix[0][0];
        int x=0;
        int y=0;

        if(isEmpty()) {
            System.out.println("Пустаяя матрица.");
            return new Point2D(-1,-1);
        }

        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                if (min<matrix[i][j]) {
                    min = matrix[i][j];
                    x=j;
                    y=i;
                }
            }
        }

        printExtremum(x,y);
        return new Point2D(x,y);
    }

    //Симметрична ли матрица по главной и побочной осях.
    public boolean isSymmetricMatrixMain() {

        boolean flag = true;

        for(int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix.length;j++) {
                if(matrix[i][j]!=matrix[j][i]) {
                    flag=false;
                }
            }
        }

        return flag;
    }

    public boolean isSymmetricMatrixSide() {

        boolean flag = true;

        for(int i=matrix.length-1;i>0;i--) {
            for (int j=0;j<matrix.length;j++) {
                if(matrix[i][j]!=matrix[matrix.length-1-j][matrix.length-1-i]) {
                    flag=false;
                }
            }
        }

        return flag;
    }

    //Среднее арифмитическое всех элементов.
    public double arithmeticalMean() {

        double sum=0;
        int count=0;

        for(int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                sum+=matrix[i][j];
                count++;
            }
        }

        return sum/count;
    }

    //Среднее геометрическое всех элементов.
    public double geometricMean() {

        double mul=1.;
        int count=0;

        for(int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                mul*=matrix[i][j];
                count++;
            }
        }

        return Math.pow(mul,count);
    }

    //Локальные экстремумы. Максимум и минимум соответственно.
    public Point2D localExtremumMax() {

        int i=0;
        int j=0;

        if(isEmpty()) {
            System.out.println("Пустаяя матрица.");
            return new Point2D(-1,-1);
        }

        while (matrix[i+1][j]>matrix[i][j]||matrix[i][j+1]>matrix[i][j]) {
            if(matrix[i+1][j]>matrix[i][j+1]) {

                i++;

                if(matrix.length-1==i) {
                    printExtremum(i,j);
                    return new Point2D(i,j);
                }
            }
            else {
                j++;
                if(matrix.length-1==j) {
                    printExtremum(i,j);
                    return new Point2D(i,j);
                }
            }
        }

        printExtremum(i,j);
        return new Point2D(i,j);
    }

    public Point2D localExtremumMin() {

        int i=0;
        int j=0;

        if(isEmpty()) {
            System.out.println("Пустаяя матрица.");
            return new Point2D(-1,-1);
        }

        while (matrix[i+1][j]<matrix[i][j]||matrix[i][j+1]<matrix[i][j]) {
            if(matrix[i+1][j]<matrix[i][j+1]) {

                i++;

                if(matrix.length-1==i) {
                    printExtremum(i,j);
                    return new Point2D(i,j);
                }
            }
            else {
                j++;
                if(matrix.length-1==j) {
                    printExtremum(i,j);
                    return new Point2D(i,j);
                }
            }
        }

        printExtremum(i,j);
        return new Point2D(i,j);
    }

    //Транспонирование матрицы. Вроде так, но могу и глупасть сделать.
    public void transpose() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                matrix[j][i] += matrix[i][j];
                matrix[i][j] = matrix[j][i]-matrix[i][j];
                matrix[j][i] -= matrix[i][j];
            }
        }
    }

    //Вывод матрицы.
    public void printMatrix() {

        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[i].length ; j++) {
                System.out.print( matrix[i][j]+"  ");
            }
            System.out.println();
        }

    }

    //Вывод экстремумов.
    private void printExtremum(int x, int y) {
        System.out.println("Экстремум в точке ("+x+","+y+"), равный "+matrix[x][y]+".");
    }

    //Пуста ли матрица. Да - true, нет - false.
    private boolean isEmpty() {

        if(matrix.length==0) {
            return true;
        }
        else {
            return true;
        }
    }

}
