package com.netease.homework;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring/applicationContext-dao.xml",
						"spring/applicationContext-provider.xml",
						"spring/applicationContext-service.xml",
						"spring/applicationContext-trans.xml" });
		System.err.println(context.getDisplayName() + ": here");
		context.start();
		System.err.println("服务已经启动...");
		System.in.read();
	}

}
