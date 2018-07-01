echo off
call shortcutJS.bat -linkfile "%USERPROFILE%\Desktop\MP3 From Youtube.lnk" -target  "%temp%\GetMp3Youtube\Get_MP3_Youtube.exe"
start %temp%\GetMp3Youtube\Get_MP3_Youtube.exe