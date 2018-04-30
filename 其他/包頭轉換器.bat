@echo off
@title Opcode Convertor
COLOR 8F

set CLASSPATH=.;..\dist\*;..\lib\*;..\*;
java -Dnet.sf.odinms.wzpath=..\wz\ tools.ConvertOpcodes
pause