package codeforcesPrac.CodeforcesRound738;

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

    static Map<Integer, LinkedList<Integer>> connect = new HashMap<>();

    public static boolean vertexA(int src){  
        connect.putIfAbsent(src, new LinkedList<>());
        return true;      
    }

    public static void unweightedg(int src, int desti) {
        connect.putIfAbsent(src, new LinkedList<>());
        connect.get(src).add(desti);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] paths = new int[n + 1];

            // o1 paths
            for (int i = 1; i <= n; i++) {
                paths[i] = sc.nextInt();
            }

            for (int i = 1; i <= n+1; i++) {
                vertexA(i);
            }

            // n-1 road path
            for (int i = 1; i < n; i++) {
                unweightedg(i, i + 1);
            }

            //
            for (int i = 1; i <= n; i++) {
                if (paths[i] == 0) {
                    unweightedg(i, n + 1);
                } else {
                    unweightedg(n + 1, i);
                }
            }

            // print(connect);

            ArrayList<Integer> visited = new ArrayList<>();

            for (Map.Entry<Integer, LinkedList<Integer>> entry : connect.entrySet()) {
                int key = entry.getKey();

                finding(connect, key, visited);
                if (visited.size() >= connect.size()) {
                    break;
                } else {
                    visited.clear();
                }

            }

            for (int i = 0; i < visited.size(); i++) {
                System.out.print(visited.get(i) + " ");
            }
            System.out.println();

            visited.clear();

        }
    }

//    static void print(Map<Integer, LinkedList<Integer>> connect){
//         for(Map.Entry<Integer, LinkedList<Integer>> entry : connect.entrySet()){
//             int key = entry.getKey();
//             LinkedList<Integer> value = entry.getValue();

//             System.out.print(key+": ");
//             for(int i=0;i<value.size(); i++){
//                 System.out.print(value.get(i)+" "); 
//             }
//             System.out.println();
//         }
//    }

    public static void finding(Map<Integer, LinkedList<Integer>> connect, int key, ArrayList<Integer> visited) {
        if (visited.size() >= connect.size()) {
            return;
        }

        if (!visited.contains(key)) {
            visited.add(key);
        }

        LinkedList<Integer> temp = connect.get(key);
        for (int i = 0; i < temp.size(); i++) {
            if (!visited.contains(temp.get(i))) {
                finding(connect, temp.get(i), visited);
            }

        }
    }
}
