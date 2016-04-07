package org.libreoffice.example.helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import com.sun.star.deployment.PackageInformationProvider;
import com.sun.star.deployment.XPackageInformationProvider;
import com.sun.star.uno.Exception;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;
import com.sun.star.util.XURLTransformer;

public class FileHelper {
	
	final static String DIALOG_RESOURCES = "dialog/";
	
	/**
	 * Returns a path to a dialog file
	 */
	public static File getDialogFilePath(String xdlFile, XComponentContext xContext) {
		return getFilePath(DIALOG_RESOURCES + xdlFile, xContext);
	}
	
	/**
	 * Returns a file path for a file in the installed extension, or null on failure.
	 */
	public static File getFilePath(String file, XComponentContext xContext) {
		XPackageInformationProvider xPackageInformationProvider = PackageInformationProvider.get(xContext);
        String location = xPackageInformationProvider.getPackageLocation("org.libreoffice.example.starterproject");
        Object oTransformer;
		try {
			oTransformer = xContext.getServiceManager().createInstanceWithContext("com.sun.star.util.URLTransformer", xContext);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        XURLTransformer xTransformer = (XURLTransformer)UnoRuntime.queryInterface(XURLTransformer.class, oTransformer);
        com.sun.star.util.URL[] oURL = new com.sun.star.util.URL[1];
        oURL[0] = new com.sun.star.util.URL();
        oURL[0].Complete = location + "/" + file;
        xTransformer.parseStrict(oURL);
        URL url;
        try {
			url = new URL(oURL[0].Complete);
		} catch (MalformedURLException e1) {
			return null;
		}
        File f;
		try {
			f = new File(url.toURI());
		} catch (URISyntaxException e1) {
			return null;
		}
        return f;
	}

}
