import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Saver {
    public void doSerialization() throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        File file = new File("D:\\Работа\\Java\\EE\\SaveAnnotation\\file.txt");
        Class<?> cls = ToSave.class;
        Field[] fields = cls.getDeclaredFields();
        Constructor<?> ctr = cls.getConstructor();
        ToSave ts = (ToSave) ctr.newInstance();

        if (!file.exists()) {
            file.createNewFile();
        }

        try (PrintWriter pw = new PrintWriter(file)) {
            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    pw.println(field.get(ts));
                }
            }
        }
    }

    public void doDeserialization() throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        File file = new File("D:\\Работа\\Java\\EE\\SaveAnnotation\\file.txt");
        Class<?> cls = ToSave.class;
        Field[] fields = cls.getDeclaredFields();
        Constructor<?> ctr = cls.getConstructor();
        ToSave ts = (ToSave) ctr.newInstance();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    String line = br.readLine();
                    if (field.getType() == int.class) {
                        field.set(ts, Integer.parseInt(line));
                    } else {
                        field.set(ts, line);
                    }
                }
            }
            System.out.println(ts);
        }
    }
}
