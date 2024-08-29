package dev.adimallik.runnerz.run;

import dev.adimallik.runnerz.run.Location;
import java.time.LocalDateTime;

public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location
) {}
