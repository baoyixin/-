package view;

import java.util.Scanner;

import biz.SCBiz;

public class DeleteCourse {

	public static void show() {		
		System.out.println("请输入你的学号：");
		Scanner scanner = new Scanner(System.in);
		String studentNo = scanner.nextLine();
		System.out.println("请输入你要选择删除的课程编号：");
 	    String courseNumber = scanner.nextLine();
 	    System.out.println("请输入你要删除的课程编号的课程名称：");
 	    String courseName = scanner.nextLine();
 	    SCBiz scbiz = new SCBiz();
 	    scbiz.courseDelete(studentNo, courseNumber, courseName);
	}    
}
