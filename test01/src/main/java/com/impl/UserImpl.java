package com.impl;

import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserImpl extends JpaRepository<User,String> {

}
