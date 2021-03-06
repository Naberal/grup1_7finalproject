package com.group1_7.finalproject.selery;

import com.group1_7.finalproject.model.Event;
import com.group1_7.finalproject.model.Salary;
import com.group1_7.finalproject.model.Worker;
import com.group1_7.finalproject.repository.EventRepository;
import com.group1_7.finalproject.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class CountSalary {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    SalaryRepository salaryRepository;
    private List<Event> events;
    private Salary salary;

    public void countSalaryAndTime() {
        BigDecimal salary = null;
        events = eventRepository.findAllByDateAfter(Date.valueOf(LocalDate.now().minusMonths(1)));
        for (Event event : events) {
            for (Worker worker : event.getWorkers()) {
                salary = BigDecimal.valueOf(event.getTime().getHour() * worker.getPost().getHourlyRate()
                        * event.getType().getCoefficient());
                if (salaryRepository.findByDateAfterAndWorkerId(Date.valueOf(LocalDate.now().minusMonths(1)),
                        worker.getId()).equals(this.salary)) {
                    this.salary.setSalary(this.salary.getSalary().add(salary));
                    this.salary.setTime(this.salary.getTime().plusHours(event.getTime().getHour()));
                } else {
                    this.salary.setDate(Date.valueOf(LocalDate.now()));
                    this.salary.setSalary(salary);
                    this.salary.setTime(event.getTime());
                    worker.setSalary(this.salary);
                }
            }
        }
    }
}
