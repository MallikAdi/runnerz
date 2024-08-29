package dev.adimallik.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
            throw new RunNotFoundException();
        }
        return run.get();
    }

    // if successfully created we get a 201 created status code
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody Run run){
        runRepository.create(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run,id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }
}
