package com.ServiceImpl;

import java.util.Arrays;
import java.util.List;

public class ListAddImpl implements ListStructure {

	@Override
	public List<String> perform(List<String> myList, String argument) {
		// TODO Auto-generated method stub
		myList.add(argument);
		
		return myList;
	}


	
}
