@echo off

echo *************** Setting environment variables ***************
pushd %~dp0

FOR /F "eol=; tokens=2,2 delims==" %%i IN ('findstr /i "root" selenium.properties') DO SET ROOT=%%i
FOR /F "eol=; tokens=2,2 delims==" %%i IN ('findstr /i "selenium" selenium.properties') DO SET SELENIUM=%%i
FOR /F "eol=; tokens=2,2 delims==" %%i IN ('findstr /i "chromedriver" selenium.properties') DO SET CHROMEDRIVER=%%i
FOR /F "eol=; tokens=2,2 delims==" %%i IN ('findstr /i "geckodriver" selenium.properties') DO SET GECKODRIVER=%%i
FOR /F "eol=; tokens=2,2 delims==" %%i IN ('findstr /i "iedriver" selenium.properties') DO SET IEDRIVER=%%i

echo ***************** Starting selenium server *****************

cd %ROOT%
java -Dwebdriver.gecko.driver=%GECKODRIVER% -Dwebdriver.chrome.driver=%CHROMEDRIVER%  -Dwebdriver.ie.driver=%IEDRIVER% -jar %SELENIUM% 

:End