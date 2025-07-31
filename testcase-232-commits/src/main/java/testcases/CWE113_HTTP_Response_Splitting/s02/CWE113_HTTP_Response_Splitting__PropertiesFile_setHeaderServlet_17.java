/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__PropertiesFile_setHeaderServlet_17.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: PropertiesFile Read data from a .properties file (in property named data)
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;

public class CWE113_HTTP_Response_Splitting__PropertiesFile_setHeaderServlet_17 extends AbstractTestCaseServlet {
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String data = ""; /* Initialize data */

        /* retrieve the property */
        Properties properties = new Properties();
        FileInputStream streamFileInput = null;

        try {
            streamFileInput = new FileInputStream("../common/config.properties");
            properties.load(streamFileInput);
            data = properties.getProperty("data"); // POTENTIAL FLAW
        } catch (IOException exceptIO) {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        } finally {
            if (streamFileInput != null) {
                streamFileInput.close();
            }
        }

        if (data != null) {
            response.setHeader("Location", "/author.jsp?lang=" + data); // POTENTIAL FLAW
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String data = "foo"; // FIX: Use a hardcoded string

        if (data != null) {
            response.setHeader("Location", "/author.jsp?lang=" + data); // Still a flaw, but controlled input now
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        mainFromParent(args);
    }
}