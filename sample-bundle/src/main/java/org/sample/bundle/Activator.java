package org.sample.bundle;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sample Bundle Activator
 */
public class Activator implements BundleActivator {
    private static final Logger logger = LoggerFactory.getLogger(Activator.class);
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        logger.info("Staring Sample HelloWorld Bundle");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        logger.info("Stopping Sample HelloWorld Bundle");
    }
}
