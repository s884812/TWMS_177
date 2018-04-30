@echo off
@title Dump
COLOR 8F

set CLASSPATH=.;..\dist\*;..\lib\*;..\*;
java -server -Dwzpath=..\wz tools.export.CashShop
pause