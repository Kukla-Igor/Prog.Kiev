import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Save {
    @Saver
    public void save()  {

        Class <?> cls =TextContainer.class;

        SaveTo st = cls.getAnnotation(SaveTo.class);
        File file = new File(st.path());
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Constructor ctr =cls.getConstructor();
            TextContainer tx = (TextContainer) ctr.newInstance();
            Field field = cls.getDeclaredField("text");
            field.setAccessible(true);

            try (PrintWriter pw = new PrintWriter(file)) {
                pw.println(field.get(tx));

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Done");
        } catch (NoSuchFieldException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    }

