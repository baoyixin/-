package view;

import java.util.Scanner;

import biz.SCBiz;


public class SelectionCourse {
	public static void show() {		
		System.out.println("��ѡ��ʼ��");
		System.out.println("���������ѧ�ţ�");
		Scanner scanner = new Scanner(System.in);
		String studentNo = scanner.nextLine();
		System.out.println("��������Ҫѡ��Ŀγ̱�ţ�");
 	    String courseNumber = scanner.nextLine();
 	    System.out.println("������γ̱�ŵĿγ����ƣ�");
 	    String courseName = scanner.nextLine();
 	    SCBiz scbiz = new SCBiz();
 	    scbiz.match(studentNo, courseNumber, courseName);		
	}
}
