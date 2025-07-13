package sorting_package;

public class JobApplicantsSalary {
	
    //Main method
    public static void main(String[] args) {
        int[] salaries = {50000, 30000, 70000, 40000, 60000};

        heapSort(salaries);

        //Print sorted salary
        System.out.println("Sorted salaries in ascending order:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }

    //Heap Sort 
    public static void heapSort(int[] arr) {
        int n = arr.length;

        //Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
        	
            //Swapping
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    //Heapify Function 
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;        
        int left = 2 * i + 1;    
        int right = 2 * i + 2;   

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}

