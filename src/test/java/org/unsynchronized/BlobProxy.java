package org.unsynchronized;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class BlobProxy implements Serializable, InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("invoke: proxy " + proxy.getClass().toString()
                + "  method " + method.toString());
        return "foo";
    }

    public int a;
    public String b;

    @Override
    public String toString() {
        return "[blobproxy a " + a + "  b " + b + "]";
    }

    public BlobProxy(int a) {
        String b = "zoo";
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        try {
            BlobProxy bp = new BlobProxy(55);
            Class<?> pclass = Proxy.getProxyClass(BlobProxy.class.getClassLoader(),
                                                  new Class[]{List.class, Iterator.class});
            Constructor<?> constructor = pclass.getConstructor(new Class<?>[]{InvocationHandler.class});
            List s = (List) constructor.newInstance(new Object[]{bp});
            System.out.println("s.get: " + s.get(2));
            Iterator it = (Iterator) s;
            System.out.println("it.next: " + it.next());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
