package view;

import java.util.Scanner;




import biz.StudentBiz;
import entity.Student;

public class ModifyPasswordUI {
	public static void show() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ѧ��");
		String studentNo = scanner.nextLine();
		System.out.println("�����������");
		String oldPassword = scanner.nextLine();
		System.out.println("������������");
		String firstPassword = scanner.nextLine();
		System.out.println("���ٴ�����������");
		String secondPassword = scanner.nextLine();
		StudentBiz studentBiz = new StudentBiz();
		studentBiz.ModifyPassword(studentNo,oldPassword,firstPassword,secondPassword);
		MainUI.show();
		
		
	}

}
