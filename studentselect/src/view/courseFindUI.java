package view;

import java.util.Scanner;

import biz.CourseBiz;

public class courseFindUI {
	public static void show(){
	    Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫ���ҵĿγ̱�ţ�");
		String courseNo = scanner.nextLine();
		CourseBiz cs3 = new CourseBiz();
		cs3.findCourse(courseNo);
	}
}
