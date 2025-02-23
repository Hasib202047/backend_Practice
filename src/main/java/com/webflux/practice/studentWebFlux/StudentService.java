/*
package com.webflux.practice.studentWebFlux;

import com.webflux.practice.response.Response;
import com.webflux.practice.response.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Mono<Response> createStudent(Student student)
    {
        return studentRepository.save(student).map(student1 -> ResponseBuilder.getSuccessResponse(HttpStatus.OK,"Created",student1));
    }

    public Mono<Response> getById(Integer id)
    {
        return studentRepository.findById(id).map(student -> ResponseBuilder.getSuccessResponse(HttpStatus.OK,"Created",student))
                .switchIfEmpty(Mono.just(ResponseBuilder.getSuccessResponse(HttpStatus.NOT_FOUND, "Student not found", null)));
    }

    public Mono<Response> getAll() {
        return studentRepository.findAll()
                .collectList()  // Convert Flux<Student> to Mono<List<Student>>
                .map(studentList -> ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Fetched successfully", studentList));
    }

    public Mono<Response> updateStudent(Integer id, Student student) {
        return studentRepository.findById(id)
                .flatMap(existingStudent -> {
                    existingStudent.setStudentName(student.getStudentName());
                    existingStudent.setDeptName(student.getDeptName());
                    return studentRepository.save(existingStudent)
                            .map(updatedStudent -> ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Updated successfully", updatedStudent));
                })
                .switchIfEmpty(Mono.just(ResponseBuilder.getSuccessResponse(HttpStatus.NOT_FOUND, "Student not found", null)));
    }

}
*/
