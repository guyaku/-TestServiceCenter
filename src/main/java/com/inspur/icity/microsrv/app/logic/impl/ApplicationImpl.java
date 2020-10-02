package com.inspur.icity.microsrv.app.logic.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.inspur.icity.microsrv.base.model.Application;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.inspur.icity.microsrv.base.service.CrudService;
import com.inspur.icity.microsrv.app.logic.repo.ApplicationRepo;
/**
 * 应用相关Service方法
 */
@Service
public class ApplicationImpl extends CrudService<ApplicationRepo,Application,Long> {
}
