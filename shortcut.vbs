Const strProgramTitle = "Agenda"
Const strProgram = "C:\Agenda\Agenda.exe"
Const strWorkDir = "%USERPROFILE%"
Dim objShortcut, objShell
Set objShell = WScript.CreateObject ("Wscript.Shell")
strLPath = objShell.SpecialFolders ("Desktop")
Set objShortcut = objShell.CreateShortcut (strLPath & "\" & strProgramTitle & ".lnk")
objShortcut.TargetPath = strProgram
objShortcut.WorkingDirectory = strWorkDir
objShortcut.Description = strProgramTitle
objShortcut.Save
WScript.Quit
