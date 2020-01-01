package view;

import java.util.Scanner;




import biz.StudentBiz;
import entity.Student;

public class ModifyPasswordUI {
	public static void show() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入学号");
		String studentNo = scanner.nextLine();
		System.out.println("请输入旧密码");
		String oldPassword = scanner.nextLine();
		System.out.println("请输入新密码");
		String firstPassword = scanner.nextLine();
		System.out.println("请再次输入新密码");
		String secondPassword = scanner.nextLine();
		StudentBiz studentBiz = new StudentBiz();
		studentBiz.ModifyPassword(studentNo,oldPassword,firstPassword,secondPassword);
		MainUI.show();
		
		
	}

}
