package task1Lv2OOPL5;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		EqualsFiles ef = new EqualsFiles();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������� ����� ������� �����");
		File file1 = new File(sc.nextLine());
		System.out.println("������� ����� ������� �����");
		File file2 = new File(sc.nextLine());


		System.out.println(ef.equalsFiles(file1, file2));
		
		//File file1 = new File("D:\\������\\ACAD\\���-��\\1.dwg");
		//File file2 = new File("C:\\Users\\Samog\\Desktop\\2.dwg");

	}

}
