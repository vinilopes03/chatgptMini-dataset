/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__database_setHeaderServlet_03.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-03.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: database Read data from a database
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
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

public class CWE113_HTTP_Response_Splitting__database_setHeaderServlet_03 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (5 == 5) // Always true
        {
            data = ""; // Initialize data
            // Read data from a database
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try
            {
                connection = IO.getDBConnection();
                preparedStatement = connection.prepareStatement("select name from users where id=0");
                resultSet = preparedStatement.executeQuery();
                data = resultSet.getString(1); // POTENTIAL FLAW
            }
            catch (SQLException exceptSql)
            {
                IO.logger.log(Level.WARNING, "Error with SQL statement", exceptSql);
            }
            finally
            {
                // Close database objects
                try { if (resultSet != null) resultSet.close(); } catch (SQLException exceptSql) { IO.logger.log(Level.WARNING, "Error closing ResultSet", exceptSql); }
                try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException exceptSql) { IO.logger.log(Level.WARNING, "Error closing PreparedStatement", exceptSql); }
                try { if (connection != null) connection.close(); } catch (SQLException exceptSql) { IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql); }
            }
        }
        if (data != null)
        {
            response.setHeader("Location", "/author.jsp?lang=" + data); // POTENTIAL FLAW
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Method will be implemented later
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}