package org.ldl.study.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.ldl.study.service.IScoreCounter;
import org.springframework.stereotype.Service;

@Slf4j
@Service("counterService")
public class ScoreCounterService implements IScoreCounter {
    @Override
    public void add() {
        log.info("增加积分");
    }
}
