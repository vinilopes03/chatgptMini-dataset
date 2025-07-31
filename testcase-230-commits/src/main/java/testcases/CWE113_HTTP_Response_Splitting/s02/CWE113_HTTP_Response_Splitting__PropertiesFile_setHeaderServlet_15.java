/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__PropertiesFile_setHeaderServlet_15.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: PropertiesFile Read data from a .properties file (in property named data)
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 15 Control flow: switch(6) and switch(7)
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

public class CWE113_HTTP_Response_Splitting__PropertiesFile_setHeaderServlet_15 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation remains unchanged
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
    }

    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation remains unchanged
    }

    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation remains unchanged
    }

    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation remains unchanged
    }

    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation remains unchanged
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}