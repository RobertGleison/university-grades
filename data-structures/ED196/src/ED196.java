import java.util.LinkedList;
import java.util.Queue;

//public class ED196 {
//    public static void main(String[] args) {
//        Queue<String> a = new LinkedList<>();
//        Queue<String> b = new LinkedList<>();
//        Queue<String> q = new LinkedList<>();
//        q.offer("Luis");
//        q.offer("B");
//        q.offer("Pedro");
//        q.offer("A");
//        q.offer("Luisa");
//        q.offer("A");
//        q.offer("Joao");
//        q.offer("X");
//        q.offer("Jose");
//        q.offer("X");
//        q.offer("Miguel");
//        q.offer("B");
//        process(q, a, b);
////    }
//
//    //For use real Queue in java, change MyQueue for Queue, enqueue for offer, and dequeue for poll
//    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
//        String aux;
//        while(q.first()!=null){
//            aux = q.dequeue();
//            if (q.first().equals("A")) {
//                a.enqueue(aux);
//                q.dequeue();
//                continue;
//            }
//            if (q.first().equals("B")) {
//                b.enqueue(aux);
//                q.dequeue();
//                continue;
//            }
//            else {
//                if (a.size() > b.size())
//                    b.enqueue(aux);
//                else if (a.size() < b.size())
//                    a.enqueue(aux);
//                else {
//                    q.dequeue();
//                    continue;
//                }
//            }
//            q.dequeue();
//        }
//    }
//}

//    public static void process(Queue<String> q, Queue<String> a, Queue<String> b) {
//        String aux;
//        while(q.peek()!=null){
//            aux = q.poll();
//            if (q.peek().equals("A")) {
//                a.offer(aux);
//                q.poll();
//                continue;
//            }
//            if (q.peek().equals("B")) {
//                b.offer(aux);
//                q.poll();
//                continue;
//            }
//            else {
//                if (a.size() > b.size())
//                    b.offer(aux);
//                else if (a.size() < b.size())
//                    a.offer(aux);
//                else {
//                    q.poll();
//                    continue;
//                }
//            }
//            q.poll();
//        }
//    }