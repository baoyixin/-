package view;

import java.util.Scanner;

import biz.SCBiz;


public class SelectionCourse {
	public static void show() {		
		System.out.println("正选开始！");
		System.out.println("请输入你的学号：");
		Scanner scanner = new Scanner(System.in);
		String studentNo = scanner.nextLine();
		System.out.println("请输入你要选择的课程编号：");
 	    String courseNumber = scanner.nextLine();
 	    System.out.println("请输入课程编号的课程名称：");
 	    String courseName = scanner.nextLine();
 	    SCBiz scbiz = new SCBiz();
 	    scbiz.match(studentNo, courseNumber, courseName);		
	}
}
