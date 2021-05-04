package com.inrythm.app;

import java.util.ArrayList;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @author Raja Rama Racharla
 *
 */

public class testcases {
	
	/**
	 * @author Raja Rama Racharla
	 * Extent reports for a more efficient reporting
	 */
	ExtentReports extentReportContext = new ExtentReports();
	@BeforeTest
	public void config() {
		
		// Extent reports, ExtentSparkReporter
		String path = System.getProperty("user.dir") + "/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("InRythm Pagination");
		reporter.config().setDocumentTitle("Test Results");
		extentReportContext.attachReporter(reporter);
	}
	@Test
	public void testscenarios(){
		ExtentTest test = extentReportContext.createTest("Pagination Test Cases");// Extent reports

		ArrayList<Character> arr = new ArrayList<>();
		arr.add('a');arr.add('b');arr.add('c');arr.add('d');arr.add('e');arr.add('f');
		PaginationHelper<Character> helper = new PaginationHelper(arr, 4);
		
		/**
		 *PageCount
		 *
		 */
		if (helper.pageCount()==2){
			test.pass("PageCount as expected");
		}
		else{
			test.fail("PageCount is Incorrect");
		}
		/**
		 *ItemCount
		 *
		 */
		if(helper.itemCount()==6){
			test.pass("ItemCount as expected");	
		}
		else{
			test.fail("ItemCount is Incorrect");
		}
		/**
		 *PageItemCount
		 *
		 */
		if(helper.pageItemCount(0)==4){
			test.pass("PageItemCount as expected");	
		}
		else{
			test.fail("PageItemCount is Incorrect");
		}
		/**
		 *PageItemCount(1)
		 *
		 */
		if(helper.pageItemCount(1)==2){
			test.pass("PageItemCount(1) as expected");	
		}
		else{
			test.fail("PageItemCount(1) is Incorrect");
		}
		/**
		 *PageItemCount(2)
		 *
		 */
		if(helper.pageItemCount(2)==-1){
			test.pass("PageItemCount(2) as expected");	
		}
		else{
			test.fail("PageItemCount(2) is Incorrect");
		}
		/**
		 *PageIndex(5)
		 *
		 */
		if(helper.pageIndex(5)==1){
			test.pass("PageIndex(5) as expected");	
		}
		else{
			test.fail("PageIndex(5) is Incorrect");
		}
		/**
		 *PageIndex(2)
		 *
		 */
		if(helper.pageIndex(2)==0){
			test.pass("PageIndex(5) as expected");	
		}
		else{
			test.fail("PageIndex(2) is Incorrect");
		}
		/**
		 *PageIndex(20)
		 *
		 */
		if(helper.pageIndex(20)==-1){
			test.pass("PageIndex(20) as expected");	
		}
		else{
			test.fail("PageIndex(20) is Incorrect");
		}
		/**
		 *PageIndex(-10)
		 *
		 */
		if(helper.pageIndex(-10)==-1){
			test.pass("PageIndex(-10) as expected");	
		}
		else{
			test.fail("PageIndex(-10) is Incorrect");
		}
		extentReportContext.flush();// Extent report	
	}
}