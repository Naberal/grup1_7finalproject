package com.group1_7.finalproject.selery;

import com.group1_7.finalproject.model.Event;
import com.group1_7.finalproject.model.Worker;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CountSelery {

    public BigDecimal countSeleryAndTime(Event event) {
        BigDecimal selery= null;
        for (Worker worker : event.getWorkers()) {
            if (LocalDate.now().getDayOfMonth() == 1) {
                worker.setTime(null);
            }
            selery = BigDecimal.valueOf(event.getTime().getHour() * worker.getPost().getHourlyRate()
            *event.getType().getCoefficient());
            worker.setTime(worker.getTime().plusHours(event.getTime().getHour()));
        }

        return selery;
    }
}
