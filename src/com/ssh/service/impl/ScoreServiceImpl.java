package com.ssh.service.impl;

import java.io.Serializable;
import java.util.List;

import com.ssh.biz.BaseDao;
import com.ssh.entity.Score;
import com.ssh.service.ScoreService;

public class ScoreServiceImpl implements ScoreService {

	private BaseDao<Score> oDao;
	

	public BaseDao<Score> getoDao() {
		return oDao;
	}

	public void setoDao(BaseDao<Score> oDao) {
		this.oDao = oDao;
	}

	@Override
	public List<Score> queryAllScore() {
		return oDao.find("from Score");
	}

	@Override
	public Serializable saveScore(Score score) {
		return oDao.save(score);
	}

	@Override
	public void deleteScore(Score score) {
		oDao.delete(score);
	}

	@Override
	public void updateScore(Score score) {
		oDao.update(score);
	}

	@Override
	public Score updateScoreById(Score score) {
		Score s=oDao.get(Score.class,score.getId());
		return s;
	}

}
