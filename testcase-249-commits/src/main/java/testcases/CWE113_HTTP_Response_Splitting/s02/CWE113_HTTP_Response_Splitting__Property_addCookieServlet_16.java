/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__Property_addCookieServlet_16.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: Property Read data from a system property
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__Property_addCookieServlet_16 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation will be added in next commits
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation will be added in next commits
    }
}