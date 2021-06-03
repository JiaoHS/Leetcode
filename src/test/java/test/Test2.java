package test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther coraljiao
 * @date 2020/2/5 10:12
 * @description
 */
public class Test2 {
    public static void main(String[] args){
//        int[] num={4,5,1,6,2,7,3,8};
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
//            public int compare(Integer o1, Integer o2){
//                return o2.compareTo(o1);
//            }});
//        for (int i = 1; i < num.length; i++) {
//            queue.add(num[i]);
//        }
//        while (queue.iterator().hasNext()){
//            System.out.println(queue.poll());
//        }

        //用线程池来实现 ，3个线程加入线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            pool.submit(()-> System.out.println("AAAAAA"));
            pool.submit(()-> System.out.println("BBBBBB"));
            pool.submit(()-> System.out.println("CCCCCC"));
        }
        pool.shutdown();

        HashMap<String,String> map=new HashMap<>();
        map.put("","");
    }
}
