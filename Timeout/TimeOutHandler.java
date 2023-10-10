package Timeout;

import java.lang.reflect.Method;

public class TimeOutHandler implements Runnable {
        private final Object object;
        private final Method method;
        private final long timeout;

        public TimeOutHandler (Object object, Method method, long timeout) {
            this.object = object;
            this.method = method;
            this.timeout = timeout;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeout);
                method.invoke(object);
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.toString());
            }
        }
}
