import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class HeapSort {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        buildMaxHeap(nums);
        for (int i=n-1;i>0;i--) {
            maxHeapify(nums,0,i+1);
            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
        }
        return nums;
    }

    private void buildMaxHeap(int[] nums) {
        int n=nums.length;
        for (int i=n/2;i>=0;i--) {
            maxHeapify(nums,i,n);
        }
    }

    private void maxHeapify(int[] nums, int start, int end) {
        int init=nums[start];
        while (start<end/2) {
            int child=(start<<1)+1;
            int right=child+1;
            if (right<end && nums[right]>nums[child]) {
                child=right;
            }
            if (init>nums[child]){
                break;
            }
            nums[start]=nums[child];
            start=child;

        }
        nums[start]=init;
    }
}
