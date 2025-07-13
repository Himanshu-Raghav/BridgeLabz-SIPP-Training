package sorting_package;

public class ProductPrices {
	
    // Main method
    public static void main(String[] args) {
        int[] prices = {499, 199, 999, 299, 799, 399};

        // Call Quick Sort
        quickSort(prices, 0, prices.length - 1);

        // Print sorted prices
        System.out.println("Sorted Product Prices:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }

    //Quick Sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
        	
            // Find pivot index using partition
            int pivotIndex = partition(arr, low, high);

            //Sort Elements
            quickSort(arr, low, pivotIndex - 1); 
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition function
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;       

        for (int j = low; j < high; j++) {
        	
            // If current element is less than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                
                //Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and pivot (arr[high])
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; 
    }
}

