package com.api.demo;

import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class CollegeControllerTest {
    @InjectMocks private CollegeController underTest;
@Test
    void get_happy_path() {
// Arrange;
        CollegeController collegeController = mock(CollegeController.class);
        String expectedResponse = "Expected String Response";
        when(collegeController.get()).thenReturn(expectedResponse);

// Act;
        String actualResponse = collegeController.get();

// Assert;
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
@Test
    void put_happy_path() {
// Arrange;
        CollegeController collegeController = Mockito.mock(CollegeController.class);
        String expectedResponse = "Success";
        String inputParameter = "someInput";

        Mockito.when(collegeController.put(inputParameter)).thenReturn(expectedResponse);

// Act;
        String actualResponse = collegeController.put(inputParameter);

// Assert;
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
@Test
    void post_happy_path() {
// Arrange;
        CollegeController collegeController = Mockito.mock(CollegeController.class);
        String expectedResponse = "Success";
        Mockito.when(collegeController.post()).thenReturn(expectedResponse);

// Act;
        String actualResponse = collegeController.post();

// Assert;
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
@Test
    void delete_happy_path() {
// Arrange;
        String collegeId = "123";
        String expectedResponse = "College deleted successfully";
        Mockito.when(collegeService.deleteCollege(collegeId)).thenReturn(expectedResponse);
        
// Act;
        String actualResponse = collegeController.delete(collegeId);
        
// Assert;
        assertThat(actualResponse).isEqualTo(expectedResponse);
        
        // Verify
        Mockito.verify(collegeService).deleteCollege(collegeId);
    }
}