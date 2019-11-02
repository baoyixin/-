
public class Storage {
     private int[] cells = new int[10];
     private int inpos,outpos;
     private int count;
     public synchronized void put(int num) {
    	 try {
    		 while(count==cells.length) {
    			 this.wait();
    		 }
    		 cells[inpos]=num;
    		 System.out.println("在cells["+inpos+"]中放入数据---"+cells[inpos]);
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
    		 int data =cells[outpos];
    		 System.out.println("在cells["+outpos+"]中取出数据"+data);
    		 cells[outpos]=0;
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
