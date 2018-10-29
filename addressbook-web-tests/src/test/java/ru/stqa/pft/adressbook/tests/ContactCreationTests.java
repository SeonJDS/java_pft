package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goToAddContactsPage();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "1234567890", "test@test.com", "test1"), true);
    app.getContactHelper().submitContactForm();
    app.getContactHelper().returnToHomePage();
  }
}
