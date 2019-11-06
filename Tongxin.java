import java.util.Random;

public class Tongxin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Storage st =new Storage();
     Input input = new Input(st);
     Output output = new Output(st);
     new Thread(input).start();
     new Thread(output).start();
    
    
	}

}

 class Storage {
    private String[] cells = new String[10];
    private int inpos,outpos;
    private int count;
    private Random d = new Random();
    public int num2 = d.nextInt();
    
    public synchronized void put(int num) {
   	 try {
   		 while(count==cells.length) {
   			 this.wait();
   		 }
   		 cells[inpos]=String.valueOf(num);
   		 System.out.println("cells["+inpos+"]用户登录名---"+cells[inpos]);
   		 System.out.println("此时同时在线人数是"+count);
   		 inpos++;
   		 if(inpos==cells.length)
   			 inpos=0;
   		 count++;
   		 
   		 this.notify();	
   	 }catch (Exception e) {
   		 e.printStackTrace();
   	 }
    }
    public synchronized void get() {
    	
   	 try {
   		 while(count==0) {
   			 this.wait();
   		 }
   		
   		 Thread.sleep(num2);
   		 String data =cells[outpos];
   		 System.out.println("在cells["+outpos+"]中注销用户"+data);
   		 System.out.println("此时同时在线人数是"+count);
   		 cells[outpos]=null;
   		 outpos++;
   		 if(outpos==cells.length)
   			 outpos=0;
   		 count--;
   		 this.notify();
   		
   	 }catch(Exception e) {
   		 e.printStackTrace();
   	 }
    }
}
 
 class Input implements Runnable {
		private Storage st;
		private int num;
		private Random r = new Random ();
		
		
		Input (Storage st){
			this.st=st;
		}
		public void run() {
			while(true) {
				num = r.nextInt();
				st.put(num);	
				
		}
	}
}
 
 class Output implements Runnable {
     private Storage st;
     Output(Storage st){
   	  this.st=st;
     }
     public void run() {
   	  while(true) {
   		  st.get();
   		
   	  }
     }
}