

import java.io.*;

public class Main {
      static final int MOD = 1000000007;
      static long [] fact;
static void Factorial(int n) {
    fact=new long[n+1];
    fact[0]=1;
    for (int i = 1; i <=n ; i++) {
        fact[i]=(fact[i-1]*i)%MOD;
    }
}
static long modInverser(long n, int mod) {
   return  power(n,mod-2,mod);
}
static long power(long base, long exp, int mod) {
  long res=1;
  while (exp > 0) {
      if ((exp & 1) == 1){
          res = (res * base) % mod;
      }
      base = (base * base) % mod;
      exp >>= 1;
  }
  return res;
}
static  long binomial(int n, int k) {
    if (k <0||k>n) return 0;
    if (k==0||k==n) return 1;
    return  fact[n]*modInverser(fact[k],MOD )%MOD*modInverser(fact[n-k],MOD)%MOD;
}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String [] input = br.readLine().split(" ");
       int n = Integer.parseInt(input[0]);
       int k = Integer.parseInt(input[1]);
       Factorial(n);
       long res=binomial(n,k);
       System.out.println(res);
    }
}
