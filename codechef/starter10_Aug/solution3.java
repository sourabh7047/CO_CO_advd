package starter10_Aug;

import java.util.*;
import java.io.*;

public class solution3 {
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
        FastReader sc=new FastReader();
        int t =sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long temp,temp2;
            long count=0;
            
            long[] arrA = new long[n];
            long[] arrB = new long[n];

            for(int i=0;i<n; i++){
                arrA[i] = sc.nextLong();
            }
            for(int i=0;i<n; i++){
                arrB[i] = sc.nextLong();
            }

            // 
            long val = Integer.MIN_VALUE;
            
            temp = arrA[0]&arrB[1];
            if(temp>val){
                if(val == Integer.MIN_VALUE){
                    count+=1;
                }
                System.out.println(arrA[0]+" "+arrB[1]+"/ ");
                val = temp;
                
            }

            temp = arrA[0]&arrA[1];
            if(temp>val){
                if(val == Integer.MIN_VALUE){
                    count+=1;
                }
                System.out.println(arrA[0]+" "+arrA[1]+"/ ");
                val = temp;
            }

            temp = arrB[0]&arrB[1];
            if(temp>val){
                if(val == Integer.MIN_VALUE){
                    count+=1;
                }
                System.out.println(arrB[0]+" "+arrB[1]+"/ ");
                val = temp;

            }

            temp = arrB[0]&arrA[1];
            if(temp>val){
                if(val == Integer.MIN_VALUE){
                    count+=1;
                }
                System.out.println(arrB[0]+" "+arrA[1]+"/ ");
                val = temp;
            }

            
            for(int i=2;i<n; i++){
                temp = val&arrA[i];
                temp2 = val&arrB[i];

                if(temp>temp2){
                    val = temp;
                    System.out.print(arrA[i]+"/ ");
                } else {
                    val = temp2;
                    System.out.println(arrB[i]+"/ ");
                    count+=1;
                }
            }

            System.out.println(val +" "+ count);
        }
}}
