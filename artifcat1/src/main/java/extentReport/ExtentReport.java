package extentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport implements ITestListener{

	ExtentTest logger;
	ExtentReports report;//Class variable
	public void onFinish(ITestContext result) {		
		
		report.flush();
        			
        		
    }		

  		
    public void onStart(ITestContext result) {	
    	report=new ExtentReports("C:\\Users\\amalbari\\Desktop\\Extent.html", true);
    	report.addSystemInfo("hostname", "sam");
        		
    }		

    
  	
    public void onTestFailure(ITestResult result) {					
        logger=report.startTest(result.getName());
        logger.assignAuthor("Class: "+result.getTestClass().getName());
        logger.log(LogStatus.FAIL, result.getName()+" is Failed");//Logstatus.pass---
        logger.log(LogStatus.FAIL, result.getThrowable());
        report.endTest(logger);
        
			
        		
    }		

   	
    public void onTestSkipped(ITestResult result) {					
        logger=report.startTest(result.getName());
        logger.assignAuthor("Class: "+result.getTestClass().getName());
        logger.log(LogStatus.SKIP, result.getName()+" is Skipped");//Logstatus.pass---
        report.endTest(logger);
				
        		
    }		


   		
    public void onTestSuccess(ITestResult result) {					
        logger=report.startTest(result.getName());
        logger.assignAuthor("Class: "+result.getTestClass().getName());
        logger.log(LogStatus.PASS, result.getName()+" is Passed");//Logstatus.pass---
        report.endTest(logger);
        		
    }		

    public void onTestStart(ITestResult result) {
    	
    }
	
}
