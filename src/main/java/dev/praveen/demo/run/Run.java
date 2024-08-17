package dev.praveen.demo.run;

//import dev.praveen.demo.run.Location;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

//import java.io.Serializable;
import java.time.LocalDateTime;
//import java.util.UUID;

//import static com.sun.imageio.plugins.jpeg.JPEG.version;

public record Run(
        @Id
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location,
        @Version
        Integer version
) {

    public Run {
        if(completedOn != null && startedOn != null && !completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed date should be after started date");
        }
    }

}
