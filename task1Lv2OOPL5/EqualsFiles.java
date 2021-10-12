package task1Lv2OOPL5;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EqualsFiles {

	public boolean equalsFiles(File file1, File file2) {

		if (file1.length() == file2.length()) {
			try (BufferedInputStream in1 = new BufferedInputStream(new FileInputStream(file1));
					BufferedInputStream in2 = new BufferedInputStream(new FileInputStream(file2))) {
				for (long i = 0; i < file1.length(); i++ ) {
					if (in1.read() != in2.read()) {
						return false;
					} 
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} else {
			return false;
		}
		return true;

	}

}
