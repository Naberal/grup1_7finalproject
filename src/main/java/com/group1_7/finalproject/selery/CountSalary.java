package com.group1_7.finalproject.selery;

import com.group1_7.finalproject.model.Event;
import com.group1_7.finalproject.model.Salary;
import com.group1_7.finalproject.model.Worker;
import com.group1_7.finalproject.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class CountSalary {
    @Autowired
    private EventRepository eventRepository;
    private List<Event> events;
    private Salary salary;

    public void countSalaryAndTime() {
        int month = LocalDate.now().getMonthValue() - 1;
        if (month==0)month=12;
        BigDecimal salary = null;
        events = eventRepository.findAllByDate_Month(month);
        for (Event event : events) {
            for (Worker worker : event.getWorkers()) {
                salary = BigDecimal.valueOf(event.getTime().getHour() * worker.getPost().getHourlyRate()
                        * event.getType().getCoefficient());
                //todo if ()
                this.salary.setDate(Date.valueOf(LocalDate.now()));
                this.salary.setSalary(salary);
                this.salary.setTime(event.getTime());
                worker.setSalary(this.salary);
            }
        }
    }
}
