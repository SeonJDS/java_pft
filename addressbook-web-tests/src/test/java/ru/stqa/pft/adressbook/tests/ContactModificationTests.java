package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
     if (app.db().contacts().size() == 0) {
       app.goTo().groupPage();
       if (app.db().groups().size() == 0) {
         app.group().create(new GroupData().withName("test1"));
       }
       app.contact().create(new ContactData().withFirstName("test1").withLastName("test2").withHomePhone("1234567890")
               .withHomePhone("22222").withWorkPhone("3331231").withEmail("test@test.com"), true);
     }
   }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().
                withId(modifiedContact.getId()).withFirstName("test").withLastName("random").withHomePhone("125890").withEmail("lol");
        app.goTo().goToHomePage();
        app.contact().modify(contact, false);
        assertEquals(app.contact().count(), before.size());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
