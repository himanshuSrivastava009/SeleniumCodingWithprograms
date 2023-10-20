package com.qa.selenium.driver;


class Queue{

    int x;
    boolean is_value_Stored=false;
   synchronized public void store(int x) {
        try {
            if (is_value_Stored == false) {
                this.x = x;
                System.out.println("Produced " + x);
                is_value_Stored = true;
                notify();
            } else {
                wait();
            }
        }
        catch (InterruptedException e){

        }
    }

   synchronized public void retrive(){

      // boolean is_value_Stored = false;
       try {
           if (is_value_Stored == true) {
               System.out.println("Consumed " + x);
               is_value_Stored = false;
               notify();
           } else {
               wait();
           }
       }
       catch (InterruptedException e){

       }
    }
}
class Producer extends Thread{

    Queue q;
    Producer(Queue q){
        this.q=q;
    }
    @Override
    public void run(){
        int i = 1;
        for(;;) {
            q.store(i++);
        }
    }
}

class Consumer extends Thread{

    Queue q;
    Consumer(Queue q){
        this.q=q;
    }
    @Override
    public void run(){

        for(;;){

            q.retrive();
        }
    }
}
public class ConsumerProducerproblem {



    public static void main(String[] args) {
        Queue queue = new Queue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }
}
