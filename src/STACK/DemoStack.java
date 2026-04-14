package STACK;

class MyStack{
    int[] array;
    int top;
    int maxSize;
    int size;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        size = 0;
        array = new int[maxSize];
    }
    public void push(int data){
        array[++top] = data;
        size++;
    }
    public int pop(){
        size--;
        return array[top--];
    }
    public boolean isFull(){
        return size == maxSize;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int get(int index){
        return array[index];
    }
    public void set(int index, int data){
        array[index] = data;
    }
    public void print(){
        for(int i=0; i<=top; i++ )
            System.out.print(array[i]+" ");
    }
    
}
public class DemoStack {
    public static void main(String[] args) {
       MyStack ms = new MyStack(10);
       ms.push(10);
       ms.push(20);
       ms.push(30);
       ms.push(40);
       
       ms.pop();
       ms.print();
    }
}
