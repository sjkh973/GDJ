package com.gdu.app13.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app13.domain.RetireUserDTO;
import com.gdu.app13.domain.UserDTO;

@Mapper
public interface UserMapper {

	public UserDTO selectUserById(String id);
	public RetireUserDTO selectRetireUserById(String id);
	public UserDTO selectUserByEmail(String email);
}
