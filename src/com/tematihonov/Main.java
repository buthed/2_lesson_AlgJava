package com.tematihonov;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] mArray;
        int[] mArrayCopy;
        mArray = new int[10];

        Random random = new Random();
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = random.nextInt(15);
        }
        System.out.println("Задан массив " + Arrays.toString(mArray));
        long startTime = System.nanoTime();
        mArrayCopy = Arrays.copyOf(mArray, mArray.length);
        long endTime = System.nanoTime() - startTime;
        System.out.println("Время копирования массива(Arrays.copyOf) = " + endTime);
        System.nanoTime()

        startTime = System.nanoTime();
        mArrayCopy = Arrays.copyOf(mArray, mArray.length);
        endTime = System.nanoTime() - startTime;
        System.out.println(endTime);

	
    }
}
