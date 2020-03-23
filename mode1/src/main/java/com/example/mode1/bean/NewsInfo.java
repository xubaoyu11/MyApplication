package com.example.mode1.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: My Application5
 * @Package: com.example.mode1.bean
 * @ClassName: NewsInfo
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/21 11:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/21 11:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class NewsInfo implements Serializable {
    public String desc;
    public String url;
    public List<String> image;
}
