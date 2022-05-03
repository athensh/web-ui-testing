package forgetpassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgetPasswordPage;

import static org.testng.Assert.assertEquals;

public class ForgetPasswordTests extends BaseTests {

    @Test
    public void testRetrievePassword() {
        ForgetPasswordPage forgetPasswordPage = homePage.forgetPassword();
        EmailSentPage emailSentPage = forgetPasswordPage.retrievePassword("tau@example.com");
        assertEquals(emailSentPage.getEmailStatusText(), "Your e-mail's been sent!", "You haven't inserted an email");
    }
}
