package com.hxqh.eam.common.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.eclipse.jetty.server.Authentication;

/**
 * Created by Ocean lin on 2017/6/30.
 */
public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator =
            new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private final int hashIterations = 2;

//    public void encryptPassword(Authentication.User user) {
//        user.setSalt(randomNumberGenerator.nextBytes().toHex());
//        String newPassword = new SimpleHash(
//                algorithmName,
//                user.getPassword(),
//                ByteSource.Util.bytes(user.getCredentialsSalt()),
//                hashIterations).toHex();
//        user.setPassword(newPassword);
//    }
}
