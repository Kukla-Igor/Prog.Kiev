package ua.kiev.prog;


import ua.kiev.prog.shared.ConnectionFactory;
import ua.kiev.prog.shared.FileToDB;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter the path to the folder");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        try (Connection conn = ConnectionFactory.getConnection()) {

            try (Statement st = conn.createStatement()) {
                st.execute("DROP TABLE IF EXISTS Files");
                //st.execute("CREATE TABLE Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, age INT)");
            }


          ClientDAO dao = new ClientDAO(conn, "Files");
          dao.createTable(FileToDB.class);

            File folder = new File(path);
            File[] files = folder.listFiles();



            for (File file: files) {
                FileToDB fileToDB = new FileToDB(file);
                dao.add(fileToDB);
            }

            List<FileToDB> list = dao.getAll(FileToDB.class);

            for (FileToDB file:list) {
                System.out.println(file);
            }

            System.out.println("Select id to delete file");
            int id = sc.nextInt();
            for (FileToDB file:list) {
                if (id == file.getId()){
                    dao.delete(file, path);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
