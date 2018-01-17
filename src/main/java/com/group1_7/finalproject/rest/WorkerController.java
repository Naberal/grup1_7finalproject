package com.group1_7.finalproject.rest;

import com.group1_7.finalproject.model.Worker;
import com.group1_7.finalproject.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/worker")
public class WorkerController {
    @Autowired
    private WorkersService workersService;

    @GetMapping(value = "/allWorkers", produces = "application/json")
    public ResponseEntity<List<Worker>> allWorkers() {
        List<Worker> workers =  workersService.getAll();
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Worker> findWorker(@PathVariable UUID id) {
        Worker worker = workersService.getById(id);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @PostMapping("/saveWorker")
    public ResponseEntity saveWorker(@RequestBody Worker worker) {
        workersService.save(worker);
        return new ResponseEntity("Worker saved successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/updateWorker", produces = "application/json")
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

    @DeleteMapping(value = "/{id}/deleteWorker", produces = "application/json")
    public ResponseEntity deleteWorker(@PathVariable UUID id) {
        workersService.delete(id);
        return new ResponseEntity("Worker deleted successfully", HttpStatus.OK);
    }
}
