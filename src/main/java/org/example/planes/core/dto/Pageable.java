package org.example.planes.core.dto;

import java.util.Objects;

public class Pageable {
    private int page;
    private int size;

    public Pageable() {
    }

    public Pageable(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pageable pageable = (Pageable) o;
        return page == pageable.page && size == pageable.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size);
    }

    @Override
    public String toString() {
        return "Pageable{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
