package view;

import java.util.Scanner;


public class MainUI {
	public static void show() {
		System.out.println("**********��ѡ����Ҫ����������************");
		System.out.println("1-ע�᣻2-�޸����룻3-�γ���Ϣ��4-��½��5-ѧ��ѡ�Σ�0-�˳�");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			RegisterUI.show();
			break;
		case "2":
			ModifyPasswordUI.show();
			break;
		case "3":
			MainUI2.show();
			break;
		case "4":
			LoginUI.show();
		case "5":
			Select.show();
		case "0":
			System.out.println("���Ѿ��ɹ��˳���");
			System.exit(0);
		}
	}

}
