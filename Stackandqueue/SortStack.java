package stack_queue_package;

import java.util.*;

public class SortStack {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
        	
        	//Pop
            int top = stack.pop(); 
            
            //Sort
            sortStack(stack);       
            
            //Insert
            insertInSortedOrder(stack, top);
        }
    }

    //Insert Element
    public static void insertInSortedOrder(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, value); 
            stack.push(temp);
        }
    }

    // Main method
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack:   " + stack);
    }
}

