package io.xccit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author CH_ywx
 * @date 2023-08-04
 * @description
 */
public class HelloContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SpringBoot WebApplication StartUp!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("SpringBoot WebApplication Destroy!");
    }
}
