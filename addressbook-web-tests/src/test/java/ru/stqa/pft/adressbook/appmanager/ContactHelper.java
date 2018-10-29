package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void goToAddContactsPage() {
        click(By.xpath("//a[contains(text(),'add new')]"));
    }

    public void submitContactForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void returnToHomePage() {
        click(By.xpath("//a[contains(text(),'home')]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getPhoneNumber());
        type(By.name("email"), contactData.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void selectContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void acceptContactDeletionAlert() {
        wd.switchTo().alert().accept();
    }

    public void submitContactModificationForm() {
        click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
    }

    public void createContact(ContactData contact, boolean creation) {
        goToAddContactsPage();
        fillContactForm(new ContactData("test1", "test2", "1234567890", "test@test.com", "test1"), true);
        submitContactForm();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    }
}
