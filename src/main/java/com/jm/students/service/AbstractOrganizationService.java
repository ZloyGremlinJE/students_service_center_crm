package com.jm.students.service;

import com.jm.students.model.organization.AbstractOrganization;
import java.util.List;

public interface AbstractOrganizationService {
    AbstractOrganization findOne(long id);

    List<AbstractOrganization> findAll();

    void create(AbstractOrganization entity);

    AbstractOrganization update(AbstractOrganization entity);

    void deleteById(long entityId);
}
