package com.wurui.business.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wurui.business.core.service.ICoreUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wurui.commons.base.BaseServiceImpl;
import com.wurui.commons.exceptions.BusinessException;
import com.wurui.commons.response.ResponseCode;
import com.wurui.repository.core.domain.CoreAdmin;
import com.wurui.repository.core.domain.CoreUser;
import com.wurui.repository.core.mapper.CoreUserMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author WuRui
 * @since 2020-07-05
 */
@Service
public class CoreUserServiceImpl extends BaseServiceImpl<CoreUserMapper, CoreUser> implements ICoreUserService {

    /**
     * 检查字段：账号
     */
    private static final String USERNAME = "username";

    /**
     * 检查字段：昵称
     */
    private static final String NICKNAME = "nickname";

    /**
     * 检查字段：邮箱
     */
    private static final String EMAIL = "email";

    @Override
    public boolean create(CoreUser coreUser) {
        if (!checkUsername(coreUser.getUsername())
                && !checkNickname(coreUser.getNickname())
                && !checkEmail(coreUser.getEmail())) {
            return super.save(coreUser);
        }

        return false;
    }


    @Override
    public IPage<CoreUser> page(int current, int size, CoreUser coreUser) {
        Page<CoreUser> page = new Page<>(current, size);

        // 查询条件
        LambdaQueryWrapper<CoreUser> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(StringUtils.isNotBlank(String.valueOf(coreUser.getId())), CoreUser::getId, coreUser.getId())
                .or().like(StringUtils.isNotBlank(coreUser.getUsername()),CoreUser::getUsername, coreUser.getUsername())
                .or().like(StringUtils.isNotBlank(coreUser.getNickname()),CoreUser::getNickname, coreUser.getNickname())
                .or().like(StringUtils.isNotBlank(coreUser.getEmail()),CoreUser::getEmail, coreUser.getEmail());
        return super.page(page, wrapper);
    }

    // 私有方法 ------------------------------------------- Begin

    /**
     * 检查账号是否存在
     *
     * @param username {@code String} 账号
     * @return {@code boolean} 账号已存在则抛出异常
     */
    private boolean checkUsername(String username) {
        if (checkUniqueness(USERNAME, username)) {
            throw new BusinessException(ResponseCode.USER_HAS_EXISTED);
        }
        return false;
    }

    /**
     * 检查昵称是否存在
     *
     * @param nickname {@code String} 昵称
     * @return {@code boolean} 昵称已存在则抛出异常
     */
    private boolean checkNickname(String nickname) {
        if (checkUniqueness(NICKNAME, nickname)) {
            throw new BusinessException(ResponseCode.USER_NICK_HAS_EXISTED);
        }
        return false;
    }

    /**
     * 检查邮箱是否存在
     *
     * @param email {@code String} 邮箱
     * @return {@code boolean} 邮箱已存在则抛出异常
     */
    private boolean checkEmail(String email) {
        if (checkUniqueness(EMAIL, email)) {
            throw new BusinessException(ResponseCode.USER_EMAIL_HAS_EXISTED);
        }
        return false;
    }
}


