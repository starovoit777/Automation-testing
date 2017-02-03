# Automation-testing

Started required.

1 make sure specified are correct ways to geckodriver.exe (run on windows)
there are for all operating systems  https://github.com/mozilla/geckodriver/releases

2 go to the project directory of the console and run


"mvn clean test -DsuiteXmlFile=testngByPath.xml"
or
"mvn clean test -DsuiteXmlFile=testngByName.xml"
both file launches all tests


Then you can then open the file index.html which is located in the folder 
target/surefire-reports/TestAllByPath  or target/surefire-reports/TestAllByName
there can be read TestNG reports