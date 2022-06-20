package com.stackroute.hackerrankchallenge;

import java.util.Scanner;
import java.util.Stack;

public class TaleOfTwoStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<>();
        Stack<T> stackOldestOnTop = new Stack<>();

        public void push(T value) {
            stackNewestOnTop.push(value);
        }

        public void pop() {
            prepareStackOldestOnTop();
            stackOldestOnTop.pop();
        }

        public T peek() {
            prepareStackOldestOnTop();
            return stackOldestOnTop.peek();
        }

        private void prepareStackOldestOnTop() {
            if (stackOldestOnTop.empty()) {
                while (!stackNewestOnTop.empty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        MyQueue<Integer> queue = new MyQueue<Integer>();

        for (int i = 0; i < n; i++) {
            int op = in.nextInt();
            if (op == 1) {
                queue.push(in.nextInt());
            } else if (op == 2) {
                queue.pop();
            } else if (op == 3) {
                System.out.println(queue.peek());
            }
        }
        in.close();
    }
}


