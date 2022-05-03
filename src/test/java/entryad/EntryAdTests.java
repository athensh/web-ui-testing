package entryad;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EntryAdPage;

import static org.testng.Assert.assertEquals;

public class EntryAdTests extends BaseTests {

    @Test
    public void testModalWindow() {
        EntryAdPage entryAdPage = homePage.clickEntryAd();
        String bodyText = "It's commonly used to encourage a user to take an action (e.g., give their " +
                "e-mail address to sign up for something or disable their ad blocker).";
        System.out.println(entryAdPage.isModalDisplayed());
        System.out.println("--->" + entryAdPage.getModalBody());
        //, bodyText, "The text of the modal window is incorrect.");
        entryAdPage.clickModalFooter();
    }

}
