package longChallenge_august;

import java.util.*;
import java.io.*;

public class test {
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
            long n = sc.nextInt();
            long m = sc.nextInt();
            long value =0;

            long[] numbers = new long[(int)n+1];

            for(int j=0; j<=n; j++){
                numbers[j] = 0;
            }

            Pair[] set = new Pair[(int) m];
            for (int i = 0; i < m; i++) {
                set[i] = new Pair(sc.nextLong(), sc.nextLong());
            }
            // System.out.println();

            // for (int i = 0; i < m; i++) {
            //     System.out.println(set[i].x + " " + set[i].y);
            // }
            // System.out.println();
            Arrays.sort(set);

            for(int i=0; i<m; i++){
                for(int j=1; j<=n; j++){
                    if(j%set[i].y !=0 && numbers[j] == 0 ){
                        numbers[j] = set[i].x;
                    }
                }
            }

            System.out.println();
            Map<Long ,Long> collect = new HashMap<>();

            for(int i=0; i<m; i++){
                for(int j=1; j<=n; j++){
                    if(j%set[i].y !=0 && numbers[j] == set[i].x ){
                        if(collect.containsKey(set[i].x)){
                            collect.put(set[i].x, collect.get(set[i].x)+1);
                        } else {
                            collect.put(set[i].x, (long)1);
                        }
                        
                    }
                }
            }
            numbers[0] =0;

            for(Map.Entry<Long,Long> entry : collect.entrySet()){
                System.out.println(entry.getKey()+" "+ entry.getValue());
            }



            for(long x : numbers){
                value += x;
            }
            System.out.println(value);

        }
    }

    static class Pair implements Comparable<Pair> {
        long x, y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            // TODO Auto-generated method stub

            if (this.x == other.x)
                return 0;
            else if (this.x < other.x)
                return 1;
            else
                return -1;
        }
    }

}
