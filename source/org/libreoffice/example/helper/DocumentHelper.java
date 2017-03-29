package org.libreoffice.example.helper;

import com.sun.star.frame.XDesktop;
import com.sun.star.frame.XFrame;
import com.sun.star.frame.XModel;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.text.XTextDocument;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;

public class DocumentHelper {
	
	/** Returns the curerent XDesktop */
	public static XDesktop getCurrentDesktop(XComponentContext xContext) {
		XMultiComponentFactory xMCF = (XMultiComponentFactory) UnoRuntime.queryInterface(XMultiComponentFactory.class,
				xContext.getServiceManager());
        Object desktop = null;
		try {
			desktop = xMCF.createInstanceWithContext("com.sun.star.frame.Desktop", xContext);
		} catch (Exception e) {
			return null;
		}
        return (XDesktop) UnoRuntime.queryInterface(com.sun.star.frame.XDesktop.class, desktop);
	}
	
	/** Returns the current XComponent */
    private static XComponent getCurrentComponent(XComponentContext xContext) {
        return (XComponent) getCurrentDesktop(xContext).getCurrentComponent();
    }
    
    /** Returns the current frame */
    public static XFrame getCurrentFrame(XComponentContext xContext) {
    	XModel xModel = (XModel) UnoRuntime.queryInterface(XModel.class, getCurrentComponent(xContext));
    	return xModel.getCurrentController().getFrame();
    }

    /** Returns the current text document (if any) */
    public static XTextDocument getCurrentDocument(XComponentContext xContext) {
        return (XTextDocument) UnoRuntime.queryInterface(XTextDocument.class, getCurrentComponent(xContext));
    }
}
