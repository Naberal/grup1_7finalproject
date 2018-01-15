package com.group1_7.finalproject.rest;

import com.group1_7.finalproject.model.Worker;
import com.group1_7.finalproject.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.UUID;

@RestController
@RequestMapping(value ="/worker")
public class WorkerController {
    @Autowired
    private WorkersService workersService;

    @GetMapping(value ="/allWorkers")
    public LinkedList<Worker> allWorkers() {
        LinkedList<Worker> workers = (LinkedList) workersService.getAll();
        return workers;
    }

    @GetMapping(value ="/{id}")
    public Worker findWorker(@PathVariable UUID id) {
        Worker worker = workersService.getById(id);
        return worker;
    }

    @PostMapping("/saveWorker")
    public ResponseEntity saveWorker(@RequestBody Worker worker) {
        workersService.save(worker);
        return new ResponseEntity("Worker saved successfully", HttpStatus.OK);
    }

    @PostMapping(value ="/{id}/updateWorker")
    public ResponseEntity updateWorker(@RequestBody Worker worker, @PathVariable UUID id) {
        Worker updateWorker = workersService.getById(id);
        updateWorker.setFirstName(worker.getFirstName());
        updateWorker.setLastName(worker.getLastName());
        updateWorker.setEmail(worker.getEmail());
        updateWorker.setDepartment(worker.getDepartment());
        updateWorker.setPass(worker.getPass());
        updateWorker.setPost(worker.getPost());
        updateWorker.setRole(worker.getRole());
        workersService.save(updateWorker);
        return new ResponseEntity("Worker update successfully", HttpStatus.OK);
    }

    @DeleteMapping(value ="/{id}/deleteWorker")
    public ResponseEntity deleteWorker(@PathVariable UUID id) {
        workersService.delete(id);
        return new ResponseEntity("Worker deleted successfully", HttpStatus.OK);
    }
}
