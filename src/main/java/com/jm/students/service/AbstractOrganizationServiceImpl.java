package com.jm.students.service;

import com.jm.students.model.organization.AbstractOrganization;
import com.jm.students.repository.AbstractOrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AbstractOrganizationServiceImpl implements AbstractOrganizationService {

    private final AbstractOrganizationRepository organizationRepository;

    @Override
    public AbstractOrganization findOne(long id) {
        return organizationRepository.findOne(id);
    }

    @Override
    public List<AbstractOrganization> findAll() {
        return organizationRepository.findAll();
    }

    @Override
    public void create(AbstractOrganization entity) {
        organizationRepository.create(entity);
    }

    @Override
    public AbstractOrganization update(AbstractOrganization entity) {
        return organizationRepository.update(entity);
    }

    @Override
    public void deleteById(long entityId) { organizationRepository.deleteById(entityId); }
}
