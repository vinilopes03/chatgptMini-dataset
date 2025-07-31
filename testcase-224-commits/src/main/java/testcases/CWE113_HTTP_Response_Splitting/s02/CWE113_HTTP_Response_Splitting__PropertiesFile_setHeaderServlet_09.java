/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__PropertiesFile_setHeaderServlet_09.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-09.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: PropertiesFile Read data from a .properties file (in property named data)
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 09 Control flow: if(IO.STATIC_FINAL_TRUE) and if(IO.STATIC_FINAL_FALSE)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__PropertiesFile_setHeaderServlet_09 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Method to be implemented
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Method to be implemented
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}