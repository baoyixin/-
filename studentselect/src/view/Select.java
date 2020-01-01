package view;

import java.util.Scanner;

public class Select {

	public static void show() {
		System.out.println("1-ÕýÑ¡£»2¡ªÍËÑ¡£»");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			SelectionCourse.show();
			break;
		case "2":
			DeleteCourse.show();
			break;
		}
	}
}
