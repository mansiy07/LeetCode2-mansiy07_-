import java.util.*;
class Solution {
    public int[] findSubtreeSizes(int[] parent,String s) {
        int n=parent.length;
        List<List<Integer>> tree=new ArrayList<>();
        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            tree.get(parent[i]).add(i);
        }
        int[] last=new int[26];
        Arrays.fill(last,-1);
        int[] prev=new int[n];
        int[] newParent=new int[n];
        int[] stack=new int[2*n+5];
        int top=0;
        stack[top++]=0;
        while(top>0){
            int u=stack[--top];
            if(u>=0){
                int c=s.charAt(u)-'a';
                prev[u]=last[c];
                newParent[u]=(prev[u]==-1)?parent[u]:prev[u];
                last[c]=u;
                stack[top++]=~u;
                for(int v:tree.get(u)){
                    stack[top++]=v;
                }
            }else{
                int node=~u;
                last[s.charAt(node)-'a']=prev[node];
            }
        }
        List<List<Integer>> newTree=new ArrayList<>();
        for(int i=0;i<n;i++){
            newTree.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            newTree.get(newParent[i]).add(i);
        }
        int[] size=new int[n];
        Arrays.fill(size,1);
        int[] order=new int[n];
        top=0;
        int count=0;
        stack[top++]=0;
        while(top>0){
            int u=stack[--top];
            order[count++]=u;
            for(int v:newTree.get(u)){
                stack[top++]=v;
            }
        }
        for(int i=count-1;i>0;i--){
            int u=order[i];
            size[newParent[u]]+=size[u];
        }
        return size;
    }
}