package longChallenge_august;

import java.util.*;
import java.io.*;

public class solution4 {
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

    static class Jobs implements Comparable<Jobs> {
        int deadline, duration, idx;

        public Jobs(int deadline, int duration, int idx) {
            this.deadline = deadline;
            this.duration = duration;
            this.idx = idx;
        }

        @Override
        public int compareTo(Jobs other) {
            // TODO Auto-generated method stub

            return other.deadline-this.deadline;
        }
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            // TODO Auto-generated method stub

            if (this.x == other.x)
                return 0;
            else if (this.x > other.x)
                return 1;
            else
                return -1;
        }
    }
    

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] satisfaction = new int[n];
            int[] exit = new int[n];

            for (int i = 0; i < n; i++) {
                satisfaction[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                exit[i] = sc.nextInt();
            }

            ArrayList<Jobs> jobsarr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (satisfaction[i] > exit[i]) {
                    continue;
                } else {
                    jobsarr.add(new Jobs(exit[i], satisfaction[i], i+1));
                }
            }

         
           coupute_schedule(jobsarr, n);

            if(schedule.size() ==0){
              System.out.println(0);
              System.out.println();
            }  else {
                long start =0;
                long end =0;
                System.out.println(schedule.size());
                for(Integer x : schedule){
                    end = start + satisfaction[x-1];
                    System.out.println(x+" "+ start +" "+ end);
                    start += satisfaction[x-1];
                }
                schedule.clear();
            }
        }
    }

    static ArrayList<Integer> schedule = new ArrayList<>();

    static void coupute_schedule(ArrayList<Jobs> jobs, int n) {
        Collections.sort(jobs);

        int t =0;
        boolean isit = false;

        PriorityQueue<Pair> s = new PriorityQueue<>();
        
        for (int i = jobs.size() - 1; i >= 0; i--) {
            t = jobs.get(i).deadline - (i > 0 ? jobs.get(i - 1).deadline : 0);
            System.out.println(t+"/");
            s.add(new Pair(jobs.get(i).duration, jobs.get(i).idx));
            while (t > 0 && !s.isEmpty()) {
                Pair temp = s.peek();
                if (temp.x <= t) {
                    t -= temp.x;
                    if (schedule.size() < 2*n) {
                        schedule.add(temp.y);
                    } else {
                        isit = true;
                        break;

                    }
                    // for(Pair p : s){
                    //     System.out.println(p.x +" "+p.y);
                    // }
                    // System.out.println("//");
                } else {
                    s.add(new Pair(temp.x - t, temp.y));
                    // for(Pair p : s){
                    //     System.out.println(p.x +" "+p.y);
                    // }
                    // System.out.println("//");
                    t = 0;
                }
                // System.out.println(s.size()+" /first");
                s.remove(temp);
                // System.out.println(s.size()+" /second");
            }
            if (isit) {
                break;
            }

        }
    }
}
