package org.unsynchronized;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface BlobAnn {

    int id();

    String sfoo();

    String sdefault() default "[unknown]";

    Class cl();
}
