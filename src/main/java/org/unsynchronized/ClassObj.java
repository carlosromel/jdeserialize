package org.unsynchronized;

/**
 * This represents a Class object (i.e. an instance of type Class) serialized in
 * the stream.
 */
public class ClassObj extends ContentBase {

    /**
     * The class description, including its name.
     */
    public ClassDesc classdesc;

    /**
     * Constructor.
     *
     * @param handle the instance's handle
     * @param cd the instance's class description
     */
    public ClassObj(int handle, ClassDesc cd) {
        super(ContentType.CLASS);
        this.handle = handle;
        this.classdesc = cd;
    }

    public String toString() {
        return "[class " + JDeserialize.hex(handle) + ": " + classdesc.toString() + "]";
    }
}
