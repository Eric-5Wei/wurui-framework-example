package com.wurui.controller.dashboard.core;

import com.wurui.business.core.service.ICoreAdminService;
import com.wurui.commons.base.BaseController;
import com.wurui.repository.core.domain.CoreAdmin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员
 */
@RestController
@RequestMapping("core/admin")
public class CoreAdminController extends BaseController<CoreAdmin, ICoreAdminService> {

}
