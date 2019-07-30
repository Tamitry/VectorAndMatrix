package by.epam.javatraining.TarliokouskiDzmitriy.tasks.Task4.Vector;

public class Vector {
    double[] array;

    //Пока так. Нужно будет - поменяю. Был вариант просто переменные вписывать в параметры. Но он конфликтовал с этим.
    public Vector(double arrays[]) {
        this.array = arrays;
    }

    //Ищет экстремумы вектора. Один булевский параметр. Ниже частные случаи.
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

        if(isEmpty()) {
            System.out.println("Пустой вектор.");
            return -1;
        }

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

        if(isEmpty()) {
            System.out.println("Пустой вектор.");
            return -1;
        }

        for (int i=1;i<array.length;i++) {

            if (minElement<array[i]) {
                min=i;
                minElement = array[i];
            }

        }

        printExtremum(min, 1);
        return min;
    }

    //Среднееарифметическое всех элементов вектора.
    public double arithmeticalMean() {

        double sum = 0.0;

        for (int i=0;i<array.length;i++) {

            sum+=array[i];

        }

        printMean(sum/array.length, 1);
        return sum/array.length;
    }

    //Среднеегеометрическое всех элементов вектора.
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

    //Проверяет, осортирован ли массив.
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

    //Локальные экстремумы. Ниже дополнительные методы.
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

        if(isEmpty()) {
            System.out.println("Пустой вектор.");
            return -1;
        }

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

        if(isEmpty()) {
            System.out.println("Пустой вектор.");
            return -1;
        }

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

    //Простейший поиск. Наиболее медленный, но не требует сортировки.
    public int linearSearch(double elementToSearch) {

        for (int index = 0; index < array.length; index++) {

            if (array[index] == elementToSearch) {

                return index;

            }
        }

        System.out.println("Элемент не найден. Метод вернёт -1.");
        return -1;
    }

    //Рекурсивный поиск. Сортировка нужна. Оба раза, если метод не находит элемент - вернется -1.
    public int binarySearch(int firstElement, int lastElement, double elementToSearch) {

        if (lastElement >= firstElement) {

            int mid = firstElement + (lastElement - firstElement) / 2;

            if (array[mid] == elementToSearch) {

                return mid;

            }

            if (array[mid] > elementToSearch) {

                return binarySearch(firstElement, mid - 1, elementToSearch);

            }

            return binarySearch(mid + 1, lastElement, elementToSearch);

        }

        return -1;
    }

    //Сортировка выбором.
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

    //Реверс вектора.
    public void reverseVector() {

        int arrayLength = array.length/2;

        for(int i=0;i<arrayLength;i++) {

            array[i]+=array[array.length-1-i];
            array[array.length-1-i]=array[i]-array[array.length-1-i];
            array[i]-=array[array.length-1-i];

        }
    }

    //Сортировка пузырьком.
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

    //Сортировка вставкой.
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

    //Быстрая сортировка. Параметры - левая и правая границы. Нужен еще один метод, чтобы вообще без параметров была.
    public void quickSort(int leftBorder, int rightBorder) {

        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        double pivot = array[(leftMarker + rightMarker) / 2];

        do {

            while (array[leftMarker] < pivot) {
                leftMarker++;
            }

            while (array[rightMarker] > pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    double tmp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            quickSort(leftMarker, rightBorder);
        }

        if (leftBorder < rightMarker) {
            quickSort(leftBorder, rightMarker);
        }
    }

    //Вывод вектора. Использовад для проверки.
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

    //Вывод средних значений.
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

    //Длина вектора.
    public int vectorLength() {
        return array.length;
    }

    private boolean isEmpty() {

        if(array.length==0) {
            return true;
        }
        else {
            return true;
        }
    }

}
