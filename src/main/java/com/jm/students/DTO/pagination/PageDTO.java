package com.jm.students.DTO.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T> implements Serializable {
    private int currentPageNumber;
    private int totalPageCount;
    private int totalResultCount;
    private List<T> items;
    private int itemsOnPage = 12;

    @Override
    public String toString() {
        return "PageDto{" +
                "currentPageNumber=" + currentPageNumber +
                ", totalPageCount=" + totalPageCount +
                ", totalResultCount=" + totalResultCount +
                ", items=" + items +
                ", itemsOnPage=" + itemsOnPage +
                '}';
    }
}
