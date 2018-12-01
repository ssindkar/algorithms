package algorithms.coursera;

public class ReverseQueue {
    public static void main(String args[]) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        reverse(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    private static void reverse(Queue<Integer> q) {
        if(q.isEmpty()){
            return;
        }
        Integer i = q.dequeue();
        reverse(q);
        q.enqueue(i);
    }
}


