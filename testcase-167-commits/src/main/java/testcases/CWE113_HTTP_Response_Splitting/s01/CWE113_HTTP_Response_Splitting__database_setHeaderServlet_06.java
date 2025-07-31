/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__database_setHeaderServlet_06.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-06.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: database Read data from a database
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 06 Control flow: if(PRIVATE_STATIC_FINAL_FIVE==5) and if(PRIVATE_STATIC_FINAL_FIVE!=5)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__database_setHeaderServlet_06 extends AbstractTestCaseServlet
{
    private static final int PRIVATE_STATIC_FINAL_FIVE = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // ... (same as previous commit)
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (PRIVATE_STATIC_FINAL_FIVE == 5)
        {
            data = "foo"; // Good source
        }
        else
        {
            data = null; // to avoid compiler errors
        }

        if (data != null)
        {
            response.setHeader("Location", "/author.jsp?lang=" + data); // Potential flaw
        }
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}