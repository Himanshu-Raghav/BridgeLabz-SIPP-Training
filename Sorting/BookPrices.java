package sorting_package;

public class BookPrices {

    //Merge Sort 
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            //Sort left half
            mergeSort(prices, left, mid);

            //Sort right half
            mergeSort(prices, mid + 1, right);

            //Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    //Merge function
    public static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArr[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = prices[mid + 1 + j];

        int i = 0, j = 0, k = left;

        //Merge the two arrays
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k] = leftArr[i];
                i++;
            } else {
                prices[k] = rightArr[j];
                j++;
            }
            k++;
        }

        //Copy remaining elements
        while (i < n1) {
            prices[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            prices[k] = rightArr[j];
            j++;
            k++;
        }
    }

    //Main method
    public static void main(String[] args) {
        int[] bookPrices = {450, 150, 300, 200, 100, 350};

        System.out.println("Original Book Prices:");
        for (int price : bookPrices)
            System.out.print(price + " ");

        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("\n\nSorted Book Prices:");
        for (int price : bookPrices)
            System.out.print(price + " ");
    }
}
