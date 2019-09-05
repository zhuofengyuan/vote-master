package com.zhuofengyuan.mlszm.vote.util.keygen;

import com.zhuofengyuan.mlszm.vote.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("uuidKeyGenerator")
public class UUIDKeyGenerator implements KeyGenerator<String>{

    @Override
    public synchronized String generateKey() {
        return UUID.UU32();
    }
}
