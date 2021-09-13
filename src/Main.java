import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        first();
    }
    public static void first() throws IOException {
        byte[] buff = new byte[64];
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("test.txt"));
        in.read(buff);
        System.out.println(Arrays.toString(buff));
    }
    public static void second() throws IOException {
        ArrayList<InputStream> al = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            al.add(new FileInputStream(i + ".txt"));
        }
        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        int x;
        while((x = in.read()) != -1) {
            System.out.print((char)x);
        }
        in.close();
    }
    public static void third() throws IOException {
        final int PAGE_SIZE = 1800;
        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter page:");
        int p = sc.nextInt() - 1;
        raf.seek((long) p * PAGE_SIZE);
        for (int i = 0; i < PAGE_SIZE; i++) {
            System.out.print((char)raf.read());
        }
        raf.close();
    }
}
