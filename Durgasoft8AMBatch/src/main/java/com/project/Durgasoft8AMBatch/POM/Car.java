package com.project.Durgasoft8AMBatch.POM;

public class Car 
{
	String name;
	Engine e;
	
	public void start()
	{
		e=new Engine();
		e.startUp();
		System.out.println("Car starting");
	}
	
	public void stop()
	{
		System.out.println("Car stopping");
	}

}
