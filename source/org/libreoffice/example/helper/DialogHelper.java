package org.libreoffice.example.helper;

import com.sun.star.awt.MessageBoxType;
import com.sun.star.awt.XDialog;
import com.sun.star.awt.XMessageBox;
import com.sun.star.awt.XMessageBoxFactory;
import com.sun.star.awt.XToolkit;
import com.sun.star.awt.XWindowPeer;
import com.sun.star.uno.Exception;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;

public class DialogHelper {
	
	public static void showInfoMessage(XComponentContext context, XDialog dialog, String message) {
		showMessageBox(context, dialog, MessageBoxType.INFOBOX, "Info", message);
	}
	
	public static void showWarningMessage(XComponentContext context, XDialog dialog, String message) {
		showMessageBox(context, dialog, MessageBoxType.WARNINGBOX, "Warnung", message);
	}

	public static void showErrorMessage(XComponentContext context, XDialog dialog, String message) {
		showMessageBox(context, dialog, MessageBoxType.ERRORBOX, "Fehler", message);
	}

	public static void showMessageBox(XComponentContext context, XDialog dialog, MessageBoxType type, String sTitle, String sMessage) {
		XToolkit xToolkit;
		try {
			xToolkit = UnoRuntime.queryInterface(XToolkit.class,
						context.getServiceManager().createInstanceWithContext("com.sun.star.awt.Toolkit", context));
		} catch (Exception e) {
			return;
		}
		XMessageBoxFactory xMessageBoxFactory = UnoRuntime.queryInterface(XMessageBoxFactory.class, xToolkit);
		XWindowPeer xParentWindowPeer = UnoRuntime.queryInterface(XWindowPeer.class, dialog);
        XMessageBox xMessageBox = xMessageBoxFactory.createMessageBox(xParentWindowPeer, type,
        		com.sun.star.awt.MessageBoxButtons.BUTTONS_OK, sTitle, sMessage);
        if (xMessageBox == null)
        	return;
        
        xMessageBox.execute();
	}

}
