package com.gj.config;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
* 版本控制
 * @author 赵云
*/
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    //api版本号
    private String apiVersion;
    private static final String HEADER_VERSION = "version";
    public ApiVersionCondition(String apiVersion) {
        this.apiVersion = apiVersion;
    }
    /**
    * 将不同的筛选条件进行合并
    */
    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiVersionCondition(other.getApiVersion());
    }
    /**
    * 版本比对，用于排序
    */
    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        //优先匹配最新版本号
        return compareTo(other.getApiVersion(),this.apiVersion)?1:-1;
    }
    /**
    * 根据request的header版本号进行查找匹配的筛选条件
    */
    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        String version = request.getHeader(HEADER_VERSION);
        if(version!= null){
            if (compareTo(version,this.apiVersion)){
                return this;
            }
        }
        return null;
    }
    private boolean compareTo(String version1,String version2){
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        for (int i = 0; i < split1.length; i++) {
            if (Integer.parseInt(split1[i])<Integer.parseInt(split2[i])){
                return false;
            }
        }
        return true;
    }
    public String getApiVersion() {
        return apiVersion;
    }
}