package com.gdu.app07.service;

import java.util.List;

import com.gdu.app07.domain.ContactDTO;

public interface ContactService {

	public List<ContactDTO> findAllContact();
	public ContactDTO findContactByNo(int no);
	public int addContact(ContactDTO contact);
	public int modifyContact(ContactDTO contact);
	public int removeContact(ContactDTO contact);
	
	
}
