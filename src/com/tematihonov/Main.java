package com.tematihonov;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] mArray;
        int[] mArrayCopy;
        long startTime;
        long endTime;
        mArray = new int[15];

        Random random = new Random();
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = random.nextInt(15);
        }
        System.out.println("Task 2.1");
        System.out.println("Задан массив: " + Arrays.toString(mArray));
        startTime = System.nanoTime();
        mArrayCopy = Arrays.copyOf(mArray, mArray.length);
        endTime = System.nanoTime() - startTime;
        System.out.println("Время копирования массива(Arrays.copyOf) = " + endTime);


        startTime = System.nanoTime();
        String a = Arrays.toString(mArray);
        endTime = System.nanoTime() - startTime;
        System.out.println("Время выполнения метода(Arrays.toString) = " + endTime);

        startTime = System.nanoTime();
        boolean b = Arrays.equals(mArray,mArrayCopy);
        endTime = System.nanoTime() - startTime;
        System.out.println("Время выполнения метода(Arrays.toString) = " + endTime);
        System.out.println();


        System.out.println("Task 2.2");
        startTime = System.nanoTime();
        linearSearch(mArray,3);
        endTime = System.nanoTime() - startTime;
        System.out.println("Время линейного поиска = " + endTime);


        startTime = System.nanoTime();
        binarySearch(mArray,3);
        endTime = System.nanoTime() - startTime;
        System.out.println("Время двоичного поиска = " + endTime);
        System.out.println();


        System.out.println("Task 2.3");
        int[] mArrayTask3 = new int[400];
        int[] mArrayTask3Copy;
        for (int i = 0; i < mArrayTask3.length; i++) {
            mArrayTask3[i] = random.nextInt(30);
        }
        mArrayTask3Copy = Arrays.copyOf(mArrayTask3, mArrayTask3.length);
        System.out.println("Вывод заданного массива: " + Arrays.toString(mArrayTask3Copy));
        startTime = System.nanoTime();
        Arrays.sort(mArrayTask3Copy);
        long arraysSortEndTime = System.nanoTime() - startTime;
        System.out.println("Вывод отсортированного массива: " + Arrays.toString(mArrayTask3Copy));
        System.out.println("Время выполнения метода(Arrays.sort())= " + arraysSortEndTime);
        System.out.println();


        System.out.println("Task 2.4");
        mArrayTask3Copy = Arrays.copyOf(mArrayTask3, mArrayTask3.length);   //убираем сортировку
        System.out.println("Вывод заданного массива: " + Arrays.toString(mArrayTask3Copy));
        startTime = System.nanoTime();
        bubbleSort(mArrayTask3Copy);
        long bubbleSortEndTime = System.nanoTime() - startTime;
        System.out.println("Вывод отсортированного массива: " + Arrays.toString(mArrayTask3Copy));
        System.out.println("Время выполнения пузырьковой сортировки = " + bubbleSortEndTime);
        System.out.println();



        System.out.println("Task 2.5");
        mArrayTask3Copy = Arrays.copyOf(mArrayTask3, mArrayTask3.length);   //убираем сортировку
        System.out.println("Вывод заданного массива: " + Arrays.toString(mArrayTask3Copy));
        startTime = System.nanoTime();
        selectionSort(mArrayTask3Copy);
        long selectionSortEndTime = System.nanoTime() - startTime;
        System.out.println("Вывод отсортированного массива: " + Arrays.toString(mArrayTask3Copy));
        System.out.println("Время выполнения сортировки методом выбора = " + selectionSortEndTime);
        System.out.println();

        System.out.println("Task 2.6");
        mArrayTask3Copy = Arrays.copyOf(mArrayTask3, mArrayTask3.length);   //убираем сортировку
        System.out.println("Вывод заданного массива: " + Arrays.toString(mArrayTask3Copy));
        startTime = System.nanoTime();
        insertionSort(mArrayTask3Copy);
        long insertionSortEndTime = System.nanoTime() - startTime;
        System.out.println("Вывод отсортированного массива: " + Arrays.toString(mArrayTask3Copy));
        System.out.println("Время выполнения сортировки методом вставки = " + insertionSortEndTime);
        System.out.println();

        System.out.println("Вывод.");
        System.out.println("Сравнение время выполнения сортировки:");
        System.out.println("Время выполнения метода(Arrays.sort())= " + arraysSortEndTime);
        System.out.println("Время выполнения пузырьковой сортировки = " + bubbleSortEndTime);
        System.out.println("Время выполнения сортировки методом выбора = " + selectionSortEndTime);
        System.out.println("Время выполнения сортировки методом вставки = " + insertionSortEndTime);
    }

    public static int linearSearch(int arr[], int elementToSearch) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch)
                return index;
        }
        return -1;
    }

    public static int binarySearch(int arr[], int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }
            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;
            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;
        }
        return -1;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    pos = j;
                    min = arr[j];
                }
            }
            arr[pos] = arr[i];
            arr[i] = min;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int buff = arr[i];
            int in = i;
            while (in > 0 && arr[in-1] >= buff) {
                arr[in] = arr[in-1];
                in--;
            }
            arr[in + 1] = buff;
        }
    }
}
