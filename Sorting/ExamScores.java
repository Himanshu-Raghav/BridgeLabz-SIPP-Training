package sorting_package;

public class ExamScores {

    //Selection Sort 
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        //One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            //Find the minimum element in remaining array
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            //Swap the minimum element with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    //Main method
    public static void main(String[] args) {
        int[] examScores = {88, 75, 92, 68, 79, 85};

        System.out.println("Original Exam Scores:");
        for (int score : examScores)
            System.out.print(score + " ");

        selectionSort(examScores);

        System.out.println("\n\nSorted Exam Scores in Ascending Order :");
        for (int score : examScores)
            System.out.print(score + " ");
    }
}

