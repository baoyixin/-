package view;

import java.util.Scanner;

import biz.CourseBiz;

public class courseRemoveUI {
	public static void show(){
	    Scanner scanner = new Scanner(System.in);
		System.out.println("������γ̵ı�ţ�");
		String courseNo = scanner.nextLine();
		System.out.println("������γ̵����֣�");
		String courseName = scanner.nextLine();
		CourseBiz sc1 = new CourseBiz();
		sc1.removeCourse(courseNo, courseName);
	}
}
