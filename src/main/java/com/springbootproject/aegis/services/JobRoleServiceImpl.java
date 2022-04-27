package com.springbootproject.aegis.services;

import com.springbootproject.aegis.dtos.JobRoleDto;
import com.springbootproject.aegis.models.JobRole;
import com.springbootproject.aegis.repositories.JobRoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobRoleServiceImpl implements JobRoleService{
    private final JobRoleRepository repository;

    public JobRoleServiceImpl(JobRoleRepository repository) { this.repository = repository; }

    @Override
    public List<JobRoleDto> getJobRoles() {
        List<JobRole> lj = this.repository.findAll();
        List<JobRoleDto> jobs = new ArrayList<>();

        lj.forEach(j -> jobs.add(new JobRoleDto(j.getId(), j.getName(), j.getUsers())));
        return jobs;
    }
}
