package com.wurui.business.core.tests;

import com.wurui.business.core.CoreBusinessApplication;
import com.wurui.business.core.service.ICoreAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreBusinessApplication.class)
public class CoreAdminServiceTests {

    @Resource
    private ICoreAdminService coreAdminService;

    @Test
    public void testConnection(){
        coreAdminService.count();
    }
}
