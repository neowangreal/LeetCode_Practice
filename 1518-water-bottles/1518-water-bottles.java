class Solution {
    public int numWaterBottles(int a, int b) {
        int sum=0;
        int empty=0;
        int filled=a;
        while(filled!=0)
        {
            sum+=filled;
            empty=filled+empty%b;
           filled=empty/b;
           
        }
        return sum;
    }
}