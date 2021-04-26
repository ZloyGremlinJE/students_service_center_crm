package com.jm.students.repository.pagination;

import java.util.List;
import java.util.Map;

public interface PaginationRepository<T>  {
    List<T> getItems(Map<String, Object> parameters);
    int getCount(Map<String, Object> parameters);
}
