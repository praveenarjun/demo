package dev.praveen.demo.run;

import dev.praveen.demo.run.Location;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String name,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {
    public Run {
        if(completedOn != null && startedOn != null && !completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed date should be after started date");
        }
    }
}
