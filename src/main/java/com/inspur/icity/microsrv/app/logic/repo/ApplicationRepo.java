package com.inspur.icity.microsrv.app.logic.repo;


import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.inspur.icity.microsrv.base.repo.CrudRepo;
import com.inspur.icity.microsrv.base.model.Application;
import com.inspur.icity.microsrv.base.repo.LogicRepository;

/**
 * 应用相关接口方法
 */
@LogicRepository
public interface ApplicationRepo extends CrudRepo<Application, Long> {
}
