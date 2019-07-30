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

    public Point2D findExtremumMax() {
        double max = matrix[0][0];
        int x=0;
        int y=0;

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

    private void printExtremum(int x, int y) {
        System.out.println("Экстремум в точке ("+x+","+y+"), равный "+matrix[x][y]+".");
    }
}
