/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__Property_addCookieServlet_03.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-03.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: Property Read data from a system property
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

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__Property_addCookieServlet_03 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation will be added in subsequent commits
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation will be added in subsequent commits
    }
}