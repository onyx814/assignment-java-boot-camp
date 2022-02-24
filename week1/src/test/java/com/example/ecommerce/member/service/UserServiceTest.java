package com.example.ecommerce.member.service;

import com.example.ecommerce.core.exception.BaseNotFoundException;
import com.example.ecommerce.member.model.User;
import com.example.ecommerce.member.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Test
    @DisplayName("ค้นหา user ด้วย id = 5  ผลลัพธ์ต้องไม่เป็น null ")
    void findById_Success() {
        //arrange
        User user = new User(5,"แจ่มจันทร์ จริงใจ","moon@gmail.com","09809098767");
        when(userRepository.findById(5)).thenReturn(Optional.of(user));

        //act
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        Optional<User> result = userService.findById(5);

        //assert
       assertNotNull(Optional.of(result));

    }

    @Test
    @DisplayName("ค้นหา user ด้วย id = 4  ต้อง throw exception = 'User id = 4' ")
    void findById_NotFound() {
        //arrange
        User user = new User(5,"แจ่มจันทร์ จริงใจ","moon@gmail.com","09809098767");
        when(userRepository.findById(5)).thenReturn(Optional.of(user));

        //act
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        BaseNotFoundException ex =  assertThrows(BaseNotFoundException.class, ()-> userService.findById(4));

        //assert
        assertTrue(ex.getMessage().contains("User id = 4"));

    }


}