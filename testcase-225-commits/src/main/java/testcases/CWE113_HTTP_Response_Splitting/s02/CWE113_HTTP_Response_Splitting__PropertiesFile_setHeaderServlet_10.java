/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__PropertiesFile_setHeaderServlet_10.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-10.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: PropertiesFile Read data from a .properties file (in property named data)
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 10 Control flow: if(IO.staticTrue) and if(IO.staticFalse)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s02;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__PropertiesFile_setHeaderServlet_10 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // Method to implement bad case
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // Method to implement good case
    }

    // Other methods for various good and bad cases will be added later
}