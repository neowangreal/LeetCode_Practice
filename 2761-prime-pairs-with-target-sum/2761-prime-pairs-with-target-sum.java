class Solution {
    
    static boolean[] sieve=new boolean[1000001];

    //function to build Prime Sieve 
    public void buildSieve(int n){
        for(int i=0;i<n;i++){
            if(i%2==0)
                sieve[i]=false;
            else
                sieve[i]=true;
        }
        sieve[2]=true;
        sieve[0]=false;
        sieve[1]=false;
        
        for(int i=3;i*i<=n;i+=2){
            if(sieve[i]==true){
                for(int j=i*i;j<=n;j+=i){
                    sieve[j]=false;
                }
            }
        }
    }
    public List<List<Integer>> findPrimePairs(int n) {
        
        List<List<Integer>> ans=new ArrayList<>();
        buildSieve(n);
        for(int i=2;i<=n/2;i++){
            if(sieve[i] && sieve[n-i]){
                List<Integer> a=new ArrayList<>();
                a.add(i);
                a.add(n-i);
                ans.add(a);
            }
        }
        return ans;
    }
}