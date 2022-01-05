package ua.kiev.prog;

import ua.kiev.prog.shared.FileToDB;

import java.sql.Connection;

public class ClientDAO extends AbstractDAO<FileToDB> {
    public ClientDAO(Connection conn, String table) {
        super(conn, table);
    }
}
