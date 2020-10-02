package com.inspur.icity.microsrv.app.logic.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.inspur.icity.microsrv.app.logic.constant.BizConstants;
import com.inspur.icity.microsrv.app.logic.impl.*;
import com.inspur.icity.microsrv.app.logic.model.*;
import com.inspur.icity.microsrv.base.cache.redis.RedisCacheUtil;
import com.inspur.icity.microsrv.base.client.BaseCenterHttpClient;
import com.inspur.icity.microsrv.base.client.OperationCenterHttpClient;
import com.inspur.icity.microsrv.base.client.UserCenterHttpClient;
import com.inspur.icity.microsrv.base.constant.AppDictConstants;
import com.inspur.icity.microsrv.base.constant.BasePlatformRedisConstants;
import com.inspur.icity.microsrv.base.model.Application;
import com.inspur.icity.microsrv.base.model.Dict;
import com.inspur.icity.microsrv.base.model.ManageUser;
import com.inspur.icity.microsrv.base.service.BaseBizService;
import com.inspur.icity.microsrv.base.service.ImageFileCloudUtil;
import com.inspur.icity.microsrv.base.service.UFilePutUtil;
import com.inspur.icity.microsrv.base.utils.BizConfig;
import com.inspur.icity.microsrv.core.utils.*;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import org.apache.commons.codec.binary.Base64;

@Service
public class ApplicationService extends BaseBizService {
    Logger logger = LoggerFactory.getLogger(getClass());

}
