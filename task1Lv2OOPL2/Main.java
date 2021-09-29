package task1Lv2OOPL2;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		TextSaver saver = new TextSaver(new UpDownTransformer(), new File("file.txt"));

		saver.saveTextToFile("Этот текст");
	}

}
