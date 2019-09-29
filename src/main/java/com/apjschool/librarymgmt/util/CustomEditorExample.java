package com.apjschool.librarymgmt.util;

import java.beans.PropertyEditorSupport;

public class CustomEditorExample extends PropertyEditorSupport{

	@Override
	public void setAsText(String identificationNo) throws IllegalArgumentException {
		
		setValue("ID-"+identificationNo);
		//super.setAsText(text);
	}
	
	

}
