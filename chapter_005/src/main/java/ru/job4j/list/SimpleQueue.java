package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleStack in;
    private SimpleStack out;

    public SimpleQueue() {
        this.in = new SimpleStack<>();
        this.out = new SimpleStack<>();
    }

    public T poll() {
        if (this.out.getSize() == 0) {
            while (this.in.getSize() != 0) {
                this.out.push(in.poll());
            }
        }
        T result = null;
        if (this.out.getSize() != 0) {
            result = (T) this.out.poll();
        }
        return result;
    }

    public void push(T value) {
        this.in.push(value);
    }

//    in 3-2-1  3 2 1
//    out 1-2-3
}
