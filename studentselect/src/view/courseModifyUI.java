package view;

import java.util.Scanner;

import biz.CourseBiz;

public class courseModifyUI {
	public static void show(){
	    Scanner scanner = new Scanner(System.in);
		System.out.println("请输入课程的编号：");
		String courseNo = scanner.nextLine();
		System.out.println("请输入原来课程的名字：");
		String oldcourseName = scanner.nextLine();
		System.out.println("请输入新课程的名字");
		String newcourseName = scanner.nextLine();
		System.out.println("请输入新课程的成绩: ");
		int newcourseGrade = scanner.nextInt();
		
		CourseBiz sc2 = new CourseBiz();
		sc2.modifyCourse(courseNo, oldcourseName, newcourseName,newcourseGrade);
	}
}
