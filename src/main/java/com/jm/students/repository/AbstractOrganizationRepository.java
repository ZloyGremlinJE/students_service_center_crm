package com.jm.students.repository;


import com.jm.students.model.organization.AbstractOrganization;

import java.util.List;

public interface AbstractOrganizationRepository {
    AbstractOrganization findOne(long id);

    List<AbstractOrganization> findAll();

    void create(AbstractOrganization entity);

    AbstractOrganization update(AbstractOrganization entity);

    void deleteById(long entityId);
}
