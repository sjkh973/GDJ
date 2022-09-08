package controller;

import java.util.Scanner;

import domain.ContactDTO;
import service.ContactService;
import service.ContactServiceImpl;


public class ContactController {
	/***************************** Field ****************************/
	
	// 입력을 위한 Scanner 클래스
	// ContactService 호출을 담당
	private Scanner sc;
	private ContactService contactService;
	
	/***************************** Constructor ****************************/
	public ContactController() {
		sc= new Scanner(System.in);
		contactService = new ContactServiceImpl(); 
	}
	
	/***************************** Method ****************************/
	
	public void menu() {
		System.out.println("1.연락처등록");
		System.out.println("2.연락처수정");
		System.out.println("3.연락처삭제");
		System.out.println("4.연락처조회");
		System.out.println("5.전체연락처");
		System.out.println("0.종료");
		
	}
	
	public void play() {
		int contact_no;
		String name;
		String tel;
		String email;
		ContactDTO contact;
		while(true) {
			menu();
			System.out.println("선택(1 ~ 5, 0) >>>");
			int choice = sc.nextInt(); // 숫자는 choice에 저장
			sc.nextLine();			   // 숫자 입력하고 누른 엔터 처리
			switch(choice) {
			case 1: 
				System.out.println("신규 연락처 이름 >>>");
				name = sc.next();
				System.out.println("신규 연락처 전화번호 >>>");
				tel = sc.next();
				System.out.println("신규 연락처 이메일 >>>");
				email = sc.next();
				contact = new ContactDTO();
				contact.setName(name);
				contact.setTel(tel);
				contact.setEmail(email);
				contactService.addContact(contact);
				break;
			case 2: 
				System.out.println("수정할 연락처 번호 >>>");
				contact_no = sc.nextInt();
				System.out.println("수정할 연락처 이름 >>>");
				name = sc.next();
				System.out.println("수정할 연락처 전화번호 >>>");
				tel = sc.next();
				System.out.println("수정할 연락처 이메일 >>>");
				email = sc.next();
				contact = new ContactDTO();
				contact.setContact_no(contact_no);
				contact.setName(name);
				contact.setTel(tel);
				contact.setEmail(email);
				contactService.modifyContact(contact);
				break;
			case 3: 
				System.out.println("삭제할 연락처 번호 >>>");
				contact_no = sc.nextInt();
				contactService.deleteContact(contact_no);
				break;
			case 4: 
				System.out.println("조회할 연락처 번호 >>>");
				contact_no = sc.nextInt();
				contactService.findContactByNo(contact_no);
				break;
				
			case 5: 
				contactService.findAllContacts();
				break;
			case 0: 
				System.out.println("연락처 프로그램을 종료합니다.");
				return;
			default : System.out.println("다시 선택하세요.");
			}
			 
		}
		
		
	}
}
