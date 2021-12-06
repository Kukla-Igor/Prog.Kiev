import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
       Class <?> cls = Save.class;
        Method[] methods = cls.getMethods();
        try {
        for (Method method: methods) {
            if(method.isAnnotationPresent(Saver.class)){

                    method.invoke(new Save());
                }
            }
        }catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
