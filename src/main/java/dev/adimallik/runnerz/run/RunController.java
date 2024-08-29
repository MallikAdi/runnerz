package dev.adimallik.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    // this constructor sets the local value of runRepository
    // to the instance (Bean) that Spring has w/ it
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
        // some logic here
        return runRepository.findAll();
    }
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);

        if(run.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found.");
        }
        return run.get();
    }
}
