package com.sb.eatery.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.eatery.algorithmimpl.EateryUtility;
import com.sb.eatery.exception.InvalidInputSourceException;

/**
 * Service Implementation of Eatery Utility which accepts Input file in the
 * form of String or java.io.File
 * 
 * @author mguduru
 *
 */
@Service
public class EateryService {
	@Autowired
	EateryUtility eateryUtility;

	/**
	 * 
	 * method to load input file from reference filepath
	 * 
	 * @param refFilePath
	 * @return integer
	 */
	public Integer loadAndExecuteFromRefPath(String refFilePath) {
		try {
			return loadAndExecuteFromAbsolutePath(getClass().getClassLoader().getResource(refFilePath).getFile());
		} catch (NullPointerException e) {
			throw new InvalidInputSourceException(e);
		}
	}

	/**
	 * 
	 * method to load input file using absolutepath
	 * 
	 * @param absoluteFilePath
	 * @return
	 */
	public Integer loadAndExecuteFromAbsolutePath(String absoluteFilePath) {
		return loadAndExecute(new File(absoluteFilePath));
	}

	/**
	 * 
	 * method to read the input file & finds the maximum satisfaction
	 * 
	 * @param file
	 * @return integer
	 */
	public Integer loadAndExecute(File file) {
		try (InputStream stream = new FileInputStream(file)) {
			return eateryUtility.execute(stream);
		} catch (IOException e) {
			throw new InvalidInputSourceException(e);
		}
	}
}
