package dev.praveen.demo.run;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository){

        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll(){ //Read
        return runRepository.findAll();
    }

    @GetMapping("/{id}")

    Run findById(@PathVariable Integer id){
        Optional<Run> run =  runRepository.findById(id);
        if(run.isEmpty()){
            throw new RunNotFoundException();
        }
        return run.get();
    }
    //post
    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping("")
    void create(@Valid @RequestBody Run run){  //Create
        runRepository.create(run);
    }
    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run,@PathVariable Integer id){ //Update
        runRepository.update(run,id);
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){ //Delete  we used cred properties like create read update delete
        runRepository.delete(id);
    }


}
