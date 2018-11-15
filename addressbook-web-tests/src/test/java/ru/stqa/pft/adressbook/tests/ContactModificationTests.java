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
           app.contact().create(new ContactData().withFirstName("test1").withLastName("test2").withNumber("1234567890").withEmail("test@test.com").withGroup("test1"), true);
       }
   }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().
                withId(modifiedContact.getId()).withFirstName("test").withLastName("random").withNumber("0000000").withEmail("lol");
        app.contact().modify(contact, false);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
