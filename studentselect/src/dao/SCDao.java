package dao;
import entity.Course;
import entity.IEntity;
import entity.SC;
import entity.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class SCDao implements IDao {

	private static SCDao instance;
	private HashMap<String,IEntity > scs;
	private SC sc;
	private SCDao() {
		scs = new HashMap<String,IEntity>();
		sc = new SC();
		getSCFromInputStream("sc.txt");
	}
	
	//读取文件，以InputStream的形式读取
	private void getSCFromInputStream(String isName) {
		try {
			FileInputStream fs = new FileInputStream(isName);
			byte[] content=new byte[1024];
			int i=0;
			int conInteger=0;
			while(true) {
				try {
					conInteger=fs.read();
				} catch(IOException e) {
					e.printStackTrace();
				}
				if(-1==conInteger) {
					break;
				}else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
					try {
						this.processCourseString(new String(content,"GBK").trim());
						i=0;
					} catch(UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					continue;
				}else {
					content[i]=(byte)conInteger;
					i++;
				}
			}
			fs.close();
		} catch(Exception e) {
			
		}
	}
	public void processCourseString(String courseString) {
		String [] courseFields=courseString.split(",");
		SC s =new SC();
		s.setStudentNo(courseFields[0]);
		s.setCourseNo(courseFields[1]);
		s.setGrade(Integer.parseInt(courseFields[2]));
		scs.put(s.getStudentNo(),s);
	}
	public static SCDao getInstance() {
		if(instance == null) {
			synchronized(SCDao.class) {
				if(instance == null) {
					instance = new SCDao();
					return instance;
				}
			}
		}
		return instance;
	}
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		SC st =(SC)entity;
		scs.put(st.getStudentNo(), st);
	}


	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return scs;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return scs.get(Id);
	}
	
	
	//查询学生选课信息
	public void update(IEntity entity) {
		// TODO Auto-generated method stub
		SC st =(SC)entity;
		scs.put(st.getStudentNo(), st);
	}


	
	
	
	public void save() {
		// TODO Auto-generated method stub
		Set<String> scSet=scs.keySet();
		 StringBuffer uStringBuffer=new StringBuffer();
		 for(String studentNo:scSet) {
			 SC s=(SC)scs.get(studentNo);
			 String uString=s.getStudentNo()+","
					 +s.getCourseNo()+","
					 +s.getCourseName()+"\r\n";
			 uStringBuffer.append(uString);
		 }
		 putStudentToFile(uStringBuffer.toString(),"sc.txt");
	 }
	private void putStudentToFile(String uString,String osName) {
		try {
			FileOutputStream fos=new FileOutputStream(osName);
			try {
				fos.write(uString.getBytes("GBK"));
			}catch(UnsupportedEncodingException e) {
				 e.printStackTrace();
			 }	 
		}catch(IOException e) {
				 e.printStackTrace();
			 }
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String courseNo=scanner.nextLine();
		SC sc= (SC)getEntity(courseNo);
		
			scs.remove(sc.getStudentNo(), sc);
			System.out.println("");
		}   

}
