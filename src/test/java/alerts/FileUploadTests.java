package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadsPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        FileUploadsPage fileUploadTests = homePage.clickFileUpload();
        String filePath = "C:\\Users\\Athens\\IdeaProjects\\webdriver\\resources\\chromedriver.exe";
        fileUploadTests.uploadFile(filePath);
        assertEquals(fileUploadTests.getUploadedFiles(), "chromedriver.exe", "Wrong file name");

    }
}
