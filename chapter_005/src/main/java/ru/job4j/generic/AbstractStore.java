package ru.job4j.generic;

import java.util.NoSuchElementException;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 13.09.2019.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;

    public AbstractStore(SimpleArray simpleArray) {
        this.simpleArray = simpleArray;
    }

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        for (int i = 0; i < simpleArray.siz(); i++) {
            if (simpleArray.get(i).getId().equals(id)) {
                simpleArray.set(i, model);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < simpleArray.siz(); i++) {
            if (simpleArray.get(i).getId().equals(id)) {
                simpleArray.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (int i = 0; i < simpleArray.siz(); i++) {
            if (simpleArray.get(i).getId().equals(id)) {
                result = simpleArray.get(i);
                break;
            }
        }
        return result;
    }
}