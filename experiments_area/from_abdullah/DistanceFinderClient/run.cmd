@echo off
setlocal
cd /d "%~dp0"
set "MAVEN_CMD=%USERPROFILE%\Tools\apache-maven-3.10.1\bin\mvn.cmd"
if exist "%MAVEN_CMD%" goto run
set "MAVEN_CMD=mvn.cmd"
where mvn.cmd >nul 2>&1
if errorlevel 1 (
    echo Maven was not found. Install Maven and add its bin folder to Path.
    exit /b 1
)
:run
call "%MAVEN_CMD%" -q compile exec:java
exit /b %errorlevel%
