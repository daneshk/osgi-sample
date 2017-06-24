package org.sample.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.sample.api.Hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service Component
 */
@Component(
        name = "org.sample.services.HelloWorldServiceComponent",
        immediate = true
)
public class HelloWorldServiceComponent {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldServiceComponent.class);

    Hello helloService;

    @Activate
    protected void start() {
        logger.info("HelloWorldServiceComponent is Activated");
        helloService.sayHello();
    }

    protected void deactivate() {
        logger.info("HelloWorldServiceComponent is Deactivated");
    }


    @Reference(
            name = "helloworld.sample",
            service = Hello.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetHelloService"
    )
    protected void setHelloService(Hello helloService) {
        logger.info("Acquiring HelloService");
        this.helloService = helloService;
    }

    protected void unsetHelloService(Hello helloService) {
        logger.info("Releasing HelloService");
        this.helloService = null;
    }

}
