package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.goTo().goToHomePage();
        if(! app.getContactHelper().isThereAContact()) { //проверка наличия контакта
            app.goTo().groupPage();
            if(! app.group().isThereAGroup()){ //проверка наличия группы
                app.group().create(new GroupData("test1", null, null));
            }
            app.getContactHelper().createContact(new ContactData("test1", "test2", "1234567890", "test@test.com", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptContactDeletionAlert();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }
}
