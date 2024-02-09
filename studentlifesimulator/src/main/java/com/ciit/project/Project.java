package com.ciit.project;
import java.util.ArrayList;

public class Project {
	private String projectName;
	private int progress = 0;
	private ArrayList<String> components = new ArrayList<String>();

	//---------------------------------------
	//---------------GETTERS-----------------
	//---------------------------------------
	public String getProjectName() {
		return projectName;
	}
	
	public int getProgress() {
		return progress;
	}
	
	public ArrayList<String> getComponents() {
		return components;
	}
	
	//---------------------------------------
	//--------------SETTERS------------------
	//---------------------------------------
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public void setComponents(ArrayList<String> components) {
		this.components = components;
	}


}
