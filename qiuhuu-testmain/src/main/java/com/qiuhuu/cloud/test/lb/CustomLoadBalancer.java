package com.qiuhuu.cloud.test.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义的loadBalancer
 * @author : qiuhuu
 * @date : 2020-07-22 11:45
 */
@Component
public class CustomLoadBalancer implements LoadBalancer {

    /**
     * 原子计数
     */
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 定义一个自旋锁，得到数据并返回真实值
     * @return
     */
    public final int getAndIncrement(){
        int current,next;
        do{
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        return next;
    }
    /**
     * 负载均衡算法：rest接口请求次数 % 服务实例总数量 = 调用服务的位置下标
     * 每次重启服务器后 rest接口计数从1开始
     * @author : qiuhuu
     * @date : 2020/7/22 14:50
     * @param serviceInstanceList:
     * @return org.springframework.cloud.client.ServiceInstance
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
