/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__getCookies_Servlet_setHeaderServlet_07.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-07.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 07 Control flow: if(privateFive==5) and if(privateFive!=5)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__getCookies_Servlet_setHeaderServlet_07 extends AbstractTestCaseServlet
{
    private int privateFive = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Method implementation will be added in subsequent commits
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Method implementation will be added in subsequent commits
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}