package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertsTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickTriggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Wrong result text");
    }

    @Test
    public void testGetTextFromAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickTriggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text is incorrect");
    }

    @Test
    public void testSetTextToAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickTriggerPrompt();
        String text = "These aren't the droids youre looking for";
        alertsPage.alert_setText(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "The result is incorrect");
    }
}
