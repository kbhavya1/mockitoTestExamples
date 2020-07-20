package com.ServiceImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ListAddImplTest {
	
	@Mock
	private ListStructure listMock;
	
	@InjectMocks
	private ListStructureImpl listStructureImpl;

	@Test
	public void checkListCall() {
		
		
		List<String> myList = Arrays.asList("learn spring","learn react","learn js");
		
		when(listMock.perform(myList, "learn java")).thenReturn(Arrays.asList("learn spring","learn react","learn js","learn java"));
		
		ListStructureImpl listStructureImpl = new ListStructureImpl(listMock);
		
		listStructureImpl.performTask(myList);
		
		
		//check times
		verify(listMock).perform(myList, "new value");
		//verify(listMock).perform(myList, "work with");
		
	}
	
	@Test
	public void checkListCall_argumentCapture() {
		
		//argument capture declare
		
		ArgumentCaptor<String> stringArgumentCapture = ArgumentCaptor.forClass(String.class);		
		ListStructure listMock = mock(ListStructure.class);
		
		List<String> myList = Arrays.asList("learn spring","learn react","learn js");
		
		when(listMock.perform(myList, "learn java")).thenReturn(Arrays.asList("learn spring","learn react","learn js","learn java"));
		
		//ListStructureImpl listStructureImpl = new ListStructureImpl(listMock);
		
		listStructureImpl.performTask(myList);
		
		
		//check times
		verify(listMock).perform(myList, stringArgumentCapture.capture());
		//verify(listMock).perform(myList, "work with");
		
	}
	
	@Test
	public void checkListHamcaster() {
		List<Integer> myList = Arrays.asList(10,20,30,40,90);
		
		assertThat(myList, everyItem(lessThan(100)));
	}


}
