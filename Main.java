import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    static class Reader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
    
        Reader() {
            in = System.in;
        }
    
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
    
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan()) ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
    
        String nextLine() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan()) ;
            StringBuilder sb = new StringBuilder();
            for (; c != 10 && c != 13; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
    
        char nextChar() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan()) ;
            return (char) c;
        }
    
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }

    public static void main(String[] args) throws IOException {
        
        try{
		OutputStream outputStream =System.out;
        PrintWriter out =new PrintWriter(outputStream);
        Reader sc = new Reader();
        long t = sc.nextLong();
        while(t-- > 0)
        {
            // ENTER YOUR CODE HERE
            

            out.println("any text");
        }
        out.close();
		}catch(Exception e){
			return;
		}
        
        
    }
}
