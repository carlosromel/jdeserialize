package org.unsynchronized;

import java.io.*;

public class Ser05 {

    public static void main(String args[]) {
        do_write();
        do_read();
    }

    public static void do_write() {
        try {
            Blob02 bl = new Blob02(1234, "abcd");
            FileOutputStream fos = new FileOutputStream("ser5.duh");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bl);
            oos.flush();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("IOException");
            System.exit(1);
        }
        System.out.println("wrote");
    }

    public static void do_read() {
        try {
            FileInputStream fos = new FileInputStream("ser5.duh");
            ObjectInputStream ois = new ObjectInputStream(fos);
            Blob02 bl = (Blob02) ois.readObject();
            System.out.println("blob2: " + bl.toString());
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("IOException");
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            System.exit(1);
        }
    }
}
