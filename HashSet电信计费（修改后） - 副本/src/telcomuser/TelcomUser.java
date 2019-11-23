package telcomuser;

import java.util.Calendar;
import java.text.*;
import java.util.*;
import java.util.Date;
import java.util.Random;

import gc.*;
import tx.*;
import utility.*;

public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	private Vector communicationRecords;
	private HashSet callToNumbers;
	private ArrayList callToNumbersList;
	Tongxin tongxin;


	public TelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new Vector();
		this.callToNumbers = new HashSet();
		this.callToNumbersList = new ArrayList();
		Factory factory1 = (Factory) XMLUtility.getBean();
		tongxin = factory1.creat();
	}

	private String accountFee(long timeStart, long timeEnd) {
		double fee = tongxin.feePerMinute();
		int minutes = Math.round((timeEnd - timeStart) / 60000);
		double feeTotal = fee * minutes;
		return String.format("%.4f", feeTotal);
	}

	private String getcallToPhoneNumber() {
		return "1380372" + String.valueOf("0") + String.valueOf("0")
				+ String.valueOf("0") + String.valueOf(new Random().nextInt(10));
	}

	//模拟通话记录的形成
	public void generateCommunicateRecords() {
		int recordNum = new Random().nextInt(10);
		for (int i = 0; i <= recordNum; i++) {
			// 随机生成第i条通话记录
			// 用Calendar获取当前时间
			Calendar cal = Calendar.getInstance();
			// 随机减去若干小时（十小时以内）
			cal.add(Calendar.HOUR, -new Random().nextInt(10));
			callTo = getcallToPhoneNumber();
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			this.callToNumbers.add(this.callTo);
			this.callToNumbersList.add(this.callTo);
			this.communicationRecords.add(this.phoneNumber + "," + timeStart + "," + timeEnd + "," + this.callTo);
		}
	}

	public void printDetails() {
		//使用Enumeration接口遍历
		
		Enumeration enumeration = this.communicationRecords.elements();
		
		while(enumeration.hasMoreElements()) {
			String[] recordField = ((String) enumeration.nextElement()).split(",");
			System.out.println("主叫：" + recordField[0]);
			System.out.println("被叫：" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
			
			//SimpleDateFormat
			System.out.println("通话开始时间：" + simpleDateFormat.format(timeStart));
			System.out.println("通话结束时间：" + simpleDateFormat.format(timeEnd));
			System.out
					.println("计费：" + accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2])) + "元");
			
		}
		for(Object callTo : this.callToNumbersList) {
			System.out.println((String)callTo);
		}
		System.out.println("----List/HashSet分割线----------------------");
		for(Object callTo: this.callToNumbers) {
			System.out.println((String)callTo);
		}
	}
}