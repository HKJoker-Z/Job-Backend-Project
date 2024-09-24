package com.z2.showZ2.controller;

import com.z2.showZ2.entity.Job;
import com.z2.showZ2.service.JobService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/getAll")
    public List<Job> getAllJobs() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Job> getJobById(@PathVariable("id") Long id) {
        return jobService.findById(id);
    }

    @PostMapping()
    public String addJob(@RequestBody Job job) {
        jobService.save(job);
        return "Job added successfully";
    }

    @CrossOrigin("http://localhost:3000")
    @DeleteMapping("/delete/{id}")
    public String deleteJob(@PathVariable("id") Long id) {
        jobService.deleteById(id);
        return "Job deleted successfully";
    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping("/{id}")
    public String updateJob(@PathVariable("id") Long id, @RequestBody Job job) {
        jobService.updateJobById(id, job);
        return "Job updated successfully";
    }

    @GetMapping("/get3Job")
    public Page<Job> getProducts(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "3") int size) {
        return jobService.getAllProducts(page, size);
    }
}
