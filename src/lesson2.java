public class lesson2 {
    public static void main(String[] args) {
        //Задание 2.1
        System.out.println("=====Задание 2.1=====");
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Изначальный массив: ");
        showArray(array1);
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                array1[i] = 1;
            } else if (array1[i] == 1) {
                array1[i] = 0;
            }
        }
        System.out.println("Переработанный массив: ");
        showArray(array1);

        //Задание 2.2
        System.out.println("\n=====Задание 2.2=====");
        int[] array2 = new int[8];
        for (int i = 1; i < array2.length; i++) {
            array2[i] += (array2[i - 1] + 3);
        }
        showArray(array2);

        //Задание 2.3
        System.out.println("\n=====Задание 2.3=====");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Изначальтный массив:");
        showArray(array3);
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] = array3[i] * 2;
            }
        }
        System.out.println("Переработанный массив:");
        showArray(array3);

        //Задание 2.4
        System.out.println("\n=====Задание 2.4=====");
        int[][] array4 = new int[15][15];
        System.out.println("Изначальный массив:");
        showCompositArray(array4);
        int last_element_index = (array4.length - 1);
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                if (i == j && j == last_element_index) {
                    array4[i][j] = 1;
                    last_element_index--;
                } else if (i == j) {
                    array4[i][j] = 1;
                } else if (j == last_element_index) {
                    array4[i][j] = 1;
                    last_element_index--;
                }
            }
        }
        System.out.println("Переработанный массив:");
        showCompositArray(array4);

        //Задание 2.5
        System.out.println("\n=====Задание 2.5=====");
        System.out.println("Генерируется случайный массив длинной 10 элементов");
        int[] array5 = new int[10];
        array5 = createRandomSimpleArray(array5);
        showArray(array5);
        findeMin(array5);
        findeMax(array5);

        //Задание 2.6
        System.out.println("\n=====Задание 2.6=====");
        System.out.println("Генерируется случайный массив длинной 10 элементов");
        int[] array6 = new int[10];
        int asd = 0;
        do {
            array6 = createRandomSimpleArray(array6);
            asd++;
        } while (equalParts(array6) == false);
        showArray(array6);
        System.out.println("Количество попыток генерации подходящего массива: " + asd);
        System.out.println("Наличие равных частей: " + equalParts(array6));

        //Задание 2.7
        System.out.println("\n=====Задание 2.7=====");
        System.out.println("Генерируется случайный массив длинной 10 элементов");
        int[] array7 = new int[10];
        array7 = createRandomSimpleArray(array7);
        showArray(array7);
    }

    static void showArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    static void showCompositArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    static int[] createRandomSimpleArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    static void findeMin(int[] arr) {
        int min = arr[0];
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        System.out.println("Наименьший элемент массива: " + min);
    }

    static void findeMax(int[] arr) {
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        System.out.println("Наибольший элемент массива: " + max);
    }

    static boolean equalParts(int[] arr) {
        int[] arr1 = new int[arr.length];
        int i = 0;
        do {
            if (i == 0) {
                arr1[i] = arr[i];
            } else {
                arr1[i] = arr1[i - 1] + arr[i];
            }
            i++;
        } while (i < (arr.length));
        int[] arr2 = new int[arr.length];
        int j = (arr.length - 1);
        do {
            if (j == (arr.length - 1)) {
                arr2[j] = arr[j];
            } else {
                arr2[j] = arr2[j + 1] + arr[j];
            }
            j--;
        } while (j >= 0);
        int k = 0;
        while (k < (arr.length - 1)) {
            if (arr1[k] == arr2[k + 1] || arr2[k] == arr1[k + 1]) {
                return true;
            }
            k++;
        }
        return false;
    }
}