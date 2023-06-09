package com.lin.springframework.aop.framework;

/**
 * Factory for AOP proxies for programmatic use, rather than via declarative
 * setup in a bean factory. This class provides a simple way of obtaining
 * and configuring AOP proxy instances in custom user code.
 *
 * @Author linjiayi5
 * @Date 2023/4/13 20:54:46
 */
public class ProxyFactory extends AdvisedSupport {

    public ProxyFactory() {

    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (this.isProxyTargetClass() || this.getTargetSource().getTargetClass().length == 0) {
            return new CglibAopProxy(this);
        }
        return new JdkDynamicAopProxy(this);
    }


}
