package com.inspur.icity.microsrv.app.web.controllers;

import java.util.HashMap;
import java.util.Map;

import com.inspur.icity.microsrv.app.logic.service.ApplicationService;
import com.inspur.icity.microsrv.app.logic.constant.BizConstants;
import com.inspur.icity.microsrv.base.web.controllers.AccessBaseController;
import com.inspur.icity.microsrv.core.utils.DateUtil;
import com.inspur.icity.microsrv.base.model.SimpleJsonResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/app")
public class ApplicationController extends AccessBaseController {

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
	public Object getSystemTimeV20() {

		//整理返回值
		SimpleJsonResultModel model = getSimpleJsonResultModel();
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("time", DateUtil.getDateTime());
		model.setData(dataMap);
		//返回值
		model.setCode(BizConstants.RESULT_CODE_NORMAL.KEY);
		model.setMessage(BizConstants.RESULT_CODE_NORMAL.MSG);
		return model;
	}

}
