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
       app.goTo().goToHomePage();
       if(app.contact().all().size() == 0) { //проверка наличия контакта
           app.goTo().groupPage();
           if(app.group().all().size() == 0){ //проверка наличия группы
               app.group().create(new GroupData().withName("test1"));
           }
           app.contact().create(new ContactData().withFirstName("test1").withLastName("test2").withHomePhone("1234567890").withHomePhone("22222").withWorkPhone("3331231").withEmail("test@test.com").withGroup("test1"), true);
       }
   }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().
                withId(modifiedContact.getId()).withFirstName("test").withLastName("random").withHomePhone("125890").withEmail("lol");
        app.contact().modify(contact, false);
        assertEquals(app.contact().count(), before.size());
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
