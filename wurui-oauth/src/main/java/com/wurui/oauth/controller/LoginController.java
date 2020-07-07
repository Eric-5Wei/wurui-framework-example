package com.wurui.oauth.controller;

import com.wurui.commons.response.ResponseResult;
import com.wurui.commons.web.Header;
import com.wurui.oauth.controller.param.LoginParam;
import com.wurui.oauth.service.ILoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录
 */
@RestController
@RequestMapping(value = "login")
public class LoginController {

    @Resource
    private HttpServletRequest request;

    @Resource
    private ILoginService loginService;

    /**
     * 管理员登录
     * @param loginParam {@code JSON} {@link LoginParam}
     * @return {@link ResponseResult}
     */
    @PostMapping("admin")
    public ResponseResult admin(@RequestBody LoginParam loginParam) {
        return ResponseResult.success(loginService.getToken(loginParam.getUsername(), loginParam.getPassword()));
    }

    /**
     * 用户登录，登录只是拿 Token
     * @param loginParam {@code JSON} {@link LoginParam}
     * @return {@link ResponseResult}
     */
    @PostMapping("user")
    public ResponseResult users(@RequestBody LoginParam loginParam) {
        return ResponseResult.success(loginService.getToken(loginParam.getUsername(), loginParam.getPassword()));
    }

    /**
     * 刷新令牌
     * @return {@link ResponseResult}
     */
    @PostMapping("refresh")
    public ResponseResult refresh() {
        String token = Header.getAuthorization(request.getHeader("Authorization"));
        return ResponseResult.success(loginService.refresh(token));
    }
}
