/*
package com.webflux.practice.studentWebFlux;

import com.webflux.practice.response.Response;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public Mono<Response> create(@RequestBody Student student)
    {
        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Mono<Response> getById(@PathVariable("id") Integer id)
    {
        return studentService.getById(id);
    }

    @GetMapping("getAll")
    public Mono<Response> getAll()
    {
        return studentService.getAll();
    }
}
*/
