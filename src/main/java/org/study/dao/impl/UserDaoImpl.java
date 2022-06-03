package org.study.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.study.dao.IUserDao;
import org.study.entity.User;

@Slf4j
@Repository
public class UserDaoImpl implements IUserDao {

    public UserDaoImpl(){
        log.info("UserDaoImpl 已经被创建");
    }

    @Override
    public void addUser(User user) {
        log.info("userDao addUser 。。。");
    }
}
