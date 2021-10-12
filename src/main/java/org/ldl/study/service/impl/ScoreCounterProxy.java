package org.ldl.study.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.ldl.study.service.IScoreCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service("counterProxy")
public class ScoreCounterProxy implements IScoreCounter {

    @Resource(name = "counterService")
    private ScoreCounterService scoreCounterService;

    @Override
    public void add() {
        scoreCounterService.add();
        log.info("after add score");
    }
}
