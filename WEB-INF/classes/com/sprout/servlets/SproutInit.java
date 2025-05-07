package com.sprout.servlets;

import java.util.*;
import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;

@WebServlet(urlPatterns="/hinbhiuveofnwjkhfvbiuwoncdlhno", loadOnStartup=1)
public class SproutInit extends HttpServlet
{

	public void processClassFile(String className, List<String>list)
	{
		System.out.println("in processClassFile : "+className);
	}
	public void __getSproutServices(String classesFolder, String childFolder, List<String> list)
	{
		File file;
		String updatedPath;
		if(childFolder.length()==0) updatedPath=classesFolder;
		else updatedPath=classesFolder+File.separator+childFolder;

		file=new File(updatedPath);
		File files[]=file.listFiles();
		int x=0;
		String cf;
		String className;
		while(x<files.length)
		{
			if(files[x].isDirectory())
			{
				if(childFolder.length()>0)
				{
					cf=childFolder+File.separator+files[x].getName();
				}
				else
				{
					cf=files[x].getName();
				}
				__getSproutServices(classesFolder, cf, list);
			}
			else if(files[x].getName().endsWith(".class"))
			{
				if(file.separator.equals("\\"))
				{
					className=childFolder.replaceAll("\\\\",".")+"."+files[x].getName();
				}
				else
				{
					className=childFolder.replaceAll(File.separator,".")+"."+files[x].getName();
				}
				className=className.substring(0,className.length()-6);
		
				//if childFolder name is good\great\greatest and name is God then className should be good\great\greatest\God
				
				processClassFile(className, list);
			}
			x++;
		}
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
		String classesFolderPath=pth+File.separator+"Sprout"+"WEB-INF"+File.separator+"classes";
		List<String> services=getSproutServices(classesFolderPath);
		for(String s:services) System.out.println(s);
	}
}