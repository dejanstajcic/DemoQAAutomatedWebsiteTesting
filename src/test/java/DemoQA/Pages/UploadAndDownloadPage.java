package DemoQA.Pages;

import DemoQA.Base.DemoQABaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class UploadAndDownloadPage extends DemoQABaseTest {
    public UploadAndDownloadPage (){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "downloadButton")
    public WebElement downloadButton;
    @FindBy (id = "uploadFile")
    public WebElement chooseFileButton;
    public @FindBy(id = "uploadedFilePath")
    WebElement UploadMsg;
    public void clickOnDownloadButton(){
        downloadButton.click();
    }
    public void clickOnChooseFileButton (){
        chooseFileButton.click();
    }
    public boolean file = false;
    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                dirContents[i].exists();
                file = true;
                break;
            }
        }
        return file;
    }

}
