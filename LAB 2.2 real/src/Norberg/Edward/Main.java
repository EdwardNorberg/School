package Norberg.Edward;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How long is the array?");
        int in = sc.nextInt();
        System.out.println("\nPlease type the " + in +  " integers: ");
        int [] intArray = new int[in];
        for(int i = 0; i < in; i++){
            int inputInt = sc.nextInt();
            intArray[i] = inputInt;
        }
        System.out.println("Your sorted array: \n" + arrayToString(insertionSort(intArray, in)));
    }

    public static int[] insertionSort(int[] input, int n ) {
        int[] a = input;
        System.out.println("");
        //start at i = 1 since first element doesn't need to be compared to itself
        for(int i = 1; i < n; i++) {
            //start j as i-1 since we don't need to compare a[i] to itself
            for(int j = i-1; j >= 0 ; j--) {
                if(a[j] > a[j+1]) {
                    //if a[j] is bigger than the element to its right, swap them
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
        return a;
    }

    public static String arrayToString(int[] in){
        StringBuilder out = new StringBuilder();
        out.append("[");
        for(int i = 0; i < in.length; i++) {
            out.append(in[i]);
            out.append(",");
        }
        out.setLength(out.length() - 1);
        out.append("]");
        return out.toString();
    }
}
