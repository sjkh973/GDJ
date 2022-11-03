package com.gdu.app07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdu.app07.domain.ContactDTO;
import com.gdu.app07.repository.ContactDAO;


public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactDAO dao;
	
	@Override
	public List<ContactDTO> findAllContact() {
		// TODO Auto-generated method stub
		return dao.selectAllContacts();
	}

	@Override
	public ContactDTO findContactByNo(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addContact(ContactDTO contact) {
		// TODO Auto-generated method stub
		return dao.insertContact(contact);
	}

	@Override
	public int modifyContact(ContactDTO contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeContact(ContactDTO contact) {
		// TODO Auto-generated method stub
		return 0;
	}

}
