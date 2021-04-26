package com.jm.students.service.pagination;

import com.jm.students.DTO.pagination.PageDTO;
import com.jm.students.repository.pagination.PaginationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class PaginationServiceImpl<T, V> implements PaginationService<T, V>{
    private final Map<String, PaginationRepository<T>> pageBean;

    @Override
    public PageDTO<T> getPageDTO(String methodName, Map<String, Object> parameters) {
        PageDTO<T> pageDTO = new PageDTO<>();
        PaginationRepository<T> paginationDaoBean = pageBean.get(methodName);

        int totalResultCount = paginationDaoBean.getCount(parameters);
        pageDTO.setCurrentPageNumber((int)parameters.get("page"));
        pageDTO.setTotalResultCount(totalResultCount);
        pageDTO.setItemsOnPage((int)parameters.get("size"));
        pageDTO.setItems(paginationDaoBean.getItems(parameters));
        pageDTO.setTotalPageCount((int) Math.ceil(totalResultCount / (double)((int)parameters.get("size"))));

        return pageDTO;
    }
}
