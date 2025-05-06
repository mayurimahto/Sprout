package com.sprout.servlets;

import java.util.*;
import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;

@WebServlet(urlPatterns="/hinbhiuveofnwjkhfvbiuwoncdlhno", loadOnStartup=1)
public class SproutInit extends HttpServlet
{
	public void __getSproutServices(String classesFolder, String childFolder, List<String> list)
	{
	}

	public List<String> getSproutServices(String classesFolder)
	{
		List<String> list=new ArrayList<String>();
		__getSproutServices(classesFolder,"",list);
		return list;
	}

	@Override
	public void init()
	{
		//following 2 lines to extract path pf pur context name folder
		ServletContext servletContext=getServletContext();
		String pth=servletContext.getRealPath(".");
		String classesFolderPath=pth+File.separator+"WEB-INF"+File.separator+"classes";
		List<String> services=getSproutServices(classesFolderPath);
		for(String s:services) System.out.println(s);
	}
}