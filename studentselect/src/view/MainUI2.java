package view;

import java.util.Scanner;

public class MainUI2 {
	public static void show() {
		System.out.println("1-�γ����ӣ�2-�γ�ɾ����3-�γ��޸ģ�4-�γ̲�ѯ��0-�˳�");
		Scanner scanner = new Scanner(System.in);
		String option1 = scanner.nextLine();
		switch (option1) {
		case "1":
			courseAddUI.show();
			break;
		case "2":
			courseRemoveUI.show();
			break;
		case "3":
			courseModifyUI.show();
			break;
		case "4":
			courseFindUI.show();
			break;
		case "0":
			MainUI.show();
		}
			
	}
}
