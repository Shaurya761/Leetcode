class Solution {
    public void reverseString(char[] s) {
        reverseHelper(s, 0);

    }
    private void reverseHelper(char[] s, int i) {
            if(i >= s.length/2) return;

            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;

            reverseHelper(s, i + 1);   
    }
}