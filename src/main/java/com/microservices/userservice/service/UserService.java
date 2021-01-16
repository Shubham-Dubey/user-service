package com.microservices.userservice.service;

import com.microservices.userservice.VO.Department;
import com.microservices.userservice.VO.ResponseTemplateVO;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.repository.UserRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside save User of Service");
        return userRespository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside save getUserWithDepartment of Service");
        ResponseTemplateVO responseTemplateVO= new ResponseTemplateVO();
        User user=userRespository.findByUserId(userId);

        Department department=
                restTemplate.getForObject("http://localhost:9001/departments/"+ user.getDepartmentId(),Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }
}
