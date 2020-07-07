package com.wurui.controller.dashboard.core;

import com.wurui.business.core.service.ICorePostService;
import com.wurui.repository.core.domain.CorePost;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.wurui.commons.base.BaseController;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author WuRui
 * @since 2020-07-07
 */
@RestController
@RequestMapping("core/post")
public class CorePostController extends BaseController<CorePost, ICorePostService> {

}
