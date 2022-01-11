package ua.kiev.prog;

import ua.kiev.prog.shared.API.CourseArchive;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws  ParseException {


            ArchiveDAO dao = new ArchiveDAO("CourseArchive");
            Scanner sc = new Scanner(System.in);


            downloadData(sc, dao);

            System.out.println(getRateByDay(sc, dao));

            System.out.println(getAverageRate(sc, dao));


    }

    static void downloadData(Scanner sc, ArchiveDAO dao){
        APIPB apipb = new APIPB();
        long day = 86400000;
        System.out.println("Введите кол-во дней для загрузки в БД");
        int numDay = sc.nextInt();
        Date date = new Date();

        for (int i = 0; i < numDay; i++) {
            Date nextDay = new Date(date.getTime() - day * i);
            CourseArchive courseArchive = apipb.getAPI(nextDay);
            System.out.println("Загузка.....Еще " + (numDay - i) + " дней");
            dao.add(courseArchive);
        }
        System.out.println("Готово");

    }

    static float getRateByDay(Scanner sc, ArchiveDAO dao) throws ParseException {
        System.out.println("Введите дату в формате dd.MM.yyyy");
        String dateText = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        float fl = dao.getSaleRateNBByDate(dateFormat.parse(dateText));
        if (fl == 0){
            System.out.println("На такую дату данных нет");
        }
        return fl;
    }


    static float getAverageRate(Scanner sc, ArchiveDAO dao) throws ParseException {
        long day = 86400000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Введите первую дату в формате dd.MM.yyyy");
        String fistDateText = sc.next();
        Date firstDate = dateFormat.parse(fistDateText);

        System.out.println("Введите вторую дату в формате dd.MM.yyyy");
        String secondDateText = sc.next();
        Date secondDate = dateFormat.parse(secondDateText);
        int count = 0;
        float sum = 0;
        Date date = firstDate;

        while (date.getTime() <= secondDate.getTime()) {
            float fl = dao.getSaleRateNBByDate(date);
            if (fl == 0){
                System.out.println("На такую дату данных нет");
                return 0;
            }
            sum = sum + fl;
            date = new Date(date.getTime() + day);
            count++;
                   }
        return sum / count;
    }
}
