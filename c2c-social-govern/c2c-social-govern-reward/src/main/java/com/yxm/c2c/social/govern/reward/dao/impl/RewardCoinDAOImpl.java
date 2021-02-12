package com.yxm.c2c.social.govern.reward.dao.impl;

import com.yxm.c2c.social.govern.reward.dao.RewardCoinDAO;
import com.yxm.c2c.social.govern.reward.domain.RewardCoin;
import com.yxm.c2c.social.govern.reward.mapper.RewardCoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RewardCoinDAOImpl implements RewardCoinDAO {

    @Autowired
    private RewardCoinMapper rewardCoinMapper;

    @Override
    public void save(RewardCoin rewardCoin) {
        rewardCoinMapper.insert(rewardCoin);
    }
}
