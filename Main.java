/* [주석 1 : 과제 설명]

  객체지향프로그래밍 평가과제 (배점 25점)
  학과 : 컴퓨터전자시스템공학부
  학번 : 202000715
  이름 : 김송하

  과제 주제 : 코로나19 백신접종예약시스템
  코로나19와 관련된 주제로 만들어 볼만한 프로그램이 무엇이 있는지 생각해보았다.
  현재 부스터 샷 접종 예약을 하고있다는 기사를 보게되어 백신접종예약시스템을 만들어보자는 생각이 들었다.
  수업시간에 배운 내용을 활용하여 코로나19 백신접종예약시스템을 만들어보았다.

*/

import java.util.InputMismatchException;
import java.util.Scanner;

class Person { 

	private String name; 
	private int ID;

	public Person() {} //매개변수가 없는 생성자

	public void setName(String name){ //setter 함수
		this.name = name;
	}

	public void setID(int ID){ //setter 함수
		this.ID = ID;
	}

	public String getName(){ //getter 함수
		return name;
	}

	public int getID(){ //getter 함수
		return ID;
	}

	public static void print(int id, String name, int vacDate){ //static 메소드
		System.out.print(" ");
	}
}

class Teenager extends Person implements Numbers {//상속, 인터페이스, 다형성
	public static void print(int id, String name, int vacDate){ //메소드 오버라이딩
		System.out.println(id+"년생 "+name+"님 12월 "+vacDate+"일에 예약되었습니다.");
		System.out.println("프로그램이 10초 후에 종료됩니다.");
	}
	public void print(int a){ //메소드 오버로딩, 다형성
		int num = calculate(a);
		System.out.println("< 이번 접종 후 "+num+"회 접종완료입니다. >");
	}
	public int calculate(int number){ // 메소드 재정의
		return number+1;
	}
}

abstract class Adults extends Person { //추상클래스, 상속
	public static void print(int id, String name, int vacDate){ //static 메소드
		System.out.print(" ");
	}
}

class Adults1 extends Adults implements Numbers, IsDate { //상속, 다중인터페이스
	public static void print(int id, String name, int vacDate){ //메소드 오버라이딩, static 메소드
		System.out.println(id+"년생 "+name+"님 12월 "+vacDate+"일에 예약되었습니다.");
		System.out.println("프로그램이 10초 후에 종료됩니다.");
	}
	public void print(int a){ //메소드 오버로딩
		int num = calculate(a);
		System.out.println("< 이번 접종 후 "+num+"회 접종완료입니다. >");
	}
	public int calculate(int number){ //메소드 재정의
		return number+1;
	}
	public void isDate(int date){ //메소드 재정의
		if (date <= 20){
			System.out.print("예약 가능한 날짜가 아닙니다. 프로그램을 종료합니다.");
			System.exit(0);
		}
	}
}

class Adults2 extends Adults implements Numbers, IsDate {
	public static void print(int id, String name, int vacDate){ //메소드 오버라이딩, static 메소드
		System.out.println(id+"년생 "+name+"님 12월 "+vacDate+"일에 예약되었습니다.");
		System.out.println("프로그램이 10초 후에 종료됩니다.");
	}
	public void print(int a){ //메소드 오버로딩
		int num = calculate(a);
		System.out.println("< 이번 접종 후 "+num+"회 접종완료입니다. >");
	}
	public int calculate(int number){ //메소드 재정의
		return number+1;
	}
	public void isDate(int date){
		if (date >= 21 | date <= 10){ //메소드 재정의
			System.out.print("예약 가능한 날짜가 아닙니다. 프로그램을 종료합니다.");
			System.exit(0);
		}
	}
}

class Adults3 extends Adults implements Numbers, IsDate {
	public static void print(int id, String name, int vacDate){ //메소드 오버라이딩, static 메소드
		System.out.println(id+"년생 "+name+"님 12월 "+vacDate+"일에 예약되었습니다.");
		System.out.println("프로그램이 10초 후에 종료됩니다.");
	}
	public void print(int a){ //메소드 오버로딩
		int num = calculate(a);
		System.out.println("< 이번 접종 후 "+num+"회 접종완료입니다. >");
	}
	public int calculate(int number){ //메소드 재정의
		return number+1;
	}
	public void isDate(int date){ //메소드 재정의
		if (date >= 11){
			System.out.print("예약 가능한 날짜가 아닙니다. 프로그램을 종료합니다.");
			System.exit(0);
		}
	}
}

