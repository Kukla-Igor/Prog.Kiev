package task1L1OOPL5;

import java.io.File;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		CopyFilesByExtension cfbe = new CopyFilesByExtension(".pdf");

		File folderOut = new File("D:\\Test");
		File folderIn = new File("D:\\Работа\\ACAD\\Тесла\\2021\\Garden 15");
		folderOut.mkdirs();
		try {
			cfbe.folderCopy(folderIn, folderOut);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
