package com.in28minutes;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class ListInterfaceTest {

	@Test
	public void testListSize() {
		
		//given - setup
		List listMock =  mock(List.class);
		when(listMock.size()).thenReturn(2);
		
		//when - actual method call 
		
		
		//then
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void testListSize_multipleValues() {
		List listMock = mock(List.class);
		
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void testListGetMethod() {
		List listMock = mock(List.class);
		
		when(listMock.get(0)).thenReturn(1).thenReturn(2);
		
		assertEquals(1, listMock.get(0));
		assertEquals(2, listMock.get(0));
		//nice mock
		assertEquals(null, listMock.get(1));
		
	}
	
	@Test
	public void testListGetMethod_anyInt() {
		List listMock = mock(List.class);
		
		when(listMock.get(anyInt())).thenReturn(1).thenReturn(2);
		
		assertEquals(1, listMock.get(0));
		assertEquals(2, listMock.get(0));
		//nice mock
		assertEquals(2, listMock.get(1));
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testListGetMethod_throwException() {
		List listMock = mock(List.class);
		
		when(listMock.get(anyInt())).thenReturn(1).thenThrow(new RuntimeException("Something went wrong"));

		assertEquals(1, listMock.get(0));
		
		listMock.get(0);
		
//		assertEquals(1, listMock.get(0));
//		assertEquals(2, listMock.get(0));
//		//nice mock
//		assertEquals(2, listMock.get(1));
		
	}





}
