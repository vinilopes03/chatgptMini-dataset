/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__Property_addCookieServlet_17.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: Property Read data from a system property
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s02;
import testcasesupport.*;

import javax.servlet.http.*;

// Class definition
public class CWE113_HTTP_Response_Splitting__Property_addCookieServlet_17 extends AbstractTestCaseServlet
{
    // Bad method that demonstrates HTTP response splitting vulnerability
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        // ... (to be implemented)
    }

    // Good method that demonstrates a safe implementation
    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Calls goodG2B and goodB2G methods (to be implemented)
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}