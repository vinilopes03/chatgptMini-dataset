package testcases.CWE113_HTTP_Response_Splitting.s01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;
import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_03Test {

    @Test
    void testCWE113_HTTPResponseSplitting() throws Exception {
        // Simulate malicious input that could lead to HTTP Response Splitting
        String maliciousInput = "en-US%0d%0aSet-Cookie:evil=1";
        
        // Create an instance of the class under test
        CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_03 instance = new CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_03();
        
        // Mock the HttpServletResponse
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        // Use reflection to set the input for the bad method
        // Since the bad method reads from the console, we will simulate this
        System.setIn(new java.io.ByteArrayInputStream(maliciousInput.getBytes()));

        try {
            // Call the bad method which is expected to be vulnerable
            instance.bad(null, response);
        } catch (Throwable t) {
            fail("Vulnerability fixed or not triggered: Exception occurred");
        }

        // Capture the Cookie that was added to the response
        ArgumentCaptor<Cookie> cookieCaptor = ArgumentCaptor.forClass(Cookie.class);
        verify(response).addCookie(cookieCaptor.capture());
        Cookie added = cookieCaptor.getValue();

        // Check if the added cookie value contains CRLF characters
        boolean isVulnerable = added.getValue().contains("\r") || 
                               added.getValue().contains("\n") || 
                               added.getValue().contains("%0d%0a");
        assertTrue(isVulnerable, 
            "Vulnerability fixed or input sanitized: CRLF not propagated to cookie value");
    }
}