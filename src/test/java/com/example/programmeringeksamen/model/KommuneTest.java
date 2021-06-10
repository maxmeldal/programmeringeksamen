package com.example.programmeringeksamen.model;

import com.example.programmeringeksamen.service.KommuneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KommuneTest {

    @Test
    void getAveragePositivProcent() {
        Kommune vejle = new Kommune(630L, "Vejle");
        Sogn sogn1 = new Sogn(7975L, "Givskud", vejle, 3.66, LocalDate.of(2021, 06, 03));
        Sogn sogn2 = new Sogn(7985L, "Lindeballe", vejle, 8.14, LocalDate.of(2021, 03, 29));
        Sogn sogn3 = new Sogn(7978L, "Vester", vejle, 10.87, LocalDate.of(2021, 03, 29));
        List<Sogn> sogne = new ArrayList<>();
        sogne.add(sogn1);
        sogne.add(sogn2);
        sogne.add(sogn3);
        vejle.setSogne(sogne);
        double positivProcentActual = 7.5566666666666675;
        assertEquals(vejle.getAveragePositivProcent(), positivProcentActual);
    }
}