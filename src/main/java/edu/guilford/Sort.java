package edu.guilford;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Sort 
{
    public static void main( String[] args )
    {
        // 
        final int MAX;
        final int RANGE = 100;
        Random rand = new Random();

        //ask the user how many objects do they want to create
        System.out.println("How many objects do you want to create?");
        Scanner scan = new Scanner(System.in);
        MAX = scan.nextInt();

        int[] applicants = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            applicants[i] = rand.nextInt(1, RANGE + 1);
        }
        //print the array for the selection sort
        long startTime = System.nanoTime();
        PositionApplicant.selectionSort(applicants);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Selection sort took " + duration / 1e6 + " milliseconds");

        //shuffle the array for the quickSort
        shuffle(applicants);
        startTime = System.nanoTime();
        PositionApplicant.quickSort(applicants);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Quick sort took " + duration / 1e6 + " milliseconds");

        shuffle(applicants);
        // print the array using linear search
        int randValue = rand.nextInt(RANGE);
        startTime = System.nanoTime();
        int index = PositionApplicant.linearSearch(applicants, randValue);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Linear search took " + duration / 1e6 + " milliseconds");
        System.out.println("Using linear search the index of " + randValue + " is " + index);

        shuffle(applicants);
        //print the sorted array
        index = PositionApplicant.binarySearch(applicants, randValue);
        System.out.println("Binary search took " + duration / 1e6 + " milliseconds");
        System.out.println("Using binary search the index of " + randValue + " is " + index);


    }

        

    private static void shuffle(int[] applicants) {
        // shuffle the array
        for (int i = 0; i < applicants.length; i++) {
            int randomIndexToSwap = (int) (Math.random() * applicants.length);
            int temp = applicants[randomIndexToSwap];
            applicants[randomIndexToSwap] = applicants[i];
            applicants[i] = temp;
        }
    }

    // Add a static method to swap two elements in an array
    private static void swap(int[] applicants, int i, int j) {
        int temp = applicants[i];
        applicants[i] = applicants[j];
        applicants[j] = temp;
    }
}
