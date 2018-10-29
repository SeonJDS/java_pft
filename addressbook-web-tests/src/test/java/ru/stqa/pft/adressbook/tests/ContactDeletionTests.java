package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if(! app.getContactHelper().isThereAContact()) { //проверка наличия контакта
            app.getNavigationHelper().gotoGroupPage();
            if(! app.getGroupHelper().isThereAGroup()){ //проверка наличия группы
                app.getGroupHelper().createGroup(new GroupData("test1", null, null));
            }
            app.getContactHelper().createContact(new ContactData("test1", "test2", "1234567890", "test@test.com", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptContactDeletionAlert();
        app.getNavigationHelper().goToHomePage();
    }
}
