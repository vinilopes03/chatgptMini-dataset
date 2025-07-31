/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__File_addCookieServlet_17.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: File Read data from file (named c:\data.txt)
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__File_addCookieServlet_17 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation will be added in the next commit
    }

    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation will be added in the next commit
    }

    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation will be added in the next commit
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}