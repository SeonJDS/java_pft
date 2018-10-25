package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptContactDeletionAlert();
        app.getNavigationHelper().goToHomePage();
    }
}
