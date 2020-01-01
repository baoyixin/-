package biz;

import java.util.HashMap;

import dao.CourseDao;
import dao.SCDao;
import dao.StudentDao;
import entity.Course;
import entity.IEntity;
import entity.SC;
import entity.Student;
import view.MainUI2;

public class SCBiz {

	SCDao scDao ;
	private SC sc;
	private SC sc1;
	private HashMap<String, IEntity> scs;
	//��ѡ
	public void match(String studentNo, String courseNumber, String courseName) {
		   
			    scDao = SCDao.getInstance();
		        scs = scDao.getAllEntities();
				sc = new SC();
				sc.setStudentNo(studentNo);
				sc.setCourseNo(courseNumber);
				sc.setCourseName(courseName);
				scDao.insert(sc);
				System.out.println("��ѡ�ɹ���");
				System.out.println("��ѡ������£�");
				scDao.update(sc);	
				scDao.save();
				MainUI2.show();
	}
	//��ѡ
	public void courseDelete(String studentNo, String courseNumber, String courseName){
		scDao = SCDao.getInstance();
        scs = scDao.getAllEntities();
		sc1 = new SC();
		sc1.setStudentNo(studentNo);
		sc1.setCourseNo(courseNumber);
		sc1.setCourseName(courseName);
		
		scDao.delete();
		System.out.println("��ѡ�ɹ���");
		System.out.println("��ѡ�������£�");
		scDao.update(sc1);	
		MainUI2.show();
	}
}
