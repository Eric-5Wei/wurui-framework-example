package com.wurui.controller.dashboard.core;

import com.wurui.business.core.service.ICoreUserService;
import com.wurui.commons.base.BaseController;
import com.wurui.repository.core.domain.CoreUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author WuRui
 * @since 2020-07-05
 */
@RestController
@RequestMapping("core/user")
public class CoreUserController extends BaseController<CoreUser, ICoreUserService> {

}
