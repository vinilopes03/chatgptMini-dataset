/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__Property_addCookieServlet_09.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-09.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: Property Read data from a system property
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 09 Control flow: if(IO.STATIC_FINAL_TRUE) and if(IO.STATIC_FINAL_FALSE)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__Property_addCookieServlet_09 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Initial commit - structure only
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Good method placeholder
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}