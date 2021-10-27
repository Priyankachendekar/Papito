package com.testingshastra.util;
import static com.testingshastra.util.PropertiesFile.getObject;
//STATIC FINAL USED SO CAPITAL LETTER USED
public class Locator {
	public static final String SIGNUP_FULLNAME = getObject("signup.fullname");
	public static final String SIGNUP_COMPANYNAME =getObject("signup.companyName");
	public static final String SIGNUP_EMAILID = getObject("signup.emailid");
	public static final String SIGNUP_MOBILENUMBER = getObject("signup.mobilenumber");
	public static final String SIGNUP_PASSWORD = getObject("signup.password");
	public static final String SIGNUP_RECAPTCHA = getObject("signup.iamnotrobot");
	public static final String SIGNUP_BUTTON = getObject("signup.button");
	

}
