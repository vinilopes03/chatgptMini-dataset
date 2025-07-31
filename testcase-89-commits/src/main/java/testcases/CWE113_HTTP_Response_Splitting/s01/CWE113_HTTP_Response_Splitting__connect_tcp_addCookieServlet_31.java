/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__connect_tcp_addCookieServlet_31.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks: addCookieServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to addCookie()
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__connect_tcp_addCookieServlet_31 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // To be implemented
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // To be implemented
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}