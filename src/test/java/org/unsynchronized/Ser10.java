package org.unsynchronized;

import java.io.*;

public class Ser10 {

    public static void main(String args[]) {
        do_write();
    }

    public static void do_write() {
        try {
            BlobEx bl = new BlobEx(1234);
            FileOutputStream fos = new FileOutputStream("ser10.duh");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            try {
                oos.writeObject(bl);
            } catch (IOException ignore) {
            }
            oos.writeObject("klsadfj lkasdf lkadsfkl kdsfalklj fof course");
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
            FileInputStream fos = new FileInputStream("ser10.duh");
            ObjectInputStream ois = new ObjectInputStream(fos);
            BlobEx bl = (BlobEx) ois.readObject();
            System.out.println("blobex: " + bl.toString());
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
