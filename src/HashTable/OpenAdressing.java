package HashTable;
class Myhash{
    int[] data;
    int size;

    public Myhash(int size) {
        this.size = size;
        data = new int[size];
    }
    public int hashFunction(int key){
        return key % size;
    }
    public void insert(int key){
        int index = hashFunction(key);
        data[index] = key;
    }
    public void print(){
        for(int i=0; i<size; i++)
            System.out.print(data[i]+" ");
    }
    public void remove(int key){
        int index = hashFunction(key);
        data[index] = 0;
    }
    public boolean find(int key){
        int index = hashFunction(key);
        if(data[index]==key)
            return true;
        return false;
    }
}
public class OpenAdressing {
    public static void main(String[] args) {
        Myhash mh = new Myhash(10);
        mh.insert(10); //0
        mh.insert(12); //2
        mh.remove(12);
        System.out.println(mh.find(11));
        
        mh.print();
        
    }
}
