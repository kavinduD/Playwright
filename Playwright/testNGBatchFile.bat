set projectLocation=C:\Users\5052\OneDrive - Dialog Pty Ltd\Documents\SampleProjects\AutomationPOCLatest\Playwright
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause