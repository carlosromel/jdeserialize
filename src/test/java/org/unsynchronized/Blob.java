package org.unsynchronized;

import java.io.*;

public class Blob implements Serializable {

    public class inner implements Serializable {

        private int ia;
        private String ib;

        public inner(int ia, String ib) {
            this.ia = ia;
            this.ib = ib;
        }

        @Override
        public String toString() {
            return "[inner ia " + ia + "  ib " + ib + "]";
        }
    }
    private int a;
    private String b;
    private inner i;

    @Override
    public String toString() {
        return "[blob a " + a + "  b " + b + "  i " + i.toString() + "]";
    }

    public Blob(int a, String b) {
        this.a = a;
        this.b = b;
        this.i = new inner(a + 1, b);
    }
}
