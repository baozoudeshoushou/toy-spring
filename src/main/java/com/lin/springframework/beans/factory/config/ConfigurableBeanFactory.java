package com.lin.springframework.beans.factory.config;

import com.lin.springframework.beans.BeansException;
import com.lin.springframework.beans.factory.HierarchicalBeanFactory;
import com.lin.springframework.utils.StringValueResolver;

/**
 * @Author linjiayi5
 * @Date 2023/4/7 11:41:59
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    /**
     * Add a new BeanPostProcessor that will get applied to beans created
     * by this factory. To be invoked during factory configuration.
     * @param beanPostProcessor the post-processor to register
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * Destroy all singleton beans in this factory, including inner beans that have
     * been registered as disposable. To be called on shutdown of a factory.
     * <p>Any exception that arises during destruction should be caught
     * and logged instead of propagated to the caller of this method.
     */
    void destroySingletons();

    /**
     * Set the class loader to use for loading bean classes.
     * Default is the thread context class loader.
     * <p>Note that this class loader will only apply to bean definitions
     * that do not carry a resolved bean class yet. This is the case as of
     * Spring 2.0 by default: Bean definitions only carry bean class names,
     * to be resolved once the factory processes the bean definition.
     * @param beanClassLoader the class loader to use,
     * or {@code null} to suggest the default class loader
     */
    void setBeanClassLoader(ClassLoader beanClassLoader);

    /**
     * Return this factory's class loader for loading bean classes
     * (only {@code null} if even the system ClassLoader isn't accessible).
     */
    ClassLoader getBeanClassLoader();

    /**
     * Add a String resolver for embedded values such as annotation attributes.
     * @param valueResolver the String resolver to apply to embedded values
     * @since 3.0
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * Determine whether an embedded value resolver has been registered with this
     * bean factory, to be applied through {@link #resolveEmbeddedValue(String)}.
     * @since 4.3
     */
    boolean hasEmbeddedValueResolver();

    /**
     * Resolve the given embedded value, e.g. an annotation attribute.
     * @param value the value to resolve
     * @return the resolved value (may be the original value as-is)
     * @since 3.0
     */
    String resolveEmbeddedValue(String value);

    /**
     * Determine whether the bean with the given name is a FactoryBean.
     * @param name the name of the bean to check
     * @return whether the bean is a FactoryBean
     * ({@code false} means the bean exists but is not a FactoryBean)
     * @throws BeansException if there is no bean with the given name
     */
    boolean isFactoryBean(String name) throws BeansException;
}
