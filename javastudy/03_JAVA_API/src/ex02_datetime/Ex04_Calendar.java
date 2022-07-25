package ex02_datetime;

import java.util.Calendar;

public class Ex04_Calendar {

	public static void main(String[] args) {
		
		/*
		 * java.util.Calendar  클래스
		 * 현재 날짜 또는 특정 날짜를 나타낼 때 사용
		 * 날짜의 특정 요소(년, 월, 일, 시, 분, 초, ...)를 쉽게 사용할수 있음
		 * 
		 */

		 Calendar cal = Calendar.getInstance();
		 
		 // 년, 월, 일, 요일  
		 //객체가 가지고있는 기능 => 메소드/함수
		 //클래스를 사용하는언어에서는 메소드 = 클래스를 사용하지않는 언어는 함수라고함
		 
		 
		 //Calendar에 상수(변하지 않는 수 final)값을가져옴
		 int year = cal.get(Calendar.YEAR);          // int year = cal.get(1);
		 int month = cal.get(Calendar.MONTH) + 1;    // +1해서 실제 월에 맞춰야함
		 int day = cal.get(Calendar.DAY_OF_MONTH);   // 일
		 int weekNo = cal.get(Calendar.DAY_OF_WEEK); // 일주일의 몇번째 날짜인지
		 
		 System.out.println("year  : " + year);
		 System.out.println("month : " + month); //월: 0 ~ 11 (주의가 필요함) 하나씩 밀려서 나옴
		 System.out.println("day   : " + day);
		 
		 switch (weekNo) {
		case 1 : System.out.println("일요일"); break;
		case 2 : System.out.println("월요일"); break;
		case 3 : System.out.println("화요일"); break;
		case 4 : System.out.println("수요일"); break;
		case 5 : System.out.println("목요일"); break;
		case 6 : 
			System.out.println("금요일"); break;
		default : System.out.println("토요일");
			
		}
		 
		 System.out.println("weekNo: " + weekNo); // 요일번호 : 일(1), 월(2) ... , 토(7)
		 
		 
		 
		 
		 // 오전/오후, 시, 분, 초
		 int ampm = cal.get(Calendar.AM_PM);         // 오전(0), 오후(1)
		 int hour12 = cal.get(Calendar.HOUR);        // 시(1 ~ 12)
		 int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 시(0 ~ 23)
		 int minute = cal.get(Calendar.MINUTE);      // 분(0 ~ 59)
		 int second = cal.get(Calendar.SECOND);      // 초(0 ~ 59)
		 
		 switch (ampm) {
		case 0 : System.out.println("오전");break;
		case 1 : System.out.println("오후");break;
		}
		 System.out.println("시간 : " + hour12);
		 System.out.println("시간 : " + hour24);
		 System.out.println("분   : " + minute);
		 System.out.println("초   : " + second);
		 
		 
		 //timeStamp
		 
		 long timeStamp = cal.getTimeInMillis();
		 System.out.println(timeStamp);
		 
	}

}
