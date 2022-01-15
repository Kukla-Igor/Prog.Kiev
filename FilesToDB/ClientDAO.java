package ua.kiev.prog;

import ua.kiev.prog.shared.FileToDB;

import java.io.File;
import java.sql.Connection;

public class ClientDAO extends AbstractDAO<FileToDB> {
    public ClientDAO(Connection conn, String table) {
        super(conn, table);
    }


    public void delete(FileToDB file, String path) {
        delete(file);
        File file1 = new File(path +  "/" + file.getName());
        file1.delete();
    }
}
