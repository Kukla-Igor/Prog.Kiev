package ua.kiev.prog.shared;

import java.io.File;

import java.util.Date;

public class FileToDB  {
    @Id
    private int id;

    private String name;
    private long size;
    private String date;

    public FileToDB() {
    }

    public FileToDB(File file) {
        this.name = file.getName();
        this.size = file.length();
        this.date = new Date(file.lastModified()).toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", date=" + date +
                '}';
    }
}
