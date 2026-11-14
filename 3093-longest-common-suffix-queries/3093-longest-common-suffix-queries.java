class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int index;
        int len;   
        TrieNode(int index, int len) {
            this.index = index;
            this.len = len;
        }
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int minLen = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < minLen) {
                minLen = wordsContainer[i].length();
                minIndex = i;
            }
        }
        TrieNode root = new TrieNode(minIndex, minLen);
        for (int i = 0; i < wordsContainer.length; i++) {
            String s = wordsContainer[i];
            TrieNode node = root;
            for (int j = s.length() - 1; j >= 0; j--) {
                int c = s.charAt(j) - 'a';
                if (node.child[c] == null) {
                    node.child[c] = new TrieNode(i, s.length());
                }
                node = node.child[c];
                if (s.length() < node.len) {
                    node.len = s.length();
                    node.index = i;
                }
            }
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String q = wordsQuery[i];
            TrieNode node = root;
            for (int j = q.length() - 1; j >= 0; j--) {
                int c = q.charAt(j) - 'a';
                if (node.child[c] == null) {
                    break;
                }
                node = node.child[c];
            }
            ans[i] = node.index;
        }
        return ans;
    }
}