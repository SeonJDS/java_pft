package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.GroupData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      GroupData group = new GroupData("test1", null, null);
      app.getGroupHelper().createGroup(group);
    }
    app.getContactHelper().createContact(new ContactData("test1", "test2", "1234567890", "test@test.com", "test1"), true);
  }
}
