package main;

import controller.SearchSortController;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Search_Sort;
import view.SearchSortView;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean inputValid = false;

        while (!inputValid) {
            try {
                
                System.out.print("Enter the number of elements in the array: ");
                int n = scanner.nextInt();

                
                if (n <= 0) {
                    System.err.println("Invalid input. Please enter a positive number.");
                    continue;
                }

                int[] numbers = new int[n];
                System.out.println("Enter the elements of the array:");

                for (int i = 0; i < n; i++) {
                    boolean elementValid = false;

                    while (!elementValid) {
                        try {
                            System.out.print("Element " + (i + 1) + ": ");
                            numbers[i] = scanner.nextInt();
                            elementValid = true; 
                        } catch (InputMismatchException e) {
                            System.err.println("Invalid input. Please enter a valid number.");
                            scanner.nextLine();
                        }
                    }
                }

                Search_Sort model = new Search_Sort(numbers);
                SearchSortView view = new SearchSortView();
                SearchSortController controller = new SearchSortController(model, view);

                controller.processUserInput(scanner);

                inputValid = true;

            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("An unexpected error occurred.");
                e.printStackTrace();
                break;
            }
        }

        scanner.close();
    }
}