interface Numbers { //인터페이스
	public int calculate(int number);
}

interface IsDate { //인터페이스
	public void isDate(int date);
}

class MyThread extends Thread{ //상속 스레드
	MyThread(){}
	@Override
	public void run() {
		for(int i = 10 ; i >= 1 ; i-- ) {
			System.out.println(i);
			try  {
				Thread.sleep(1000);
			} catch (Exception e){
				return;
			}
		}
		System.out.println("프로그램을 종료합니다.");
		System.out.println("감사합니다.");
	}
}

class MyThread2 implements Runnable{ //인터페이스 스레드
	MyThread2(){}
	@Override
	public void run() {
		System.out.println("감사합니다.");
		System.exit(0);
	}
}

public class Main { //메인 클래스
	public static void main(String[] args) { //메인함수
		Scanner scanner = new Scanner(System.in);
		int today[] = new int[2];
		System.out.print("오늘의 날짜를 입력해주세요(공백을 기준으로 월/일 순) : ");
		try { //예외처리
			today[0] = scanner.nextInt();
			today[1]= scanner.nextInt();           
		} catch (InputMismatchException e) {
			System.out.println("숫자가 아닙니다.");
			scanner.next();
		}
		if (today[1] <= 0 || today[1] >= 31){
			System.out.print("1 ~ 31일 중에 날짜를 다시 입력해주세요(월/일 순) : ");
			try { //예외처리
				today[0] = scanner.nextInt();
				today[1]= scanner.nextInt();           
			} catch (InputMismatchException e) {
				System.out.println("숫자가 아닙니다. 날짜를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
				Runnable r = new MyThread2();
				Thread t = new Thread(r);
				t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception ex){
					return;
				}
			}
			if (today[1] <= 0 || today[1] >= 31){
				System.out.println("날짜를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
				Runnable r = new MyThread2();
				Thread t = new Thread(r);
				t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception e){
					return;
				}
			}
		}
		int dates[] = new int[32];
		System.out.print("이름을 입력해주세요 : ");
		String name = scanner.next();
		System.out.print("출생년도를 입력해주세요 : ");
		int Id = scanner.nextInt();
		int age = 2021 - Id;
		System.out.print("접종 횟수를 입력해주세요 : ");
		int num = scanner.nextInt();
		if (num < 0){
			System.out.print("접종횟수를 잘못입력하셨습니다. 다시 입력해주세요 : ");
			num = scanner.nextInt();
			if (num < 0){
				System.out.println("접종횟수를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
				Runnable r = new MyThread2();
				Thread t = new Thread(r);
				t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception e){
					return;
				}
			}
		}
		if (num >= 3){
			System.out.println("접종을 완료하셨습니다. 프로그램을 종료합니다.");
			Runnable r = new MyThread2();
			Thread t = new Thread(r);
			t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception e){
					return;
				}
		}
		if (age <= 18) {
			Teenager Teenager = new Teenager(); //객체생성
			Teenager.setName(name);
			Teenager.setID(Id);
			Teenager.print(num);
			System.out.print("1 ~ 31일 중에 접종 받을 날짜를 입력해주세요 : ");
			int vacDate = scanner.nextInt();
			if (vacDate <= 0 || vacDate >= 31){
				System.out.print("1 ~ 31일 중에 접종 받을 날짜를 다시 입력해주세요 : ");
				vacDate = scanner.nextInt();
				if (vacDate <= 0 || vacDate >= 31){
					System.out.println("날짜를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
					Runnable r = new MyThread2();
					Thread t = new Thread(r);
					t.start();
					try { //예외처리
						Thread.sleep(1000);
					} catch (Exception e){
						return;
					}
				}
			}
			Integer date1 = Integer.valueOf(dates[vacDate]); //Wrapper객체 박싱
			int Date1 = date1.intValue(); //Wrapper 객체 언박싱
			if (Date1 == 0){
				int gID = Teenager.getID();
				String gName = Teenager.getName();
				Teenager.print(gID, gName, vacDate);
				MyThread th = new MyThread();
				th.start();
			}
		}
		else if (age > 18 && age <= 49){
			Adults1 adults1 = new Adults1(); //객체생성
			adults1.setName(name);
			adults1.setID(Id);
			adults1.isDate(today[1]);
			adults1.print(num);
			System.out.print("21 ~ 31일 중에 접종 받을 날짜를 입력해주세요 : ");
			int vacDate = scanner.nextInt();
			if (vacDate <= 20 || vacDate >= 31){
				System.out.print("21 ~ 31일 중에 접종 받을 날짜를 다시 입력해주세요 : ");
				vacDate = scanner.nextInt();
				if (vacDate <= 20 || vacDate >= 31){
					System.out.println("날짜를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
					Runnable r = new MyThread2();
					Thread t = new Thread(r);
					t.start();
					try { //예외처리
						Thread.sleep(1000);
					} catch (Exception e){
						return;
					}
				}
			}
			Integer date1 = Integer.valueOf(dates[vacDate]); //Wrapper객체 박싱
			int Date1 = date1.intValue(); //Wrapper 객체 언박싱
			if (Date1 == 0){
				int gID = adults1.getID();
				String gName = adults1.getName();
				adults1.print(gID, gName, vacDate);
				MyThread th = new MyThread();
				th.start();
			}
		}
		else if (age >= 50 && age <= 59){
			Adults2 adults2 = new Adults2(); //객체생성
			adults2.setName(name);
			adults2.setID(Id);
			adults2.isDate(today[1]);
			adults2.print(num);
			System.out.print("11 ~ 20일 중에 접종 받을 날짜를 입력해주세요 : ");
			int vacDate = scanner.nextInt();
			if (vacDate <= 10 || vacDate >= 21){
				System.out.print("11 ~ 20일 중에 접종 받을 날짜를 다시 입력해주세요 : ");
				vacDate = scanner.nextInt();
				if (vacDate <= 10 || vacDate >= 21){
					System.out.println("날짜를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
					Runnable r = new MyThread2();
					Thread t = new Thread(r);
					t.start();
					try { //예외처리
						Thread.sleep(1000);
					} catch (Exception e){
						return;
					}
				}
			}
			Integer date1 = Integer.valueOf(dates[vacDate]); //Wrapper객체 박싱
			int Date1 = date1.intValue(); //Wrapper 객체 언박싱
			if (Date1 == 0){
				int gID = adults2.getID();
				String gName = adults2.getName();
				adults2.print(gID, gName, vacDate);
				MyThread th = new MyThread();
				th.start();
			}
		}
		else {
			Adults3 adults3 = new Adults3(); //객체생성
			adults3.setName(name);
			adults3.setID(Id);
			adults3.isDate(today[1]);
			adults3.print(num);
			System.out.print("1 ~ 10일 중에 접종 받을 날짜를 입력해주세요 : ");
			int vacDate = scanner.nextInt();
			if (vacDate <= 0 || vacDate >= 11){
				System.out.print("1 ~ 10일 중에 접종 받을 날짜를 다시 입력해주세요 : ");
				vacDate = scanner.nextInt();
				if (vacDate <= 0 || vacDate >= 11){
					System.out.println("날짜를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
					Runnable r = new MyThread2();
					Thread t = new Thread(r);
					t.start();
					try { //예외처리
						Thread.sleep(1000);
					} catch (Exception e){
						return;
					}
				}
			}
			Integer date1 = Integer.valueOf(dates[vacDate]); //Wrapper객체 박싱
			int Date1 = date1.intValue(); //Wrapper 객체 언박싱
			if (Date1 == 0){
				int gID = adults3.getID();
				String gName = adults3.getName();
				adults3.print(gID, gName, vacDate);
				MyThread th = new MyThread();
				th.start();
			}
		}
		scanner.close();
	}
}