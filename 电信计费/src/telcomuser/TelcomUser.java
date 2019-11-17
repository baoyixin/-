package telcomuser;
import java.util.Date;
import java.util.Random;

import gc.*;
import tx.*;
import utility.*;
public class TelcomUser {
private String phoneNumber;
private String callTo;
private StringBuffer communicationRecords;
Tongxin  tongxin ;

public TelcomUser(String phoneNumber) {
	this.phoneNumber=phoneNumber;
	this.communicationRecords=new StringBuffer();
	Factory factory1= (Factory)XMLUtility.getBean();
    tongxin = factory1.creat();
}

private String accountFee(long timeStart,long timeEnd) {
	double fee=tongxin.feePerMinute();
	int minutes=Math.round((timeEnd-timeStart)/60000);
	double feeTotal=fee * minutes;
	return String.format("%.4f",feeTotal);
}

private String getcallToPhoneNumber() {
	return "1380372"+String.valueOf(new Random().nextInt(10))
	+String.valueOf(new Random().nextInt(10))
	+String.valueOf(new Random().nextInt(10))
	+String.valueOf(new Random().nextInt(10));
}

public void generateCommunicateRecords() {
	int recordNum=new Random().nextInt(10);
	for(int i=0;i<=recordNum;i++) {
		callTo=getcallToPhoneNumber();
		long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
		long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
		this.communicationRecords.append(this.phoneNumber+","+timeStart+","+timeEnd+","+this.callTo+";");
	}
}

public void printDetails() {
	String allRecords=this.communicationRecords.toString();
	String[] recordArray=allRecords.split(";");
	for(int i=0;i< recordArray.length;i++) {
		String []recordField=recordArray[i].split(",");
		System.out.println("主叫："+recordField[0]);
		System.out.println("被叫："+recordField[3]);
		System.out.println("通话开始时间："+new Date(Long.parseLong(recordField[1])));
		System.out.println("通话结束时间："+new Date(Long.parseLong(recordField[2])));
		System.out.println("计费："+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))+"元");
	}
  }
}