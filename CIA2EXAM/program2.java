package CIA2EXAM;
import java.util.Random;
//import java.util.*;

import java.util.Random;

class OrderManager {
    private final int[] orders=new int[10]; //array with maximum queue size is 10
    private int currentSize = 0;
    private int front = 0; //queue front pointer
    private int rear = 0; //queue back
    private int totalOrdersCompleted = 0; //making the total order completed
    private static final int TOTAL_ORDERS = 15;    // Total orders to process


    // method for waiter to place the order using synchronized
    public synchronized void placeOrder(int orderId) {
        // wait if  queue is full
        while (currentSize >= 10) { //if it last queue
            try {
                System.out.println("order queue full! waiter needs to waiting");
                wait();
            } catch (Exception e) {
                Thread.currentThread().interrupt(); //this will interrupt the thread
            }
        }

        orders[rear] = orderId;
        rear = (rear + 1) % 10;
        currentSize++;
        System.out.println("waiter placed Order #" + orderId + " (now queue size is:" + currentSize + ")");
        notify();
    }

    // Method for chef to prepare order
    public synchronized int getOrderToPrepare() {
        // wait if buffer is empty
        while (currentSize == 0) {
            try {
                System.out.println("Order queue empty! Chef need to wait");
                wait();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }

        int orderId = orders[front];
        front = (front + 1) % 10;
        currentSize--;
        totalOrdersCompleted++;
        notify();
        return orderId;
    }

    public boolean isComplete() {
        return totalOrdersCompleted >= TOTAL_ORDERS;
    }
}

class Chef implements Runnable {
    private OrderManager orderManager;
    private Random random = new Random();

    public Chef(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public void run() {
        while (!orderManager.isComplete()) { //boolean
            int orderId = orderManager.getOrderToPrepare();
            if (orderId != -1) {
                try {
                    // Simulate cooking time (1-3 seconds)
                    int cookTime = random.nextInt(2000) + 1000;
                    Thread.sleep(cookTime);
                    System.out.println("Chef prepared Order #" + orderId + " in " + cookTime/1000.0 + " seconds");
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("chef finished all orders!");
    }
}

class Waiter implements Runnable {
    private OrderManager orderManager;
    private Random random = new Random();

    public Waiter(OrderManager orderManager) {
        this.orderManager = orderManager;
    }
    //overriding here
    public void run() {
        for (int i = 1; i <= 15; i++) {
            try {
                // time blw placing orders (1-2 seconds)
                Thread.sleep(random.nextInt(1000) + 1000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            orderManager.placeOrder(i);
        }
        System.out.println("waiter finished taking all orders!");
    }
}

public class program2 {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();

        Thread chefThread = new Thread(new Chef(orderManager));
        Thread waiterThread = new Thread(new Waiter(orderManager));

        System.out.println("restaurant is opening...");
        waiterThread.start();
        chefThread.start();

        try {
            waiterThread.join();
            chefThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("restaurant is closed!");
    }
}

