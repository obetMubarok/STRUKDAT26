package SINGLELINKEDLIST;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
    
}

class MyLinkedList{
    Node first;
    Node last;
    
    public boolean isEmpty(){
        return first==null;
    }
    
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            newNode.next = first;
            first = newNode;
        }
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            first=last=newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
    }
    public void removeFirst(){
        first = first.next;
    }
    public void printAll(){
        Node current = first;
        while(current !=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
    public boolean find(int key){
        Node current = first;
        while(current != null){
            if(current.data == key)
                return true;
            current = current.next;
        }
        return false;
    }
    public void remove(int key){
        Node current = first;
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
    public void reset(){
        first=null;
        last = null;
    }
    public int getIndex(int key){
        Node current = first;
        int index = 0;
        while(current != null){
            if(key == current.data)
                break;
            index++;
            current = current.next;
        }
        return index;
    }
}

public class NewClass {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        
        ll.addFirst(50);
        ll.addFirst(40);
        ll.addFirst(30);
        ll.addFirst(20);
        ll.addFirst(10);
        ll.addLast(60);
        
        System.out.println(ll.getIndex(50));
        
    }
}
