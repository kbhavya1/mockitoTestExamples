package com.ServiceImpl;

import java.util.List;

public class ListRemovempl implements ListStructure {

	@Override
	public List<String> perform(List<String> myList, String argument) {
		
		myList.remove(0);
		
		return myList;
	}


}
