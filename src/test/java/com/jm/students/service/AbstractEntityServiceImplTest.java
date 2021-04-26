package com.jm.students.service;

import com.jm.students.repository.AbstractEntityRepository;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AbstractEntityServiceImplTest {

    private static class AbstractEntityServiceImplStub extends AbstractEntityServiceImpl<AbstractEntity> {

        public AbstractEntityServiceImplStub(AbstractEntityRepository<AbstractEntity> repository) {
            super(repository);
        }
    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class AbstractEntity {
        private final Long id;
    }

    @MockBean
    private AbstractEntityRepository<AbstractEntity> repository;

    AbstractEntityServiceImplStub service;

    @BeforeEach
    public void initService() {
        service = new AbstractEntityServiceImplStub(repository);
    }

    @Test
    void findById() {
        Long id = 1L;

        AbstractEntity entity = new AbstractEntity(id);
        Mockito.when(repository.findById(id)).thenReturn(entity);
        AbstractEntity result = service.findById(id);

        assertEquals(entity, result);
    }

    @Test
    void findAll() {
        List<AbstractEntity> entities = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            entities.add(new AbstractEntity((long) i));
        }

        Mockito.when(repository.findAll()).thenReturn(entities);
        List<AbstractEntity> result = service.findAll();

        assertEquals(entities, result);
    }

    @Test
    void remove() {
        AbstractEntity entity = new AbstractEntity(1L);
        service.remove(entity);
        Mockito.verify(repository, Mockito.times(1)).remove(entity);
    }

    @Test
    void removeById() {
        Long id = 1L;
        service.removeById(id);
        Mockito.verify(repository, Mockito.times(1)).removeById(id);
    }

    @Test
    void isExistById() {
        Long id = 1L;
        List<AbstractEntity> entities = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            entities.add(new AbstractEntity((long) i));
        }


        Mockito.when(repository.isExistById(id))
                .thenReturn(entities.contains(new AbstractEntity(id)));

        assertTrue(service.isExistById(id));
    }

    @Test
    void save() {
        AbstractEntity entity = new AbstractEntity(1L);
        service.save(entity);
        Mockito.verify(repository, Mockito.times(1)).save(entity);
    }

    @Test
    void update() {
        AbstractEntity entity = new AbstractEntity(1L);
        service.update(entity);
        Mockito.verify(repository, Mockito.times(1)).update(entity);
    }
}