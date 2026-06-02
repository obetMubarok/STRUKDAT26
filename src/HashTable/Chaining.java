package HashTable;

import java.util.LinkedList;

class MyhashChaining{
    LinkedList<Integer>[] data;
    int size;
    public MyhashChaining(int size) {
        this.size = size;
        data = new LinkedList[size];
        for(int i=0;i<size;i++)
            data[i] = new LinkedList<>();
    }
    public int hashFunction(int key){
        return key % size;
    }
    public void insert(int key){
        int index = hashFunction(key);
        data[index].addLast(key);
    }
    public void print(){
        for(int i=0; i<size; i++)
            System.out.println(i+" "+data[i]);
    }
    public boolean find(int key){
        int index = hashFunction(key);
        return data[index].contains(key);
    }
    public void remove(int key){
        int index = hashFunction(key);
        data[index].removeFirstOccurrence(key);
    }
    
}
public class Chaining {
    public static void main(String[] args) {
        MyhashChaining mc = new MyhashChaining(10);
        mc.insert(10);
        mc.insert(20);
        mc.insert(30);
        mc.insert(11);
        mc.insert(99);
        //mc.remove(99);
        //System.out.println(mc.find(11));
        
        mc.print();
        
    }
}
