package QUEUE;

class MyQueue{
    int front;
    int rear;
    int[] array;
    int nItem;
    int maxSize;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        rear = -1;
        front = 0;
        nItem = 0;
        array = new int[maxSize];
    }
    public boolean isFull(){
        return nItem == maxSize;
    }
    public boolean isEmpty(){
        return nItem == 0;
    }
    public void insert(int data){
        if(!isFull()){
            if(rear == maxSize-1)
                rear = -1;
            array[++rear] = data;
            nItem++;
        }
    }
    public void remove(){
        if(!isEmpty()){
            front++;
            nItem--;
        }
    }
    public void print(){
        for(int i=front; i<=rear; i++)
            System.out.print(array[i]+" ");
    }
    public void reset(){
        rear = -1;
        front = 0;
        nItem = 0;
    }
    public int peekRear(){
        return array[rear];
    }
    public void leave(int index){
        for(int i=index;i<rear ;i++){
            array[i] = array[i+1];
        }
        rear--;
        nItem--;
    }
}
public class DemoQueue {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue(10);
        mq.insert(10);
        mq.insert(20);
        mq.insert(30);
        mq.insert(40);
        mq.insert(50);
        mq.insert(60);
        mq.insert(70);
        mq.insert(80);
        mq.insert(90);
        mq.insert(100);
        
        
        
        mq.leave(2);
        mq.print();
        
        
    }
}
