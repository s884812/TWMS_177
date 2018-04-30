@echo off
@title Buff Information Provider
COLOR 8F

set CLASSPATH=.;..\dist\*;..\lib\*;..\*;
java -client -Dwzpath=..\wz tools.export.BuffInformation
pause