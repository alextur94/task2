package com.epam.jwd.domain;

import java.util.List;
import java.util.Objects;

/**
 * @autor Aleksey Turkov
 * @version 1.0 (29/08/2021)
 */

public abstract class Text {
    protected Text next;

    public Text(Text next) {
        this.next = next;
    }

    public Text getNext() {
        return next;
    }

    public void setNext(Text next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Text{" +
                "next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(next, text.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next);
    }

    public void splitText(List<String> list, PartOfTheText pot){
    }
}
