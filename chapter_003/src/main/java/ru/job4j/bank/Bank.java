package ru.job4j.bank;

import java.util.*;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 19.08.2019.
 */
public class Bank {
    private Map<User, List<Account>> map = new LinkedHashMap<>();

    /**
     * добавление пользователя.
     */
    public void addUser(User user) {
        map.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * удаление пользователя.
     */
    public void deleteUser(User user) {
        map.remove(user);
    }

    /**
     * добавить счёт пользователю.
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> user : map.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                user.getValue().add(account);
            }
        }
    }

    /**
     * удалить один счёт пользователя.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> list = findAccountsOnPassport(passport);
        Iterator<Account> iter = list.iterator();
        while (iter.hasNext()) {
            Account com = iter.next();
            if (com.getRequisites().equals(account.getRequisites())) {
                list.remove(com);
            }
        }
    }

    /**
     * получить список счетов для пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> ret = new ArrayList<>();
        for (Map.Entry<User, List<Account>> user : map.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                ret.addAll(user.getValue());
            }
        }
        return ret;
    }

    /**
     * метод для перечисления денег с одного счёта на другой счёт.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String dstRequisite, double amount) {
        Account from = findAccount(findAccountsOnPassport(srcPassport), srcRequisite);
        Account in = findAccount(findAccountsOnPassport(destPassport), dstRequisite);
        return from != null && in != null && from.transfer(in, amount);
    }

    /**
     * метод по поиску аккаунтов по паспорту.
     */
    public List<Account> findAccountsOnPassport(String passport) {
        List<Account> a = new ArrayList<>();
        for (Map.Entry<User, List<Account>> user : map.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                a = user.getValue();
            }
        }
        return a;
    }

    /**
     * метод по поиску Account из списка Account.
     */
    public Account findAccount(List<Account> list, String requisite) {
        Account a = null;
        for (Account user : list) {
            if (user.getRequisites().equals(requisite)) {
                a = user;
            }
        }
        return a;
    }

}
