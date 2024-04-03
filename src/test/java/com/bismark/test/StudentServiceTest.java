package com.bismark.test;

import com.bismark.test.com.bismark.Student;
import com.bismark.test.com.bismark.StudentRepository;
import com.bismark.test.com.bismark.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void testAddStudent() {
        Student newStudent = new Student();
        newStudent.setName("assah");
        newStudent.setEmail("assah@yahoo.com");

    //set up student repository mock to return the newstudent when save() is called k
                when(studentRepository.save(newStudent)).thenReturn(newStudent);

        Student actualStudent = studentService.addStudent(newStudent);

        Assertions.assertEquals(newStudent, actualStudent);

        //verifying that the student repository.save() was called with the newstudent

        verify(studentRepository).save(newStudent);
    }
}
