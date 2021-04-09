package com.jm.students.repository;


import com.jm.students.model.organization.AbstractOrganization;
import org.springframework.stereotype.Repository;

@Repository
public class AbstractOrganizationRepositoryImpl extends AbstractJpaRepository<AbstractOrganization> implements AbstractOrganizationRepository {
    public AbstractOrganizationRepositoryImpl() {
        super();
        setClazz(AbstractOrganization.class);
    }

}
