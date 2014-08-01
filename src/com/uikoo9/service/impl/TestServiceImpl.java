package com.uikoo9.service.impl;

import org.springframework.stereotype.Service;

import com.uikoo9.service.TestServiceI;

@Service
public class TestServiceImpl implements TestServiceI {
	
	/* (non-Javadoc)
	 * @see com.uikoo9.service.TestServiceI#test()
	 */
	public String test(){
		return "test";
	}
}
