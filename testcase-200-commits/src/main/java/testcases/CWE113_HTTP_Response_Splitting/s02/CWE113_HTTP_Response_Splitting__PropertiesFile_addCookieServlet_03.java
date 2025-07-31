/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__PropertiesFile_addCookieServlet_03.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-03.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: PropertiesFile Read data from a .properties file (in property named data)
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__PropertiesFile_addCookieServlet_03 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = ""; // Initialize data
        Properties properties = new Properties();
        try (FileInputStream streamFileInput = new FileInputStream("../common/config.properties")) {
            properties.load(streamFileInput);
            // POTENTIAL FLAW: Read data from a .properties file
            data = properties.getProperty("data");
        } catch (IOException exceptIO) {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }

        if (data != null) {
            Cookie cookieSink = new Cookie("lang", data);
            // POTENTIAL FLAW: Input not verified before inclusion in the cookie
            response.addCookie(cookieSink);
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Handling good sources and sinks in one method for simplicity
        String data = "foo"; // FIX: Use a hardcoded string
        Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8")); // Good sink with encoding
        response.addCookie(cookieSink); // Safe addition of cookie
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}