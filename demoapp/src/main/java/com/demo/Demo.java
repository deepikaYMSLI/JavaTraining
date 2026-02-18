package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Demo {
	private static Logger Logger= LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger.info("Code is working till line 10");
		try {
			Integer o = Integer.parseInt("655A");
		} catch(Exception e) {
			Logger.error("String cannot be parsed");
		}
		

	}

}
