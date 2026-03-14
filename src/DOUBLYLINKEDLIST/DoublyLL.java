package DOUBLYLINKEDLIST;
class Node{
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
    }
    
}

class MyDouble{
    Node first;
    Node last;
    
    public void addFirst(int newData){
        Node newNode = new Node(newData);
        if(first == null){
            first = last = newNode;
        }else{
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
    }
    public void addLast(int newData){
        Node newNode = new Node(newData);
        if(first == null){
            first = last = newNode;
        }else{
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
    }
    public void add(int index, int newData){
        Node newNode = new Node(newData);
        Node current = first;
        
        for(int i=0; i<index; i++){
            current = current.next;
        }
        current.prev.next = newNode;
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev = newNode;

        
    }
    public void removeLast(){
        last = last.prev;
        last.next = null;
    }
    public void removeFirst(){
        first = first.next;
        first.prev = null;
    }
    public void remove(int key){
        Node current = first;
        //asumsi linkedlist tidak kosong
        if(first.data == key){
            removeFirst();
        }else{
            while(current != null){
                if(current.next.data == key){
                    current.next = current.next.next;
                    if(key == last.data)
                        last = current;
                    break;
                }
                current = current.next;
            }
        }
    }
    public void printAll(){
        Node current = first;
        while(current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
}

public class DoublyLL {
    public static void main(String[] args) {
        MyDouble mm = new MyDouble();
        mm.addFirst(40);
        mm.addFirst(30);
        mm.addFirst(20);
        mm.addFirst(10);
        mm.addLast(50);
        mm.addLast(60);
        mm.addLast(70);
        mm.addLast(80);
        
        mm.remove(10);
        mm.printAll();
    }
}
