public class ED197 {
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
        MyQueue<Integer> newQueue = new LinkedListQueue<>();
        int size = a.size() + b.size();
        for (int i = 0; i < size; i++) {
            if(a.isEmpty()){
                newQueue.enqueue(b.dequeue());
                continue;
            }
            else if (b.isEmpty()){
                newQueue.enqueue(a.dequeue());
                continue;
            }
            else{
                if (a.first() <= b.first())
                    newQueue.enqueue(a.dequeue());
                else newQueue.enqueue(b.dequeue());
            }}
        return newQueue;
    }
}
//    public static void main(String[] args) {
//        Queue<Integer> a = new LinkedList<>();
//        Queue<Integer> b = new LinkedList<>();
//        a.offer(10);
//        a.offer(20);
//        a.offer(30);
//        a.offer(40);
//        a.offer(50);
//        a.offer(60);
//        a.offer(70);
//        b.offer(1);
//        b.offer(2);
//        b.offer(3);
//        b.offer(44);
//        b.offer(50);
//        b.offer(60);
//        b.offer(70);
//        b.offer(90);
//        Queue<Integer> newQueue = merge(a,b);
//
//
//    }
//
//    public static Queue<Integer> merge(Queue<Integer> a, Queue<Integer> b) {
//        Queue<Integer> newQueue = new LinkedList<>();
//        int size = a.size() + b.size();
//        for (int i = 0; i < size; i++) {
//            if(a.isEmpty()){
//                newQueue.offer(b.poll());
//                continue;
//            }
//            else if (b.isEmpty()){
//                newQueue.offer(a.poll());
//                continue;
//            }
//            else{
//            if (a.peek() <= b.peek())
//                newQueue.offer(a.poll());
//             else newQueue.offer(b.poll());
//        }}
//        return newQueue;
//    }
//
//
//}
