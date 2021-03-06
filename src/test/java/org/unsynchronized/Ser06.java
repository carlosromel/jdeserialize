package org.unsynchronized;

import java.io.*;

public class Ser06 {

    public static void main(String args[]) {
        do_write();
        do_read();
    }

    public static void do_write() {
        try {
            BEnum be = BEnum.VALUEC;
            FileOutputStream fos = new FileOutputStream("ser6.duh");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(be);
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
            FileInputStream fos = new FileInputStream("ser6.duh");
            ObjectInputStream ois = new ObjectInputStream(fos);
            BEnum be = (BEnum) ois.readObject();
            System.out.println("blob2: " + be.toString());
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
