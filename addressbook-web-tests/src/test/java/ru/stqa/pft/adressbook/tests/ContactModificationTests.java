package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if(! app.getContactHelper().isThereAContact()) { //проверка наличия контакта
            app.getNavigationHelper().gotoGroupPage();
            if(! app.getGroupHelper().isThereAGroup()){ //проверка наличия группы
                app.getGroupHelper().createGroup(new GroupData("test1", null, null));
            }
            app.getContactHelper().createContact(new ContactData("test1", "test2", "1234567890", "test@test.com", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "1234567890", "test@test.com", null), false);
        app.getContactHelper().submitContactModificationForm();
        app.getContactHelper().returnToHomePage();
    }
}
