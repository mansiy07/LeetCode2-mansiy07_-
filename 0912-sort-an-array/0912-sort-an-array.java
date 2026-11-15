
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    void mergeSort(int[] nums,int l,int r){
        if(l>=r) return;
        int mid=l+(r-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }
    void merge(int[] nums,int l,int mid,int r){
        int[] temp=new int[r-l+1];
        int i=l,j=mid+1,k=0;
        while(i<=mid&&j<=r){
            if(nums[i]<=nums[j]) temp[k++]=nums[i++];
            else temp[k++]=nums[j++];
        }
        while(i<=mid) temp[k++]=nums[i++];
        while(j<=r) temp[k++]=nums[j++];
        for(i=0;i<temp.length;i++){
            nums[l+i]=temp[i];
        }
    }
}
