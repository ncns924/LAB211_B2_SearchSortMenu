
package model;

import java.util.Arrays;


public class Search_Sort {
    private int[] numbers;

    public Search_Sort(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int linearSearch(int value) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public int binarySearch(int value) {
    boolean isSorted = isSorted(numbers);

    if (!isSorted) {
        Arrays.sort(numbers);
        System.out.println("Array sorted using Arrays.sort().");
    }

    int low = 0;
    int high = numbers.length - 1;

    while (low <= high) {
        int mid = (low + high) / 2;

        if (numbers[mid] == value) {
            return mid;
        } else if (numbers[mid] < value) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return -1;
}

private boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        if (arr[i - 1] > arr[i]) {
            return false;
        }
    }
    return true;
}

    public void bubbleSort() {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // Hoán đổi các phần tử numbers[j] và numbers[j + 1]
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = numbers[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (numbers[j] < pivot) {
                i++;

                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }

        int temp = numbers[i + 1];
        numbers[i + 1] = numbers[high];
        numbers[high] = temp;

        return i + 1;
    }
}
