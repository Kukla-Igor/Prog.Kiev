package ua.kiev.prog;

import ua.kiev.prog.shared.API.CourseArchive;
import java.sql.Connection;

public class ArchiveDAO extends AbstractDAO<CourseArchive> {
    public ArchiveDAO(Connection conn, String table) {
        super(conn, table);
    }
}
