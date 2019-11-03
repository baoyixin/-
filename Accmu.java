
public class Accmu extends Thread{
    public int startnum;
    public static int sum;
    public Accmu(int startnum) {
    	this.startnum=startnum;
    }
    public static synchronized void add(int num) {
    	sum+=num;
    }
    public void run() {
    	int sum=0;
    	for(int i=0;i<10;i++) {
    		sum+=startnum+i;
    	}
    	add(sum);
    }
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
      Thread[]  threadlist = new Thread[10];
      for(int i=0;i<10;i++) {
    	  threadlist[i]=new Accmu(10*i+1);
    	  threadlist[i].start();
      }
      for(int i=0;i<10;i++) {
    	  threadlist[i].join();
      }
    	  System.out.println(sum);
   }
		
}