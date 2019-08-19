package ru.job4j.collections.banktest;

import org.junit.Test;
import ru.job4j.bank.Account;
import ru.job4j.bank.User;
import ru.job4j.bank.Bank;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 19.08.2019.
 */
public class BankTest {

    /**
     * тест на удаление аккуанта.
     */
    @Test
    public void whenDeleteAccount() {
        Bank obj = new Bank();
        obj.addUser(new User("Igor", "EN1458654"));
        Account a = new Account(1000.0, "value1");
        Account b = new Account(500.0,  "value2");
        obj.addAccountToUser("EN1458654", a);
        obj.addAccountToUser("EN1458654", b);
        obj.deleteAccountFromUser("EN1458654", a);
        Account ac = obj.getUserAccounts("EN1458654").get(0);
        String result = ac.getRequisites();
        String expect = "value2";
        assertThat(result, is(expect));
    }

    /**
     * тест на false перевода.
     */
    @Test
    public void whenfalseTransferMoney() {
        Bank obj = new Bank();
        obj.addUser(new User("Igor", "EN1458654"));
        obj.addUser(new User("Vasya", "EN1458654425"));
        Account a = new Account(1000.0, "value1");
        Account b = new Account(500.0,  "value2");
        Account c = new Account(1500.0,  "value3");
        obj.addAccountToUser("EN1458654", a);
        obj.addAccountToUser("EN1458654", b);
        obj.addAccountToUser("EN1458654425", c);
        boolean result = obj.transferMoney("EN1458654", "value2", "EN1458654425",
                "value3", 2000);
        boolean expect = false;
        assertThat(result, is(expect));
    }

    /**
     * тест на true перевода.
     */
    @Test
    public void whenFalseTransferMoney() {
        Bank obj = new Bank();
        obj.addUser(new User("Igor", "EN1458654"));
        obj.addUser(new User("Vasya", "EN1458654425"));
        Account a = new Account(1000.0, "value1");
        Account b = new Account(500.0,  "value2");
        Account c = new Account(1500.0,  "value3");
        obj.addAccountToUser("EN1458654", a);
        obj.addAccountToUser("EN1458654", b);
        obj.addAccountToUser("EN1458654425", c);
        obj.transferMoney("EN1458654", "value2", "EN1458654425",
                "value3", 500.0);
        double result = obj.getUserAccounts("EN1458654425").get(0).getValue();
        double expect = 2000.0;
        assertThat(result, is(expect));
    }
}
