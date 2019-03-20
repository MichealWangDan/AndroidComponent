package com.dan.libraryrouter.app;

import com.dan.basemodule.ModuleApplication;
import com.dan.libraryrouter.BuildConfig;
import com.dan.libraryrouter.router.RouterConfig;

/**
 * 备注：
 * 作者：wangdan
 * 时间：2019/3/20
 * 包名：com.dan.libraryrouter
 */
public class BaseApplication extends ModuleApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        RouterConfig.init(this, BuildConfig.DEBUG);
    }
}
