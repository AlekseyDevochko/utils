package org.example.util;

public class ArraysUtil {

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    private static void printArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }


    /**
     * Print array in line or in row
     *
     * @param arr    int type array
     * @param inLine boolean value: true if in line, false if in row
     */
    public static void printArray(int[] arr, Boolean inLine) {
        if (inLine) {
            System.out.print("{");
            for (int i = 0; i < arr.length - 1; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.print(arr[arr.length - 1] + "}\n");
        } else {
            printArray(arr);
        }

    }

    public static void printArray(char[] arr, Boolean inLine) {
        if (inLine) {
            System.out.print("{");
            for (int i = 0; i < arr.length - 1; i++) {
                System.out.print("'" + arr[i] + "', ");
            }
            System.out.print(arr[arr.length - 1] + "}\n");
        } else {
            printArray(arr);
        }

    }


    /**
     * Fill array by random values
     *
     * @param arr int type array
     */
    public static void setArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = MathUtils.getRandom(100);
        }
    }

    /**
     * Create array
     *
     * @param length int type value
     * @return int type array
     */
    public static int[] initArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = MathUtils.inputInt("Enter " + (i + 1) + " element: ");
        }
        return arr;
    }


    /**
     * Creates new array and fills it by random values
     *
     * @param length int type value that represents size of array
     * @return new int type array
     */
    public static int[] getRandomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = MathUtils.getRandom(100);
        }
        return arr;
    }

    /**
     * Creates new array and fills it by random values from negative max_value to positive max_value
     *
     * @param length    int type value that represents size of array
     * @param max_value int type value
     * @return int type array
     */
    public static int[] getRandomArray(int length, int max_value) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            boolean isNegative = ((int) (Math.random() * 2) == 1);
            int x = MathUtils.getRandom(max_value);
            if (isNegative) {
                arr[i] = x * (-1);
            } else {
                arr[i] = x;
            }
        }
        return arr;
    }

    /**
     * Creates new array and fills it by random values
     *
     * @param length    int type value that represents size of array
     * @param min_value int type value
     * @param max_value int type value
     * @return int type array
     */
    public static int[] getRandomArray(int length, int min_value, int max_value) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = MathUtils.getRandom(min_value, max_value);
        }
        return arr;
    }


    /**
     * Increase size of array
     *
     * @param arr  array of int type elements
     * @param size int value
     * @return increased array
     */
    public static int[] increaseSizeOfArray(int[] arr, int size) {
        int[] new_arr = new int[arr.length + size];
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = arr[i];
        }
        return new_arr;
    }


    /**
     * Replace all zero elements by random values
     *
     * @param arr array of int type elements
     */
    public static void fillZeroInArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = MathUtils.getRandom(100);
            }
        }
    }


    /**
     * Calculate sum of all elements in array
     *
     * @param array array of int type elements
     * @return max int type element
     */
    public static int calculateArraySum(int[] array) {
        int result = 0;
        for (int elem :
                array) {
            result += elem;
        }

        return result;
    }


    /**
     * Finds max value
     *
     * @param arr array of int type elements
     * @return max int type element
     */
    public static int findMaxElement(int[] arr) {
        int max_elem = Integer.MIN_VALUE;
        for (int elem :
                arr) {
            if (elem > max_elem) {
                max_elem = elem;
            }
        }
        return max_elem;
    }

    /**
     * Finds min value
     *
     * @param arr array of int type elements
     * @return min  int type element
     */
    public static int findMinElement(int[] arr) {
        int min_elem = Integer.MAX_VALUE;
        for (int elem :
                arr) {
            if (elem < min_elem) {
                min_elem = elem;
            }
        }
        return min_elem;
    }

    /**
     * Finds middle element, if even - left elem from the middle
     *
     * @param arr int type array
     */
    public static void findMiddleElement(int[] arr) {
        int middleElement = (arr.length - 1) / 2;
        System.out.println("array[" + middleElement + "] = " + arr[middleElement]);
    }

    /**
     * Calculate average value between all elements in matrix
     *
     * @param arr int type matrix
     * @return double type average value
     */
    public static double calculateMatrixAverage(int[][] arr) {
        int number_of_elements = 0;
        int result = 0;
        for (int[] mass :
                arr) {
            for (int elem :
                    mass) {
                number_of_elements++;
                result += elem;
            }
        }

        return result / (double) number_of_elements;
    }

    /**
     * Print matrix
     *
     * @param matrix int type matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            printArray(matrix[i], true);
        }
    }

    /**
     * Creates new matrix and fills it by random values
     *
     * @param number_of_rows    int type value
     * @param number_of_columns int type value
     * @return int type matrix
     */
    public static int[][] initMatrix(int number_of_rows, int number_of_columns) {
        int[][] matrix = new int[number_of_rows][number_of_columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = MathUtils.getRandom(0, 9);
            }
        }
        return matrix;
    }


    public static double findAverageMarks(int[] arr) {
        int sum = calculateArraySum(arr);
        double average_mark = sum / (double) arr.length;
        Tasks.task3(average_mark);
        return average_mark;
    }

    public static int[] sumArraysElements(int[] arr1, int[] arr2) {
        int[] arr_result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr_result[i] = arr1[i] + arr2[i];
        }
        return arr_result;
    }

    /**
     * Concat two arrays
     *
     * @param arr1 int type array
     * @param arr2 int type array
     * @return int type array
     */
    public static int[] concatArrays(int[] arr1, int[] arr2) {
        int[] new_arr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            new_arr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            new_arr[arr1.length + i] = arr2[i];
        }
        return new_arr;
    }

    public static int[] concatArrays(int[] arr1, int[] arr2, int element) {
        int[] new_arr = new int[arr1.length + arr2.length + 1];
        for (int i = 0; i < arr1.length; i++) {
            new_arr[i] = arr1[i];
        }
        new_arr[arr1.length] = element;
        for (int i = 0; i < arr2.length; i++) {
            new_arr[arr1.length + i + 1] = arr2[i];
        }
        return new_arr;
    }

    public static int[] plusOneElement(int[] arr, int element) {
        int[] result = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        result[result.length - 1] = element;
        return result;
    }

    /**
     * Quick sort O = n * log n (n)
     *
     * @param arr  int type array
     * @param low  the first elements index
     * @param high the last elements index+
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int index = low + (high - low) / 2;
        int middle = arr[index];

        int i = low;
        int j = high;

        while (i <= j) {
            while (arr[i] < middle) {
                i++;
            }

            while (arr[j] > middle) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, j, high);
        }


    }

    public static void selectionSort(int[] arr, boolean desc) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (desc ? temp > arr[j] : temp < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

    }

    public static void selectionSort(int[] arr) {
        selectionSort(arr, false);
    }

//    public static void bubbleSort(int[] arr){
//
//        while (true){
//            int flag = 0;
//            for (int i = 0; i < arr.length; i++) {
//                if (i + 1 == arr.length){
//                    continue;
//                }
//                if (arr[i] > arr[i + 1]){
//                    int temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//                } else {
//                    flag++;
//                }
//            }
//            if (flag == arr.length - 1){
//                break;
//            }
//        }
//
//    }


    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void test(int[] arr) {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        int zero = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = MathUtils.getRandom(10);
            switch (arr[i]) {
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
                case 7:
                    seven++;
                    break;
                case 8:
                    eight++;
                    break;
                case 9:
                    nine++;
                    break;

            }
        }

        System.out.println("1: " + one);
        System.out.println("2: " + two);
        System.out.println("3: " + three);
        System.out.println("4: " + four);
        System.out.println("5: " + five);
        System.out.println("6: " + six);
        System.out.println("7: " + seven);
        System.out.println("8: " + eight);
        System.out.println("9: " + nine);
        System.out.println("0: " + zero);


    }

    public static char[] getCharArray(int length) {
        char[] arr = new char[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (int) (MathUtils.getRandom(128));
        }
        return arr;
    }

    public static char[] getLetters(char[] arr) {
        char[] letters = new char[arr.length];
        int new_length = 0;
        for (int i = 0; i < arr.length; i++) {
            int code = (int) arr[i];
            if ((code >= 65 && code <= 90) || (code >= 97 && code <= 122)) {
                letters[new_length] = arr[i];
                new_length++;
            }
        }
        char[] new_arr = new char[new_length];
        for (int i = 0; i < new_arr.length; i++) {
            new_arr[i] = letters[i];
        }
        return new_arr;
    }

    public static int[] getCodesFromLetters(char[] chars) {
        int[] result = new int[chars.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) chars[i];
        }
        return result;
    }

    public static char[] getLettersFromCode(int[] arr) {
        char[] result = new char[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (char) arr[i];
        }
        return result;
    }

    public static char[] quickSortChars(char[] chars) {
        int[] ints = getCodesFromLetters(chars);
        //quickSort(ints, 0, ints.length);
        selectionSort(ints, true);
        //bubbleSort(ints);
        return getLettersFromCode(ints);

    }

    /*Для проверки остаточных знаний учеников после летних каникул, учитель младших классов решил
    начинать каждый урок с того, чтобы задавать каждому ученику пример из таблицы умножения, но в
    классе 15 человек, а примеры среди них не должны повторяться. В помощь учителю напишите программу,
    которая будет выводить на экран 15 случайных примеров из таблицы умножения (от 2*2 до 9*9,
    потому что задания по умножению на 1 и на 10 — слишком просты). При этом среди 15 примеров не
    должно быть повторяющихся (примеры 2*3 и 3*2 и им подобные пары считать повторяющимися).   */
    public static void task26() {
        String[] result = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        int flag = 0;
        while (flag < 15) {
            int number1 = MathUtils.getRandom(2, 9);
            int number2 = MathUtils.getRandom(2, 9);
            String string1 = number1 + "*" + number2;
            String string2 = number2 + "*" + number1;
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (result[i] != null) {
                    if (result[i].equals(string1) || result[i].equals(string2)) {
                        break;
                    } else {
                        j++;
                    }
                }
            }
            if (j == 15) {
                result[flag] = string1;
                flag++;
            }

        }
        for (String string :
                result) {
            System.out.print(string + ", ");
        }
    }

    public static void task25() {
        int[][] matrix = initMatrix(6, 7);
        System.out.println("-----BEFORE-----");
        for (int[] element :
                matrix) {
            printArray(element, true);
        }
        for (int[] element :
                matrix) {
            selectionSort(element);
        }
        System.out.println("-----AFTER-----");
        for (int[] element :
                matrix) {
            printArray(element, true);
        }
    }

    public static void task5(int[] arr) {
        int j = 0;
        for (int i = arr.length - 1; i > j; i--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j++;
        }

    }


    public static void main(String[] args) {
//        int[] arr = new int[MathUtils.inputInt("Enter size of array: ")];
//        setArray(arr);
//        printArray(arr, false);

//        System.out.println(findMaxElement(arr));
//        System.out.println(findMinElement(arr));

//        findMiddleElement(arr);

//        int[][] matrix = initMatrix(MathUtils.inputInt("rows: "), MathUtils.inputInt("columns: "));
//        printMatrix(matrix);
//        System.out.println(calculateMatrixAverage(matrix));

//        int[] arr = initArray(MathUtils.inputInt("Enter arrays size: "));
//        printArray(arr,true);


//        System.out.println(findAverageMarks(initRandomArray(MathUtils.inputInt("Number of marks: "), 10)));

//        int[] arr_2 = setArray(MathUtils.inputInt("Enter size of array: "));
//        printArray(arr_2, true);
//
//        System.out.println(calculateArraySum(arr));

//        int[] arr1 = getRandomArray(MathUtils.getRandom(10), 100);
//        int[] arr2 = getRandomArray(MathUtils.getRandom(10), 100);
//
//        printArray(arr1, true);
//
//        quickSort(arr1, 0, arr1.length-1);
//
//        printArray(arr1, true);

//        int[] arr1 = getRandomArray(10, 100);
//        printArray(arr1, true);
//        bubbleSort(arr1);
//        printArray(arr1, true);

//        int[] arr = new int[10000];
//        test(arr);

//        char[] arr = getLetters(getCharArray(50));
////        printArray(arr, true);
//        printArray(arr, true);
//        printArray(quickSortChars(arr), true);


//        printArray(arr1, true);
//        printArray(arr2, true);
//
//        printArray(sumArraysElements(arr1, arr2), true);
//        printArray(concatArrays(arr1, arr2), true);
        int[] arr = getRandomArray(10);
        printArray(arr, true);
        bubbleSort(arr);
        //quickSort(arr, 0, arr.length - 1);
        printArray(arr, true);

    }
}
