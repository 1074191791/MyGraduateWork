package cn.crms.dubboFilter;

import com.alibaba.dubbo.rpc.*;

import java.util.List;

/**
 * @author zhous
 * @create 2019-03-17 11:46
 */
public class WhiteListFilter implements Filter {
    private IpWhiteList ipWhiteList;

    //dubbo通过setter方式自动注入
    public void setIpWhiteList(IpWhiteList ipWhiteList) {
        this.ipWhiteList = ipWhiteList;
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if (!ipWhiteList.isEnabled()) {
            return invoker.invoke(invocation);
        }

        String clientIp = RpcContext.getContext().getRemoteHost();
        List<String> allowedIps = ipWhiteList.getAllowedIps();
        if (allowedIps.contains(clientIp)) {
            return invoker.invoke(invocation);
        } else {
            return new RpcResult();
        }
    }

}
