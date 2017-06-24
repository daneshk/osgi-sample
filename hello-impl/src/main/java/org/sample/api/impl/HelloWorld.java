package org.sample.api.impl;

import org.sample.api.Hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello World Impl
 */
public class HelloWorld implements Hello {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    public void sayHello() {
        logger.info("HelloWorld !!!");
    }
}
