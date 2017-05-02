package com.ssh.service;

import java.io.Serializable;
import java.util.List;

import com.ssh.entity.Score;

/**
 * 分数管理Service的增删改查
 * @author Administrator
 *
 */
public interface ScoreService {
	
	public List<Score> queryAllScore();//查询集合
	
	public Serializable saveScore(Score score);//保存一个对象
	
	public void deleteScore(Score score);//删除一个对象
	
	public void updateScore(Score score);//更新一个对象
	
	public Score updateScoreById(Score score);//保存或更新对象
}
