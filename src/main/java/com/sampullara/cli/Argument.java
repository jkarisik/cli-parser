/*
 * Copyright (c) 2005, Sam Pullara. All Rights Reserved.
 * You may modify and redistribute as long as this attribution remains.
 */

package com.sampullara.cli;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.concurrent.Callable;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Argument {
    /**
     * This is the actual command line argument itself
     */
    String value() default "";
    /**
     * If this is true, then the argument must be set or the parse will fail
     */
    boolean required() default false;

    /**
     * This is the prefix expected for the argument
     */
    String prefix() default "-";
    /**
     * Each argument can have an alias
     */
    String alias() default "";
    /**
     * A description of the argument that will appear in the usage method
     */
    String description() default "";

    /**
     * A delimiter for arguments that are multi-valued.
     */
    String delimiter() default ",";

    Class<? extends Callable<List<String>>> valuesProvider() default DummyCallable.class;

    class DummyCallable implements Callable<List<String>> {
        public List<String> call() throws Exception {
            return null;
        }
    }
}
