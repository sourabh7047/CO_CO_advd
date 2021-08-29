// You are given a sequence A1,A2,…,AN which contains pairwise distinct elements and a sequence B1,B2,…,BN, which also contains pairwise distinct elements (but not necessarily distinct from elements of A). For each valid i, 1≤Ai,Bi≤2⋅N.

// You may rotate B as many times as you want. A rotation consists of moving the first element of the sequence to the end. Afterwards, let's define a sequence C1,C2,…,CN as Ci=(Ai+Bi)%N for each valid i.

// There are N possible sequences C. Find the lexicographically smallest of these sequences.

// Note: A sequence x is lexicographically smaller than a different sequence y if xi < yi, where i is the smallest valid index where the sequences x and y differ.

// Input Format
// The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
// The first line of each test case contains a single integer N.
// The second line contains N space-separated integers A1,A2,…,AN.
// The third line contains N space-separated integers B1,B2,…,BN.
// Output Format
// For each test case, print a single line containing N space-separated integers C1,C2,…,CN denoting the lexicographically smallest sequence.

// Constraints
// 1≤T≤100
// 1≤N≤105
// 1≤Ai,Bi≤2⋅N for each valid i
// the sum of N over all test cases does not exceed 2⋅105

package codechef_july_lunchtime;

import java.util.*;
import java.io.*;

public class solution2 {
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

    public static void print(ArrayList<Integer> arr, PrintWriter out) {
        for (int x : arr) {
            out.print(x + " ");
        }
        out.println();
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] A = new int[n];
            int[] B = new int[n];

            // filling up the array
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
                A[i] = A[i] % n;
            }
            for (int i = 0; i < n; i++) {
                B[i] = sc.nextInt();
                B[i] = B[i] % n;
            }

            // finding the min
            int[] f = new int[n];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                f[i] =( A[0] + B[i] )% n;
                min = Math.min(f[i], min);
            }

            // storing all the min positions
            ArrayList<Integer> minimum = new ArrayList<>();
            for(int i=0;i <n; i++){
                if(f[i] == min){
                    minimum.add(i);
                }
            }

            // storing all the possible arraylist with min start
            ArrayList<ArrayList<Integer>> nsort = new ArrayList<>();
            for(int x : minimum){
                    ArrayList<Integer> al = new ArrayList<>();
                    for(int i=0; i<n; i++){
                        al.add((A[i]+ B[(i+x)%n])%n);
                    }
                    nsort.add(al);
            }

            // sorting all the arraylist
            Collections.sort(nsort, (x,y)->{
                for(int g=0; g<n; g++){
                    if(x.get(g)<y.get(g)) return -1;
                    if(x.get(g)>y.get(g)) return 1;
                }
                return 0;
            });

            print(nsort.get(0), out);
        }
        out.flush();
    }
}
