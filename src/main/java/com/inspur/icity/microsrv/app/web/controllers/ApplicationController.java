package com.inspur.icity.microsrv.app.web.controllers;

import java.util.HashMap;
import java.util.Map;

import com.inspur.icity.microsrv.app.logic.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/app")
public class ApplicationController{

	@Autowired
	ApplicationService applicationService;

	/******************************************************/
	/******************************************************/
	/******************    手机端使用   *********************/
	/******************************************************/
	/******************************************************/

	/**
	 * 获取当前系统时间，格式yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getSystemTime", method = RequestMethod.POST)
	public String getSystemTimeV20() {

		return "1";
	}

}
