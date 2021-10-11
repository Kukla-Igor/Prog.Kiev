package task1L1OOPL5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFilesByExtension {
	private String extension;

	public CopyFilesByExtension(String extension) {
		super();
		this.extension = extension;
	}

	public CopyFilesByExtension() {
		super();
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "CopyFiles [extension=" + extension + "]";
	}

	public void copyFile(File In, File Out) throws IOException {
		try (InputStream is = new FileInputStream(In); OutputStream os = new FileOutputStream(Out)) {
			is.transferTo(os);
		} catch (IOException e) {
			throw e;
		}

	}

	public void folderCopy(File folderIn, File folderOut) throws IOException {
		int count = 0;
		File[] files = folderIn.listFiles();
		for (File file : files) {
			if (file.isFile() && checkFileByExtension(file)) {
				File out = new File(folderOut, file.getName());
				copyFile(file, out);
				count++;
			}
		}
		System.out.println("Скопировано " + count + " файлов");

	}

	public boolean checkFileByExtension(File file) {
		return file.getName().endsWith(extension);
	}
}
