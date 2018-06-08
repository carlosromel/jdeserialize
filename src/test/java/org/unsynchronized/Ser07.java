package org.unsynchronized;

import java.io.*;

public class Ser07 {

    public static void main(String args[]) {
        do_write();
        do_read();
    }

    public static void do_write() {
        try {
            Blob03 bl = new Blob03(1234);
            FileOutputStream fos = new FileOutputStream("ser7.duh");
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
            FileInputStream fos = new FileInputStream("ser7.duh");
            ObjectInputStream ois = new ObjectInputStream(fos);
            Blob03 bl = (Blob03) ois.readObject();
            System.out.println("blob3: " + bl.toString());
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
