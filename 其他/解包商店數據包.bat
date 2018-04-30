@echo off
@title Drop Retriever
COLOR 8F

set CLASSPATH=.;..\dist\*;..\lib\*;..\*;
java -server -Dwzpath=..\wz tools.export.ShopAnalyzer
pause