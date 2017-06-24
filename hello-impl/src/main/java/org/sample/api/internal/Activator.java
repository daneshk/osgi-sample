package org.sample.api.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.sample.api.Hello;
import org.sample.api.impl.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello Bundle Activator
 */
public class Activator implements BundleActivator {
    private static final Logger logger = LoggerFactory.getLogger(Activator.class);
    ServiceRegistration registration = null;
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        registration = bundleContext.registerService(Hello.class, helloWorld, null);
        logger.info("Hello World Service Registered Successfully");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        if (registration != null) {
            registration.unregister();
            logger.info("Hello World Service Unregistered Successfully");
        }
    }
}
