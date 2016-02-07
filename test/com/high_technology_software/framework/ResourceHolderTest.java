package com.high_technology_software.framework;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

public class ResourceHolderTest {
	
	@Test
	public final void testResourceHolderString_ExistFile() {
		new ResourceHolder("Test");
		assertTrue(true);
	}
	
	@Test
	public final void testResourceHolderString_NoExistFile() {
		try {
			new ResourceHolder("Test2");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public final void testResourceHolderStringLocale_ExistLocale() {
		new ResourceHolder("Test", Locale.ENGLISH);
		assertTrue(true);
	}
	
	@Test
	public final void testResourceHolderStringLocale_NoExistLocale() {
		try {
			new ResourceHolder("Test", null);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public final void testGetValue_ExistKeyInLocale() {
		ResourceHolder resourceHolder = new ResourceHolder("Test");
		assertEquals(resourceHolder.getValue("key"), "value_en_US");
	}
	
	@Test
	public final void testGetValue_NoExistKeyInLocale() {
		ResourceHolder resourceHolder = new ResourceHolder("Test");
		assertEquals(resourceHolder.getValue("key2"), "value");
	}
	
	@Test
	public final void testGetValue_NoExistKey() {
		ResourceHolder resourceHolder = new ResourceHolder("Test");
		assertEquals(resourceHolder.getValue("key3"), "<¿ Key: 'key3' doesn't exist ?>");
	}

}
