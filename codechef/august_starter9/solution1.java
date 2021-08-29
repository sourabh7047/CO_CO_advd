package august_starter9;

import java.util.*;

import java.io.*;

public class solution1 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public char nextChar() {
            return next().toCharArray()[0];
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String str = sc.next();

            ArrayList<Integer> arr = new ArrayList<>();

            // output
            long Gcount = 0;
            long diff=0;
            int once = 1;
            int extra =0;

            for (int i = 0; i < str.length(); i++) {
                if (Character.compare(str.charAt(i), '1') == 0) {
                    arr.add(i);
                }
            }
            if(arr.size()==0){
                System.out.println(0);
            }else if(arr.size()==1){
                System.out.println(1);
            }else {
                for(int i=1;i<arr.size();i++){
                    diff= arr.get(i)-arr.get(i-1)+extra;
                    if(diff<=k){
                        once+=1;
                        extra = 0;
                    } else if(diff == k+1){
                        once+=1;
                        extra =1;
                    } else {
                        Gcount +=1;
                        extra = 0;
                        once = 1;
                    }
                }
                
               Gcount+=1;
               System.out.println(Gcount);
            }

            
        }

    }
}
