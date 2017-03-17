# LibreOffice Starter Extension

This repository contains some boilerplate code and config you need to get started to build your own LibreOffice Extension.

You can use this project as a starting point to write your own extension for LibreOffice.

## Get started

1. Install [LibreOffice](http://www.libreoffice.org/download) & [LibreOffice SDK](http://www.libreoffice.org/download) (5.0 or greater)
2. Install [Eclipse](http://www.eclipse.org/) & the [LOEclipse plugin](https://github.com/LibreOffice/loeclipse/#installation)
3. [Download](https://github.com/smehrbrodt/libreoffice-starter-extension/archive/master.zip) this starter project & unzip it
4. Import the project in Eclipse (File->Import->Existing Projects into Workspace)
5. Let Eclipse know the paths to LibreOffice & the SDK (Project->Properties->LibreOffice Properties)
6. Setup Run Configuration
  * Go to Run->Run Configurations
  * Create a new run configuration of the type "LibreOffice Application"
  * Select the project
  * Run!
  * *Hint: Show the error log to view the output of the run configuration (Window->Show View->Error Log)*
7. The extension will be installed in LibreOffice and you will see a toolbar and a menu entry have been added to Writer.

## Development Hints
* The entry point is in [StarterProjectImpl.java](https://github.com/smehrbrodt/libreoffice-starter-extension/blob/master/source/org/libreoffice/example/comp/StarterProjectImpl.java).
* Toolbar items and menu entries are defined in [Addons.xcu](https://github.com/smehrbrodt/libreoffice-starter-extension/blob/master/registry/org/openoffice/Office/Addons.xcu).
* Shortcuts are defined in [Accelerators.xcu](https://github.com/smehrbrodt/libreoffice-starter-extension/blob/master/registry/org/openoffice/Office/Accelerators.xcu).
* The position of the toolbar is defined in [WriterWindowState.xcu](https://github.com/smehrbrodt/libreoffice-starter-extension/blob/master/registry/org/openoffice/Office/UI/WriterWindowState.xcu).
* The dialog shown when clicking "Action One" is [ActionOneDialog.xdl](https://github.com/smehrbrodt/libreoffice-starter-extension/blob/master/dialog/ActionOneDialog.xdl). The dialog itself contains information how to edit it.
* The [DialogHelper](https://github.com/smehrbrodt/libreoffice-starter-extension/blob/master/source/org/libreoffice/example/helper/DialogHelper.java) contains lots of helper methods to work with the dialog.
* To debug the Java code, just stick a breakpoint anywhere in Eclipse and start your run configuration in debug mode.
* If you add non-code files (or an external .jar) to your extension, you need to mention them in [package.properties](https://github.com/smehrbrodt/libreoffice-starter-extension/blob/master/package.properties), else they won't be included in the packaged extension.
* Now go on customizing the extension to your needs. You'll find lots of information in the [OpenOffice Wiki](https://wiki.openoffice.org/wiki/Extensions_development).
