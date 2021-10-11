package task2OOPL5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.rmi.StubNotFoundException;
import java.util.Arrays;

import task2OOPL5.exeptions.GroupNotFoundExeption;
import task2OOPL5.exeptions.StudentNotFoundExeption;

public class GroupFileStorage {

	public void saveGroupToCSV(Group gr) {
		File file = new File(gr.getName() + ".csv");
		try (PrintWriter pw = new PrintWriter(file)) {
			for (Student student : gr.getStudents()) {
				if (student != null) {
					pw.println(student.toCSVString());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Group loadGroupFromCSV(File file) throws StudentNotFoundExeption {
		Student st = new Student(null, null, 0, null);
		Student[] students = new Student[10];
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (int i = 0; i < students.length; i++) {
				String str = br.readLine();
				if (str != null) {
					students[i] = st.fromCSVString(str);
				}
			}
			Group group = new Group(nameFileWithotExtensionCSV(file));
			group.setStudents(students);
			return group;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new StudentNotFoundExeption();
		}

	}

	public File findFileByGroupName(String groupName, File workFolder) throws GroupNotFoundExeption {
		File[] files = workFolder.listFiles();
		for (File file : files) {
			if (file.isFile() && nameFileWithotExtensionCSV(file).equals(groupName)) {
				return file;
			}
		}
		throw new GroupNotFoundExeption();
	}

	public String nameFileWithotExtensionCSV(File file) {
		return file.getName().replaceAll(".csv", "");

	}
}
