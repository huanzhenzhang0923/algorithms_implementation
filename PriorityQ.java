import java.util.Arrays;

public class PriorityQ {
    private static final int DEFAULT_INITIAL_CAPACITY=11;
    private int[] queue;
    private int size=0;

    public PriorityQ() {
        queue=new int[DEFAULT_INITIAL_CAPACITY];
    }

    private void grow(){

    }

    public void add(int val){
        int i=size;
        siftUp(i,val);
        size++;
    }



    public int peek() {
        return size==0? null:queue[0];
    }

    public int poll() {
        int val=queue[0];
        queue[0]=queue[size-1];
        siftDown(0);
        size--;
        return val;
    }


    public void remove(int val) {
        for (int i=0;i<size;i++) {
            if (queue[i]==val) {
                removeAt(i);
            }
        }
        return;
    }

    private void removeAt(int i) {
        int temp=queue[i];
        queue[i]=queue[size-1];
        siftDown(i);
        size--;
        return;
    }

    private void siftUp(int i, int val) {
        while (i>0) {
            int parent=i>>1;
            if (queue[parent]>val) {
                break;
            }
            queue[i]=queue[parent];
            i=parent;
        }
        queue[i]=val;
        return;
    }

    private void siftDown(int i) {
        int val=queue[i];
        while (i<size/2) {
            int child=(i<<1)+1;
            int right=child+1;
            if (right<size && queue[right]>queue[child]) {
                child=right;
            }
            if (queue[child]<val) {
                break;
            }
            queue[i]=queue[child];
            i=child;
        }
        queue[i]=val;
        return;
    }


    public int size(){
        return size;
    }

    public String toString(){

        return Arrays.toString(Arrays.copyOf(queue,size));
    }



}

class testcase {
    public static void main(String[] args) {
        PriorityQ pq=new PriorityQ();
        int[] addVal={5,2,9,7,10,8};
        for (int i=0;i<addVal.length;i++) {
            pq.add(addVal[i]);
        }
        System.out.println(pq.toString());
        pq.remove(9);
        System.out.println(pq.toString());
    }
}
