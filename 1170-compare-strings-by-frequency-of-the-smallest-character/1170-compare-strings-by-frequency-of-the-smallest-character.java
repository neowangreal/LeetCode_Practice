class Solution {
    public int[] numSmallerByFrequency(String[] q, String[] w) {
        int count = 0;
        int res[] = new int[q.length];

        for(int i=0;i<q.length;i++){

            count =0;
            char ch[] = q[i].toCharArray();
            Arrays.sort(ch);
            char x = ch[0];
            int curr = 0;
            for(int a=0;a<ch.length;a++){
              if(ch[a]==x){
                curr++;
              }
            }

            for(int j=0;j<w.length;j++){

               int wcount = 0;
                char ch1[] = w[j].toCharArray();
                Arrays.sort(ch1);
                int y = ch1[0];

                for(char c:ch1){
                    if(c==y){
                        wcount++;
                    }
                }

                if(curr<wcount){
                    count++;
                }
               
            }

            res[i] = count;
        }

        return res;
    }
}