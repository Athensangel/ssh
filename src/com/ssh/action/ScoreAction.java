package com.ssh.action;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ssh.entity.Score;
import com.ssh.service.ScoreService;

public class ScoreAction implements ServletRequestAware {

	private ScoreService scoreService;
	
	HttpServletRequest request;
	
	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * 查询所有分数
	 * @return
	 */
	
	public String findAllScores(){
		List<Score> scoresList = scoreService.queryAllScore(); 
		request.setAttribute("scoresList", scoresList);
		return "scoresList";
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
		
	}

	/**
	 * 删除一条分数
	 * @return
	 */
	public String deleteScore(){
		String id = request.getParameter("id");
		Score score = new Score();
		score.setId(id);
		scoreService.deleteScore(score);
		return "deleteScore";
	}
	/**
	 * 增加一条分数
	 * @return
	 */
	public String saveScores(){
		String score=request.getParameter("score");	
		String courseId=request.getParameter("courseId");
		String stuId=request.getParameter("stuId");
		Score sc = new Score();
		sc.setId(getUUID());
		sc.setScore(Integer.parseInt(score));
		sc.setCourseId(courseId);
		sc.setStuId(stuId);
		scoreService.saveScore(sc);
		return "saveScore";
	}
	
	/**
	 * 获得一个UUID 
	 * @return
	 */
	public String getUUID() {
		  String s = UUID.randomUUID().toString(); 
	      //去掉“-”符号 
	      return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
	}
	/**
	 * 跳转到新增页
	 * @return
	 */
	public String jumpScoreAdd(){
		return "jumpScoreAdd";
	}
	/**
	 * 修改页面
	 * @return
	 */
	public String updateScore(){
		String id=request.getParameter("id");
		String score=request.getParameter("score");	
		String courseId=request.getParameter("courseId");
		String stuId=request.getParameter("stuId");
		Score sc = new Score();
		sc.setId(id);
		sc.setScore(Integer.parseInt(score));
		sc.setCourseId(courseId);
		sc.setStuId(stuId);
		scoreService.updateScore(sc);
		return "updateScore";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String jumpScoreUpdate(){
		String id=request.getParameter("id");
		Score score = new Score();
		score.setId(id);
		Score currentScore = scoreService.updateScoreById(score);
		request.setAttribute("currentScore", currentScore);
		return "jumpScoreUpdate";
	}
}
