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
	//正选
	public void match(String studentNo, String courseNumber, String courseName) {
		   
			    scDao = SCDao.getInstance();
		        scs = scDao.getAllEntities();
				sc = new SC();
				sc.setStudentNo(studentNo);
				sc.setCourseNo(courseNumber);
				sc.setCourseName(courseName);
				scDao.insert(sc);
				System.out.println("正选成功！");
				System.out.println("正选结果如下：");
				scDao.update(sc);	
				scDao.save();
				MainUI2.show();
	}
	//退选
	public void courseDelete(String studentNo, String courseNumber, String courseName){
		scDao = SCDao.getInstance();
        scs = scDao.getAllEntities();
		sc1 = new SC();
		sc1.setStudentNo(studentNo);
		sc1.setCourseNo(courseNumber);
		sc1.setCourseName(courseName);
		
		scDao.delete();
		System.out.println("退选成功！");
		System.out.println("退选后结果如下：");
		scDao.update(sc1);	
		MainUI2.show();
	}
}
