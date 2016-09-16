@echo off
title supah git script
color 03
cls
:repe
echo.
git add -A
git commit -a -m "auto-upload" && git push
pause
goto repe
pause