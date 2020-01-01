package dao;

import entity.Course;
import entity.IEntity;




import entity.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Set;

public class StudentDao implements IDao{

	private static StudentDao instance;
	private HashMap<String, Student> students;
	private Student student;
	private FileInputStream fs;
    private FileOutputStream fos;
	private StudentDao() {
		students = new HashMap<String, Student>();
		student = new Student();
		
		getUsersFormInputStream("student.txt");  
	}
	
	
	public void getUsersFormInputStream(String isName){
   	 try {
			fs=new FileInputStream(isName);
			byte[] content=new byte[1024];
			int i=0;
			int conInteger=0;
			while(true) {
				try {
					conInteger=fs.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(-1==conInteger) {
					break;
				}else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
					try {
						this.processUserString(new String(content,"GBK").trim());
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					i=0;
				}else {
					content[i]=(byte)conInteger;
					i++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	
	public void processUserString(String userString) {
		String[] studentFields=userString.split(",");
   	 	Student st=new Student();
   	 	st.setStudentNo(studentFields[0]);
   	 	st.setStudentName(studentFields[1]);
   	 	st.setStudentAge(Integer.parseInt(studentFields[2]));
   	 	st.setStudentDepartment(studentFields[3]);
   	 	st.setStudentPassword(studentFields[4]);
   	 	st.setStudentGender(studentFields[5]);
   	 	students.put(st.getStudentNo(), st);
	}
	
	
	public static StudentDao getInstance() {
		if(instance == null) {
			synchronized(StudentDao.class) {
				if(instance == null) {
					instance = new StudentDao();
					return instance;
				}
			}
		}
		return instance;
	}
	
	
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Student st = (Student)entity;
		students.put(st.getStudentNo(), st);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(IEntity entity){
		
	   Student st1 =(Student)entity;
	   students.put(st1.getStudentNo(),st1);
	   
		// TODO Auto-generated method

	}

	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return students.get(Id);
	}

	public void save() {
		// TODO Auto-generated method stub
		Set<String> studentSet=students.keySet();
	   	 StringBuffer uStringBuffer=new StringBuffer();
	   	 for(String studentNo:studentSet) {
	   		 Student st=(Student)students.get(studentNo);
				String uString = st.getStudentNo()+","
						+st.getStudentName()+","+
						st.getStudentAge()+","+
						st.getStudentDepartment()+","+
						st.getStudentPassword()+","+
						st.getStudentGender()+"\r\n";
				uStringBuffer.append(uString);
	   	 }
	   	 putStudentsToFile(uStringBuffer.toString(),"student.txt");
	}
	
	private void putStudentsToFile(String uString,String osName){
   	 	try {
   	 		fos=new FileOutputStream(osName);
   	 	} catch (FileNotFoundException e) {
   	 		e.printStackTrace();
   	 	}
   	 	try {
   	 		fos.write(uString.getBytes("GBK"));
   	 	} catch (UnsupportedEncodingException e) {
   	 		e.printStackTrace();
   	 	} catch (IOException e) {
   	 		e.printStackTrace();
   	 	}
    }
	
}
