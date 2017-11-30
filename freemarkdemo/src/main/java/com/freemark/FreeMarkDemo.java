package com.freemark;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkDemo {
	
	
	public static void main(String[] args) throws IOException, TemplateException {
		User user = new User();
		user.setUsername("wt");
		user.setPassword("wangtao");
		
		String template1 = new String("name=${username}&password=${password}");
		String template = new String("<#if password?length gt 3>${password?substring(0,3)}<#else></#if>");
		
		StringReader reader = new StringReader(template);
		StringWriter writer = new StringWriter();
		
		Template t = new Template(null, reader, null);
		t.process(user, writer);
		
		String result = writer.toString();
		System.out.println(result);
		
	}

}
