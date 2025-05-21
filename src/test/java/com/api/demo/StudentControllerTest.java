package com.api.demo;

import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @InjectMocks private StudentController underTest;
@Test
    void get_happy_path() {
// Arrange;
        StudentController studentController = Mockito.mock(StudentController.class);
        String expectedResponse = "Student Details";
        Mockito.when(studentController.get()).thenReturn(expectedResponse);

// Act;
        String actualResponse = studentController.get();

// Assert;
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
@Test
    void put_happy_path() {
MockitoAnnotations.openMocks(this); // Initialize mocks;

// Arrange;
        String expectedResponse = "Success";
// Assuming put method takes parameters, replace param1, param2 with actual parameter types and values;
        String param1 = "paramValue1";
        int param2 = 123;

        // Mocking behavior if needed, replace methodCall with actual method call and return value
        Mockito.when(someDependency.methodCall(param1, param2)).thenReturn(expectedResponse);

// Act;
        String actualResponse = studentController.put(param1, param2);

// Assert;
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
}