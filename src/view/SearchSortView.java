
package view;

import java.util.Scanner;

public class SearchSortView {
    public int getMenuChoice(Scanner scanner) {
        System.out.println("________MENU________:");
        System.out.println("1. Search");
        System.out.println("2. Sort");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public int getSearchChoice(Scanner scanner) {
        System.out.println("_________Search________:");
        System.out.println("1. Linear");
        System.out.println("2. Binary");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void printSearchResult(int index) {
        if (index == -1) {
            System.err.println("Error.");
        } else {
            System.out.println("Value was find at position: " + index);
        }
    }

    public int getSortChoice(Scanner scanner) {
        System.out.println("________ Sort ________:");
        System.out.println("1. Bubble");
        System.out.println("2. Quick");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void printSortedArray(int[] numbers) {
        System.out.println("Sorted array: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}

