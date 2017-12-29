package com.group1_7.finalproject.service;

import com.group1_7.finalproject.model.Worker;
import com.group1_7.finalproject.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkersService {
    @Autowired
    private WorkerRepository workerRepository;

    public void save(Worker worker) {
        workerRepository.save(worker);
    }

    public void delete(UUID id) {
        workerRepository.delete(id);
    }

    public List<Worker> getAll() {
        return workerRepository.findAll();
    }

    public Worker getById(UUID id) {
        return workerRepository.findOne(id);
    }

}
