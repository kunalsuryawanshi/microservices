package com.micro.user.service;

import com.micro.user.VO.Department;
import com.micro.user.VO.ResponseTemplateVO;
import com.micro.user.entity.User;
import com.micro.user.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public String saveUser(User user) {
        userRepository.save(user);
        return "User Added Successfully";
    }

    public ResponseTemplateVO getUserWithDepartment(int userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = findUserById(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                        Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }

    public User findUserById(int userId) {
        return userRepository.findById(userId).get();
    }
}
