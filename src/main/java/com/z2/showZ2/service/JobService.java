package com.z2.showZ2.service;

import com.z2.showZ2.entity.Job;
import com.z2.showZ2.respository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }

    public Job save(Job job) {
        return jobRepository.save(job);
    }

    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }

    public void updateJobById(Long id, Job job) {
        jobRepository.save(job);
    }

    //Pagination
    public Page<Job> getAllProducts(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return jobRepository.findAll(pageable);
    }
}
