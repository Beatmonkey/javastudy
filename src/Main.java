import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

//        HashMap<String, String> map = new HashMap<>();
//        LoggableMapInvocationHandler loggableMapInvocationHandler = new LoggableMapInvocationHandler(map);

        MyServiceInvocationHandler myServiceInvocationHandler = new MyServiceInvocationHandler();

        Service proxy = (Service) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[]{
                        Service.class
                },
                myServiceInvocationHandler
        );

        proxy.doGood();
        proxy.calculate();
        proxy.getResult("");

        Animal animal = new Animal();
        animal.name = "Vasya";
        animal.description = "awef";
        animal.price = 123.32;

        Cat cat = new Cat();

        // transform to other format
        System.out.println(transform(animal));
        System.out.println(transform(proxy));

        System.out.println(transform(new HashMap<>()));

//        Object asd = proxy.get("asd");
//        System.out.println("Value of asd = " + asd);
    }

    static String transform(Object object) {
        StringBuilder result = new StringBuilder();
        // code!
        Class<?> clazz = object.getClass();
        result.append(clazz.getName()+"\n");
        result.append("-----------\n");
        for (Field field : clazz.getDeclaredFields()) {
            try {
                result.append(field.getName() + ": " + field.get(object)+"\n");
            } catch (IllegalAccessException e) {
                result.append(field.getName() + ": illegal access\n");
            }
        }
        return result.toString();
    }
}

class MyServiceInvocationHandler implements InvocationHandler {

    private MyService myService = new MyService();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // before method
        long before = System.currentTimeMillis();
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            // for logging
            if (declaredAnnotation.annotationType() == Loggable.class) {
                System.out.println(method.getName() + " is Loggable");
            }
        }

        Object result = method.invoke(myService, args);

        // after method
        // ...
        long after = System.currentTimeMillis();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            // for measuring
            if (declaredAnnotation.annotationType() == Measure.class) {
                System.out.println("Method " + method.getName() + " invocation time = " + (after - before));
            }
        }

        return result;
    }
}


class LoggableMapInvocationHandler implements InvocationHandler {

    private Map map;

    public LoggableMapInvocationHandler(Map map) {
        this.map = map;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method invoked: " + method.getName() + " args=" + (args == null ? 0 : args.length));
        return method.invoke(map, args);
    }
}