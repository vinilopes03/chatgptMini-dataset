/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_10.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-10.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: console_readLine Read data from the console using readLine()
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 10 Control flow: if(IO.staticTrue) and if(IO.staticFalse)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;
import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_10 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Placeholder for bad implementation
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Placeholder for good implementation
    }
}