public class Type {
	public static void main(String[] args){
		MyThread me=new MyThread();
		Thread thread=new Thread(me);
		thread.start();
		for(int i=0;i<50;i++){
			System.out.println("main");	
		}
	}
}
class MyThread implements Runnable{
	public void run(){
		for(int i=0;i<100;i++)
		{
			System.out.println("new");
		}
	}
	
} 
 
