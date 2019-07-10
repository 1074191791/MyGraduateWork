package cn.crms.dubboFilter;

import java.util.List;
import java.util.Properties;

/**
 * @author zhous
 * @create 2019-03-17 11:48
 */
public class IpWhiteList {
    private boolean isEnabled; // 是否启用白名单
    private List<String> allowedIps;//(被)允许的mac列表

    public List<String> getAllowedIps() {
        return allowedIps;
    }

    public void setAllowedIps(List<String> allowedIps) {
        this.allowedIps = allowedIps;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

}
