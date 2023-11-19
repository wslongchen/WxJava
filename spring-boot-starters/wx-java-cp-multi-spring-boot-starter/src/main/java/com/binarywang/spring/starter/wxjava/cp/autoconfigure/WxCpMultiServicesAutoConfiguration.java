package com.binarywang.spring.starter.wxjava.cp.autoconfigure;

import com.binarywang.spring.starter.wxjava.cp.autoconfigure.services.WxCpInJedisConfiguration;
import com.binarywang.spring.starter.wxjava.cp.autoconfigure.services.WxCpInMemoryConfiguration;
import com.binarywang.spring.starter.wxjava.cp.autoconfigure.services.WxCpInRedisTemplateConfiguration;
import com.binarywang.spring.starter.wxjava.cp.autoconfigure.services.WxCpInRedissonConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 企业微信平台相关服务自动注册
 *
 * @author yl
 * created on 2023/10/16
 */
@Configuration
@RequiredArgsConstructor
@Import({
  WxCpInJedisConfiguration.class,
  WxCpInMemoryConfiguration.class,
  WxCpInRedissonConfiguration.class,
  WxCpInRedisTemplateConfiguration.class
})
public class WxCpMultiServicesAutoConfiguration {
}
