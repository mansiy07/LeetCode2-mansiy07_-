
class Solution {
    public int[] relativeSortArray(int[] arr1,int[] arr2) {
        int[] freq=new int[1001];
        for(int num:arr1) freq[num]++;
        int k=0;
        for(int num:arr2){
            while(freq[num]>0){
                arr1[k++]=num;
                freq[num]--;
            }
        }
        for(int i=0;i<1001;i++){
            while(freq[i]>0){
                arr1[k++]=i;
                freq[i]--;
            }
        }
        return arr1;
    }
}
