package cn.itcast.ssm.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DataConverter implements Converter<String, Date>{

	public Date convert(String arg0) {
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	       try{
	    	  return format.parse(arg0);
	
	}catch(Exception e){
		
		return null;
	  }
	}

}
