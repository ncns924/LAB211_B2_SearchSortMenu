package controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.Search_Sort;
import view.SearchSortView;

public class SearchSortController {
    private Search_Sort model;
    private SearchSortView view;

    public SearchSortController(Search_Sort model, SearchSortView view) {
        this.model = model;
        this.view = view;
    }

    public void processUserInput(Scanner scanner) {
        while (true) {
            try {
                int choice = view.getMenuChoice(scanner);

                switch (choice) {
                    case 1:
                        searchMenu(scanner);
                        break;
                    case 2:
                        sortMenu(scanner);
                        break;
                    case 0:
                        System.out.println("Exit.");
                        System.exit(0);
                    default:
                        System.out.println("Error. Invalid choice. Enter again!");
                }

                System.out.println();
            } catch (Exception e) {
                System.err.println("An unexpected error occurred.");
                e.printStackTrace();
                System.out.println("Please try again.");
            }
        }
    }

    private void searchMenu(Scanner scanner) {
        int[] numbers = model.getNumbers();
        int choice;

        while (true) {
            try {
                choice = view.getSearchChoice(scanner);
                break;
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }

        switch (choice) {
            case 1:
                System.out.print("Enter value: ");
                int linearSearchValue;

                while (true) {
                    try {
                        linearSearchValue = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine();
                    }
                }

                int linearSearchIndex = model.linearSearch(linearSearchValue);
                view.printSearchResult(linearSearchIndex);
                break;
            case 2:
                System.out.println("Binary search requires a sorted array.");
                System.out.println("Do you want to sort the array before performing binary search?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int sortChoice;

                while (true) {
                    try {
                        sortChoice = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine();
                    }
                }

                if (sortChoice == 1) {
                    model.bubbleSort();
                    view.printSortedArray(numbers);
                }

                System.out.print("Enter value: ");
                int binarySearchValue;

                while (true) {
                    try {
                        binarySearchValue = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.err.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine();
                    }
                }

                int binarySearchIndex = model.binarySearch(binarySearchValue);
                view.printSearchResult(binarySearchIndex);
                break;
            case 0:
                return;
            default:
                System.out.println("Error. Invalid choice. Enter again.");
        }
    }

    private void sortMenu(Scanner scanner) {
        int[] numbers = model.getNumbers();
        int choice;

        while (true) {
            try {
                choice = view.getSortChoice(scanner);
                break;
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        switch (choice) {
            case 1:
                model.bubbleSort();
                view.printSortedArray(numbers);
                break;
            case 2:
                model.quickSort(0, numbers.length - 1);
                view.printSortedArray(numbers);
                break;
            case 0:
                return;
            default:
                System.out.println("Error. Invalid choice. Enter again.");
        }
    }
}
