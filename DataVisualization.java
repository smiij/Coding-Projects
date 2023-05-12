import java.util.*;
import java.io.*;


public class DataVisualization {
    public static void main(String[] args) throws FileNotFoundException {

        intro();
        Scanner user = new Scanner(System.in);

        System.out.println();
        System.out.print("input file name? ");
        String fileName = user.nextLine();
        Scanner inFile = new Scanner(new File(fileName));
        //readIn(inFile);
        int[] arr = readIn(inFile);
        int index = findIndex(arr);
        int[] counter = occur(arr);
        histo(counter);
        stats(arr, counter);
    }

    //prints the program's intro message. Method 1
    public static void intro() {
        System.out.println("The program will analyze data from a dataset of");
        System.out.println("non-negative integer values. It will produce a");
        System.out.println("histogram of the data and output some statistics.");
    }
    //reads the file from the users input. Method 2
    public static int[] readIn(Scanner inFile) {
        int num = inFile.nextInt();
        int[] arr = new int[num];

        for (int i=0; i < num; i++) {
            arr[i] = inFile.nextInt();
        }
        return arr;
    }

    //method to find the index of the largest number of the array. takes in parameter arr
    public static int findIndex(int[] arr) {

        int index = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > arr[index]) {
                index = j;
            }
        }
        return index;
    }

    //method that finds the number of occurences of each number in the array. Takes in the array parameter.
    //Method 4
    public static int[] occur(int[] arr) {
        int arrSize = arr[findIndex(arr)] + 1;
        int[] counter = new int[arrSize];

        for (int a = 0; a < counter.length; a++) {
            for (int b = 0; b < arr.length; b++) {
                if ( a == arr[b]) {
                    counter[a]++;
                }
            }
        }
        return counter;
    }

    //this method calculates the average of all the numbers within the array. It takes in the parameter array.
    //Method 5
    public static double compute(int[] arr) {
        int total = 0;

        for (int m = 0; m < arr.length; m++) {
            total += m;
        }
        return total / arr.length;
    }

    //method that creates a histogram based on how many times each number shows up, takes in the array counter
    //Method 6
    public static void histo(int[] counter) {
        System.out.println();

        for ( int i = 0; i < counter.length; i++) {
            System.out.print(i + "| ");

            for (int w = 0; w < counter[i] ; w++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }


    //Method 7
    //calculates and prints out the average, mean and mode of the file that the user inputed
    public static void stats(int[] arr, int[] counter) {
        int numVals = 0;
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            numVals++;
        }
        System.out.println("Num. Values: " + numVals);

        for (int k = 0; k < arr.length; k++) {
            sum = sum + arr[k];
        }
        double mean = sum / arr.length;
        System.out.println("Mean: " + mean);

        findIndex(counter);
        System.out.println("Mode: " + (findIndex(counter)));
    }
}