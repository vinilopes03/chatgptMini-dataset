/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__database_addCookieServlet_11.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-11.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: database Read data from a database
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 11 Control flow: if(IO.staticReturnsTrue()) and if(IO.staticReturnsFalse())
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__database_addCookieServlet_11 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Initial implementation of the bad method
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Initial implementation of the good method
    }
}