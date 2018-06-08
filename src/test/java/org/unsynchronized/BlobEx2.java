package org.unsynchronized;

import java.io.*;

public class BlobEx2 implements Serializable {

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        throw new IOException("woops");
    }

    public int a;
    public String b;

    @Override
    public String toString() {
        return "[blobex a " + a + "  b " + b + "]";
    }

    public BlobEx2(int a) {
        String b = "zoo";
        this.a = a;
        this.b = b;
    }
}
