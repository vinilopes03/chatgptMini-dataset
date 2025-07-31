package testcases.CWE113_HTTP_Response_Splitting.s01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;
import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_06Test {

    @Test
    void testCWE113_HTTPResponseSplitting() throws Exception {
        String maliciousInput = "en-US%0d%0aSet-Cookie:evil=1";
        CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_06 instance = new CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_06();
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);

        // Simulate reading from console by setting the data directly
        // This is a workaround since we cannot read from console in a unit test
        // We will use reflection to set the private variable 'data' in the instance
        java.lang.reflect.Field dataField = CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_06.class.getDeclaredField("data");
        dataField.setAccessible(true);
        dataField.set(instance, maliciousInput);

        try {
            instance.bad(request, response);
        } catch (Throwable t) {
            fail("Vulnerability fixed or not triggered: Exception occurred");
        }

        ArgumentCaptor<Cookie> cookieCaptor = ArgumentCaptor.forClass(Cookie.class);
        verify(response).addCookie(cookieCaptor.capture());
        Cookie added = cookieCaptor.getValue();

        boolean isVulnerable = added.getValue().contains("\r") || 
                             added.getValue().contains("\n") || 
                             added.getValue().contains("%0d%0a");
        assertTrue(isVulnerable, 
            "Vulnerability fixed or input sanitized: CRLF not propagated to cookie value");
    }
}