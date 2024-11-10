import java.io.FilterOutputStream;

public class Queue{

    private int capacity = 5;
    private int[] queue = new int[capacity];
    private int front;
    private int rear;
    private int size;


    public void enQueue(int data){
        if(capacity - 1 == size) {
            expand();
        }
        queue[rear] = data;
        // To Make the array as if it is a circle
        rear = (rear + 1) % capacity;
        size++;

    }

    public int deQueue(){
        if(size <= (capacity /2) / 2){
            contract();
        }

        int data = queue[front];
        if(!isEmpty()) {
            // To Make the array as if it is a circle
            front = (front + 1) % capacity;
            size--;

        }
        else {
            System.out.println("Queue is empty");
        }
        return data;
    }

    private void expand(){
        capacity = capacity * 2;
        int[] q = new int[capacity];
        for(int i = 0; i < size; i++){
            q[i] = queue[(front + i) % 5];
        }
        queue = q;
    }

    private void contract(){
        capacity = capacity / 2;
        int[] q = new int[capacity];
        for(int i = 0; i < size; i++){
            q[i] = queue[(front + i) % 5];
        }
        queue = q;
        front = 0;
        rear = size;
    }

    public int peek(){
        return queue[front];
    }

    public void show(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else {
            System.out.print("Elements: ");
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front + i) % capacity] + " ");
                // I used %5 to make the method print the values of the circle array
            }
            System.out.println();
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        return size==capacity;
    }
}
