package ua.genericcollection;

import java.util.*;

public class CollectionQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(10);
        queue.offer(-11);
        queue.offer(0);
        queue.offer(6);
        queue.offer(-6);
        queue.offer(7);
        queue.offer(88);
        queue.offer(71);
        queue.offer(15);
        queue.offer(8);
        System.out.println(queue);
        System.out.println(queue.element());
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);








        System.out.println("------------------------------");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addAll(queue);
        System.out.println(deque);
        deque.addFirst(100);
        deque.addLast(-100);
        System.out.println(deque);
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque);
        deque.offerFirst(101);
        deque.offerFirst(102);
        deque.offerLast(66);
        System.out.println("--" + deque);
        deque.push(56);
        System.out.println(" push 56 " + deque);
        deque.push(57);
        System.out.println(" push 57 " + deque);
        deque.push(58);
        System.out.println(" push 58 " + deque);
        System.out.println(deque.pop());
        System.out.println(" pop " + deque);
        System.out.println(deque.pop());
        System.out.println(" pop " + deque);













    }

}
