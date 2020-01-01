package view;

import java.util.Scanner;

import biz.CourseBiz;

public class courseFindUI {
	public static void show(){
	    Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要查找的课程编号：");
		String courseNo = scanner.nextLine();
		CourseBiz cs3 = new CourseBiz();
		cs3.findCourse(courseNo);
	}
}
