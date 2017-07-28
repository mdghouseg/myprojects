package com.sb.eatery;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sb.eatery.exception.InvalidInputSourceException;
import com.sb.eatery.service.EateryService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SBApplicationTests {
	@Autowired
	EateryService service;
	static String absolutePath = null;

	@BeforeClass
	public static void init() {
		absolutePath = SBApplicationTests.class.getClassLoader().getResource("input.txt").getFile();
	}

	@Test
	public void testReadRefFilePath() {
		TestCase.assertEquals(new Integer(2493893), service.loadAndExecuteFromRefPath("input.txt"));
	}

	@Test
	public void testReadFile() {
		TestCase.assertEquals(new Integer(2493893), service.loadAndExecute(new File(absolutePath)));
	}

	@Test
	public void testReadAbsoluteFilePath() {
		TestCase.assertEquals(new Integer(2493893), service.loadAndExecuteFromAbsolutePath(absolutePath));
	}

	@Test(expected = InvalidInputSourceException.class)
	public void testAbsoluteFileDoesnotExist() {
		service.loadAndExecuteFromAbsolutePath("fileThatDoesNotExist.txt");
	}

	@Test(expected = InvalidInputSourceException.class)
	public void testRefFilePathNotExist() {
		service.loadAndExecuteFromRefPath("fileThatDoesNotExist.txt");
	}

	@Test(expected = InvalidInputSourceException.class)
	public void testAbsoluteFilePathNotExist() {
		service.loadAndExecuteFromAbsolutePath("fileThatDoesNotExist.txt");
	}

}
