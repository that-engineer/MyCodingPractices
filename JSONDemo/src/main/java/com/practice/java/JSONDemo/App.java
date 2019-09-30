package com.practice.java.JSONDemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class App 
{
    public static void main( String[] args )
    {
        JSONReadWrite jrw = new JSONReadWrite();
      //  jrw.JSONWrite();
        jrw.JSONRead();
        
		/*
		 * String s = ""; s= s+'a'; System.out.println(s);
		 */
    }
}
