package com.webflux.practice.studentJPA;

import com.webflux.practice.exception.InvalidException;
import com.webflux.practice.exception.NotFoundException;
import com.webflux.practice.response.Response;
import com.webflux.practice.response.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceJpa {
    private final StudentRepositoryJpa studentRepository;

    public StudentServiceJpa(StudentRepositoryJpa studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Response createStudent(StudentJpa student)
    {
        if(student.getStudentName().isEmpty())
        {
            throw new InvalidException("Must input Student Name");
        }
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK,"Created",studentRepository.save(student));
    }

    public Response getById(Integer id) {
        return studentRepository.findById(id)
                .map(studentJpa -> ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Found", studentJpa))
                .orElseThrow(() -> new NotFoundException("Student with ID " + id + " not found"));
    }


    public Response getAll() {
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Fetched successfully", studentRepository.findAll());
    }

}
