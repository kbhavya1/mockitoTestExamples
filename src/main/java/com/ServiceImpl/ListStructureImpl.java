package com.ServiceImpl;

import java.util.List;

public class ListStructureImpl {
	
	private ListStructure listStructure;
	
	
	public ListStructureImpl(ListStructure listStructure) {
		super();
		this.listStructure = listStructure;
	}



	public boolean performTask(List<String> myList) {
		
		String argument = "work with";
		
		List<String> responseList = this.listStructure.perform(myList, argument);
		
		if(responseList.contains(argument))
			return true;
		else
			return false;
		
	}

}
