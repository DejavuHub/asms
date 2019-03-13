package com.asms.service.impl;

import com.asms.dao.LoginDAO;
import com.asms.pojo.User;
import com.asms.service.LoginService;
import com.asms.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDAO loginDAO;
    @Transactional(readOnly = true)
    public User login(User user){
        user.setPassword(MD5.getMD5(user.getPassword()));
        return loginDAO.findUser(user);
    }
}
