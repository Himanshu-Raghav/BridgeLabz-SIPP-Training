package stack_queue_package;

import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int n = prices.length;
        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
        	
            // Pop elements from stack while current price is higher
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty all previous prices were smaller
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index onto stack
            stack.push(i);
        }

        // Print result
        System.out.print("Span: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}

