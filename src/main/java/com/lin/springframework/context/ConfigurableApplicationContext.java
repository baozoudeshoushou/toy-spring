package com.lin.springframework.context;

import com.lin.springframework.beans.BeansException;

/**
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition
 * to the application context client methods in the
 *
 * @Author linjiayi5
 * @Date 2023/4/7 21:14:18
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 核心方法，刷新容器
     * Load or refresh the persistent representation of the configuration, which
     * might be from Java-based configuration, an XML file, a properties file, a
     * relational database schema, or some other format.
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * Register a shutdown hook with the JVM runtime, closing this context
     * on JVM shutdown unless it has already been closed at that time.
     */
    void registerShutdownHook();

    /**
     * Close this application context, releasing all resources and locks that the
     * implementation might hold. This includes destroying all cached singleton beans.
     */
    void close();

}
