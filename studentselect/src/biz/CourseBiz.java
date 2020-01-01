package biz;

import java.util.HashMap;

import dao.CourseDao;
import entity.Course;
import entity.IEntity;
import view.MainUI2;

public class CourseBiz {
	CourseDao courseDao;
	private Course course;
	private HashMap<String, IEntity> courses;
	//课程增加
	public void addCourse(String courseNo, String courseName, int courseGrade) {
		courseDao = CourseDao.getInstance();
		courses = courseDao.getAllEntities();
		  	if(courses.containsKey(courseNo)) {
		  		
		  		System.out.println("你输入的课程已经存在!");
		  		System.out.println("请继续你要选择的服务: ");
				MainUI2.show();
			}else {
				course = new Course();
				course.setCourseNo(courseNo);
				course.setCourseName(courseName);
				course.setCourseGrade(courseGrade);
				courseDao.insert(course);
				courseDao.save();
				MainUI2.show();
			}
		  	
	}
	//课程修改
	public void modifyCourse(String courseNo, String oldcourseName, String newcourseName ,int newcourseGrade) {
		courseDao = CourseDao.getInstance();
		Course course2 = (Course)courseDao.getEntity(courseNo);
		  	if(oldcourseName.equals(newcourseName)) {
		  		
		  		System.out.println("你要修改的课程与来课程名称相同!");
		  		System.out.println("请继续你要选择的服务: ");
			}else {
				course2.setCourseName(newcourseName);
				course2.setCourseGrade(newcourseGrade);
				courseDao.update(course2);
		//存盘		courseDao.save();
			}
		  	MainUI2.show();
	}
	
	//查找课程
	public void findCourse(String courseNo) {
		courseDao = CourseDao.getInstance();
		courses = courseDao.getAllEntities();
		  	if(courses.containsKey(courseNo)) {
		  	
				System.out.println("你要查找的课程已找到");
				 courseDao.printDetail(courseNo);
			}else {
				System.out.println("你要查找的课程不存在!");
			}
		  	System.out.println("请继续你的操作:");
			  MainUI2.show();
	}
	
	//课程移除
	 public void removeCourse(String courseNo, String courseName){
		 courseDao = CourseDao.getInstance();
		 Course course2 = (Course)courseDao.getEntity(courseNo);
		 if(course2!=null){
			 course2.setCourseName(null);
			 course2.setCourseNo(null);
			 courseDao.delete();
		 }else{
			 System.out.println("课程输入错误");
		 }
		 MainUI2.show();

	   }
}
