package by.epam.javatraining.TarliokouskiDzmitriy.tasks.Task4.Vector;

public class Vector {
    double[] array;

    //Пока так. Нужно будет - поменяю.
    public Vector(double arrays[]) {
        this.array = arrays;
    }

    //mode = false - минимальный экстремум
    //mode = true - максимальный экстремум
    public double findExtremum(boolean mode) {
        int index;

        if(mode) {
            index = findExtremumMax();
        }
        else {
            index = findExtremumMin();
        }

        return array[index];
    }

    public int findExtremumMax() {
        int max = 0;
        double maxElement = array[0];

        for (int i=1;i<array.length;i++) {
            if(maxElement<array[i]) {
                max = i;
                maxElement = array[i];
            }
        }

        printExtremum(max,2);
        return max;
    }

    public int findExtremumMin() {
        int min = 0;
        double minElement = array[0];

        for (int i=1;i<array.length;i++) {
            if (minElement<array[i]) {
                min=i;
                minElement = array[i];
            }
        }

        printExtremum(min, 1);
        return min;
    }

    public double arithmeticalMean() {
        double sum = 0.0;

        for (int i=0;i<array.length;i++) {
            sum+=array[i];
        }

        printMean(sum/array.length, 1);
        return sum/array.length;
    }

    public double geometricMean() {
        double mul = 1.;
        double result;

        for (double i: array) {
            mul*=i;
        }

        result=Math.pow(mul, array.length);
        printMean(result, 2);
        return result;
    }

    public boolean isSorted() {
        boolean flag = true;

        for(int i=1;i<array.length;i++) {
            if (array[i - 1] < array[i]) {
                flag = false;
                break; //опять забыл, что можно а что нет
            }
        }

        if(flag) {
            System.out.println("Отсортирован по возростанию.");
            return true;
        }

        flag=true;

        for(int i=1;i<array.length;i++) {
            if (array[i - 1] > array[i]) {
                flag = false;
                break; //опять забыл, что можно а что нет
            }
        }

        if(flag) {
            System.out.println("Отсортирован по убыванию.");
            return true;
        }

        return false;

    }

    //side: false - слева, true- справа.
    //mode: false - минимум, true - максимум.
    public int localExtremum(boolean side, boolean mode) {
        int index;

        if(mode) {
            index=localMaxExtremum(side);
        }
        else {
            index=localMinExtremum(side);
        }

        return index;
    }

    public int localMaxExtremum(boolean side) {
        int k;
        int pos;

        if(side) {
            k=-1;
            pos=array.length-2;
        }
        else {
            k=1;
            pos=1;
        }

        while(pos>0 && pos<array.length-1) {
            if(array[pos]<array[pos-k]) {
                printExtremum(pos-k,3);
                return pos-k;
            }
            pos+=k;
        }
        if(array[pos]>array[pos+k]) {
            printExtremum(pos,3);
            return pos;
        }
        else {
            printExtremum(pos+k,3);
            return pos+k;
        }
    }

    public int localMinExtremum(boolean side) {
        int k;
        int pos;

        if(side) {
            k=-1;
            pos=array.length-2;
        }
        else {
            k=1;
            pos=1;
        }

        while(pos>0 && pos<array.length-1) {
            if(array[pos]>array[pos-k]) {
                printExtremum(pos-k,4);
                return pos-k;
            }
            pos+=k;
        }
        if(array[pos]<array[pos+k]) {
            printExtremum(pos,4);
            return pos;
        }
        else {
            printExtremum(pos+k,4);
            return pos+k;
        }
    }

    public int linearSearch(double elementToSearch) {

        for (int index = 0; index < array.length; index++) {
            if (array[index] == elementToSearch)
                return index;
        }
        System.out.println("Элемент не найден. Метод вернёт -1.");
        return -1;
    }

    public int binarySearch(int firstElement, int lastElement, double elementToSearch) {

        // условие прекращения
        if (lastElement >= firstElement) {
            int mid = firstElement + (lastElement - firstElement) / 2;

            // если средний элемент - целевой элемент, вернуть его индекс
            if (array[mid] == elementToSearch)
                return mid;

            // если средний элемент больше целевого
            // вызываем метод рекурсивно по суженным данным
            if (array[mid] > elementToSearch)
                return binarySearch(firstElement, mid - 1, elementToSearch);

            // также, вызываем метод рекурсивно по суженным данным
            return binarySearch(mid + 1, lastElement, elementToSearch);
        }

        return -1;
    }

    public void selectionSort() {
        for(int i=0;i<array.length;i++) {
            double min=array[i];
            int pos=i;
            for(int j=i+1;j<array.length;j++) {
                if(min>array[j]) {
                    min=array[j];
                    pos=j;
                }
            }
            if(pos!=i) {
                double temp=array[pos];
                array[pos]=array[i];
                array[i]=temp;
            }
        }
    }

    public void reverseVector() {
        int arrayLength = array.length/2;
        for(int i=0;i<arrayLength;i++) {
            array[i]+=array[array.length-1-i];
            array[array.length-1-i]=array[i]-array[array.length-1-i];
            array[i]-=array[array.length-1-i];
        }
    }

    public void bubbleSort() {
        int arrayLength = array.length-1;
        for(int i=0;i<arrayLength;i++)  {
            for (int j=arrayLength;j>i;j--) {
                if(array[j]<array[j-1]) {
                    array[j]+=array[j-1];
                    array[j-1]=array[j]-array[j-1];
                    array[j]-=array[j-1];
                }
            }
        }
    }

    public void insertionSort() {
        for(int i=1;i<array.length;i++) {
            double key=array[i];
            int j=i-1;
            while (j>=0 && key<array[j]) {
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=key;
        }
    }

    public void quickSort(int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        double pivot = array[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    double tmp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(leftBorder, rightMarker);
        }
    }

    public void printVector() {
        for (double var : array) {
            System.out.print(var + " ");
        }

        System.out.println();
    }

    /*
    1 - минимум
    2 - максимум
    3 - локальный максимум
    4 - локальный минимум
     */
    private void printExtremum(int index, int mode) {
        switch (mode) {
            case 1:
                System.out.println("Минимальный экстремум "+array[index]+", индекс которого "+index+".");
                break;
            case 2:
                System.out.println("Максимальный экстремум "+array[index]+", индекс которого "+index+".");
                break;
            case 3:
                System.out.println("Местный максимальный экстремум "+array[index]+", индекс которого "+index+".");
                break;
            case 4:
                System.out.println("Местный минимальный экстремум "+array[index]+", индекс которого "+index+".");
                break;
            default:
                System.out.println("Некорректная конфигурация.");
                break;
        }
    }

    private void printMean(double result, int mode) {
        switch (mode) {
            case 1:
                System.out.println("Среднее арифметическое "+result+".");
                break;
            case 2:
                System.out.println("Среднее геометрическое "+result+".");
                break;
            default:
                System.out.println("Некорректная конфигурация.");
                break;
        }
    }

    public int vectorLength() {
        return array.length;
    }

}
