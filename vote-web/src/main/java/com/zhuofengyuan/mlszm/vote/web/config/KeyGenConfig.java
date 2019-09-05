package com.zhuofengyuan.mlszm.vote.web.config;

import com.zhuofengyuan.mlszm.vote.util.keygen.KeyGenerator;
import com.zhuofengyuan.mlszm.vote.util.keygen.UUIDKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * id生成器
 * @author fengtoos
 */
@Configuration
public class KeyGenConfig {

    @Bean
    public KeyGenerator<String> uuidGenerator(){
        return new UUIDKeyGenerator();
    }
}
