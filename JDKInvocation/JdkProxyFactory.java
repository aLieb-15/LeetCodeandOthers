package JDKInvocation;

import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    public static Object getProxy(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), // 获取类加载器
                object.getClass().getInterfaces(), // 代理需要实现的接口
                new DebugInvocationHandler(object)); // 代理对象对应的自定义InvocationHandler
    }
}
