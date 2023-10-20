package com.qa.selenium.driver;

public class UserThreadAndDaemonThread extends Thread{

    @Override
    public  void run(){

       if((Thread.currentThread().getName().equalsIgnoreCase("UserThread1"))){

           userThread1();
        }
       else if ((Thread.currentThread().getName().equalsIgnoreCase("userthread2"))){

            userThread2();
        }
        else if ((Thread.currentThread().getName().equalsIgnoreCase("DaemonThread"))){

            daemonThread();
        }
    }

    public void userThread1(){
        for(int i=0;i<10;i++) {
            System.out.println("!!!!!thread1 !!!!!!" + i);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException exception){

                System.out.println(exception);
            }
            System.out.println("Thread 1 Finished");
        }
    }


    public void userThread2(){
        for(int i=0;i<10;i++) {
            System.out.println("------thread2-----" + i);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException exception){

                System.out.println(exception);
            }
            System.out.println("Thread 2 Finished");
        }
    }

    public void daemonThread(){
        for(;;) {
            System.out.println("*****daemonThread******");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException exception){

                System.out.println(exception);
            }
            System.out.println("Daemon Thread  Finished");
        }
    }
    public static void main(String[] args) {

        UserThreadAndDaemonThread utd = new UserThreadAndDaemonThread();
        Thread ut1 = new Thread(utd);
        Thread ut2 = new Thread(utd);
        Thread dt = new Thread(utd);
        ut1.setName("UserThread1");
        ut2.setName("UserThread2");
        dt.setName("DaemonThread");
        dt.setDaemon(true);
        ut1.start();
        ut2.start();
        dt.start();
    }
}
