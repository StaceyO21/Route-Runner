package org.launchcode.route_runner.service;

import org.launchcode.route_runner.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired UserRepository userRepository;


}
