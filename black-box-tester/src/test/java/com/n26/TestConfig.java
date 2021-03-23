package com.n26;

import com.typesafe.config.Config;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor()
public class TestConfig implements Config {

    @Delegate(types = Config.class)
    private final Config delegate;

    public String getDefaultTimeoutMilSec() {
        return delegate.getString("defaultTimeoutMilSec");
    }

    public String getPetStoreURL() {
        return delegate.getString("petstoreURL");
    }

    public String getAppiumURL() {
        return delegate.getString("appiumURL");
    }

    public String getDeviceName() {
        return delegate.getString("deviceName");
    }

    public String getPlatformName() {
        return delegate.getString("platformName");
    }

    public String getApkPath() {
        return delegate.getString("apkPath");
    }
}
