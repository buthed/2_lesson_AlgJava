package com.tematihonov;

import java.lang.reflect.Array;
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
        startTime = System.nanoTime();
        Arrays.sort(mArrayTask3Copy);
        endTime = System.nanoTime() - startTime;
        System.out.println("Время выполнения метода(Arrays.sort())= " + endTime);
        System.out.println();


        System.out.println("Task 2.4");


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
}
