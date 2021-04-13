package com.jm.students.service;

import com.jm.students.model.organization.AbstractOrganization;
import com.jm.students.repository.AbstractOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class AbstractOrganizationServiceImpl extends AbstractEntityServiceImpl<AbstractOrganization> implements AbstractOrganizationService {

    private final AbstractOrganizationRepository organizationDAO;

    @Autowired
    public AbstractOrganizationServiceImpl(AbstractOrganizationRepository organizationDAO) {
        super(organizationDAO);
        this.organizationDAO = organizationDAO;
    }


}
