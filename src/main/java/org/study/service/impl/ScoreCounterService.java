package org.study.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.dao.IUserDao;
import org.study.entity.User;
import org.study.service.IScoreCounter;
import org.springframework.stereotype.Service;

@Slf4j
@Service("counterService")
public class ScoreCounterService implements IScoreCounter {

    public ScoreCounterService(){
        log.info("ScoreCounterService 已经被创建");
    }

    @Autowired
    private IUserDao userDao;

    @Override
    public void add() {
        User user = new User();
        user.setName("小明");
        user.setAge(3);
        userDao.addUser(user);
    }
}
