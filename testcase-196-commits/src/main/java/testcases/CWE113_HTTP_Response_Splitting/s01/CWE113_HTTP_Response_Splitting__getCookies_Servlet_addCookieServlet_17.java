/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__getCookies_Servlet_addCookieServlet_17.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
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

public class CWE113_HTTP_Response_Splitting__getCookies_Servlet_addCookieServlet_17 extends AbstractTestCaseServlet {
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String data;

        data = ""; /* initialize data in case there are no cookies */

        /* Read data from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null) {
                data = cookieSources[0].getValue();
            }
        }

        for (int j = 0; j < 1; j++) {
            if (data != null) {
                Cookie cookieSink = new Cookie("lang", data);
                response.addCookie(cookieSink);
            }
        }
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        for (int j = 0; j < 1; j++) {
            if (data != null) {
                Cookie cookieSink = new Cookie("lang", data);
                response.addCookie(cookieSink);
            }
        }
    }
}