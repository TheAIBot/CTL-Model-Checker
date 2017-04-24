@echo off
for %%X in (javac.exe) do (set FOUND=%%~$PATH:X)
IF not defined FOUND (echo Make sure jdk is installed and is put in the environment variable
	goto :eof)
set incorrect_input=false
IF [%1] == [] set incorrect_input=true 
IF [%2] == [] set incorrect_input=true
IF %incorrect_input%==true (
	echo Calls should be on form "antlr While test.while"
	goto :eof
)
IF %1 == Calculator (
	java -jar %~dp0lib\antlr-3.5-complete.jar .\src\calculator\Calculator.g
	javac -sourcepath .\src\calculator -cp .\lib\*.jar .\src\calculator\Calculator.java -d bin
	java -cp .\lib\antlr-3.5-complete.jar;.\bin Calculator ".\test\%2"
) ELSE (
	IF %1 == While (
		java -jar %~dp0lib\antlr-3.5-complete.jar .\src\while_language\parsing\WhileLanguage.g
		javac -sourcepath .\src -cp .\lib\*.jar .\src\while_language\WhileLanguage.java -d bin
		java -cp .\lib\antlr-3.5-complete.jar;.\bin while_language.WhileLanguage ".\test\%2"
	) 
)

