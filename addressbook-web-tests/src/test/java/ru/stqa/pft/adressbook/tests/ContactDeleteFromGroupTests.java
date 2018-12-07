package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName(app.contact().uniqueGroupName()).withFooter("test3").withHeader("test3"));
    }
    if (app.db().contacts().size() == 0) {
      ContactData contact = new ContactData().withFirstName("test1").withLastName("test2").withHomePhone("1234567890")
              .withHomePhone("22222").withWorkPhone("3331231").withEmail("test@test.com");
      app.contact().create(contact, true);
    }
    Contacts beforeContacts =  app.db().contacts();
    Groups beforeGroups = app.db().groups();
    ContactData contact = beforeContacts.iterator().next();
    if (contact.getGroups().size() == 0) {
      if (contact.getGroups().size() < beforeGroups.size()) {
        for (GroupData group : beforeGroups) {
          if (!group.getContacts().contains(contact)) {
            app.goTo().groupPage();
            app.contact().addGroup(contact, group);
            break;
          }
        }
      } else {
        GroupData newGroup = new GroupData().withName(app.contact().uniqueGroupName()).withHeader("test2").withFooter("test3");
        app.goTo().groupPage();
        app.group().create(newGroup);
        newGroup.withId(app.db().groups().stream().mapToInt((g) -> g.getId()).max().getAsInt());
        app.contact().addGroup(contact, newGroup);
      }
    }
  }

  @Test
  public void testContactDeleteFromGroup() {
    Groups beforeGroup = app.db().groups();
    Contacts beforeContact = app.db().contacts();

    ContactData contact = beforeContact.iterator().next();
    for (GroupData group : beforeGroup) {
      if (contact.getGroups().contains(group)) {
        app.goTo().goToHomePage();
        app.contact().deleteGroup(contact, group);
        assertThat(app.db().contactById(contact.getId()).iterator().next().getGroups(), equalTo(contact.getGroups().without(group)));
        break;
      }
    }
  }
}
