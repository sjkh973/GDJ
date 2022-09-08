package service;

import domain.ContactDTO;

public interface ContactService {
	
	public void addContact(ContactDTO contact);
	public void modifyContact(ContactDTO contact);
	public void deleteContact(int contact_no);
	public void findContactByNo(int contact_no);
	public void findAllContacts(); 
}
