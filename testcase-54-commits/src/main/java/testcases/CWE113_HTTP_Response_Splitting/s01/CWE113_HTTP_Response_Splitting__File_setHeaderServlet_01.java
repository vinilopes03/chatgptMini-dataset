/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__File_setHeaderServlet_01.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-01.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: File Read data from file (named c:\data.txt)
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__File_setHeaderServlet_01 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Method implementation will be added in subsequent commits
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Method implementation will be added in subsequent commits
    }
}