package rahulshettyautomationacademy.SeleniumFrameworkDesignPractice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	public static ExtentReports reportgeneration()
	{
		String path=System.getProperty("user.dir")+( "\\reports\\index.html");
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation Results");
		report.config().setDocumentTitle("Test Results");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Sonaly Panigrahy");
		return extent;
	}
}
