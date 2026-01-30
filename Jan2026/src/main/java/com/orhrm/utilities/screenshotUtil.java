package com.orhrm.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotUtil {
	public static String capturescreenshot(WebDriver driver) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String dest="./Screenshots/"+"Screenshot"+"_"+timestamp+".png";
		File destfile=new File(dest);
		FileUtils.copyFile(src, destfile);
		return dest;
	}
}
