package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "1234567890", "test@test.com", null), false);
        app.getContactHelper().submitContactModificationForm();
        app.getContactHelper().returnToHomePage();
    }
}
