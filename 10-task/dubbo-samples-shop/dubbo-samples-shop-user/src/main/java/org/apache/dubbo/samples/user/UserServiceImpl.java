/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.samples.user;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.samples.User;
import org.apache.dubbo.samples.UserService;

import java.util.concurrent.ThreadLocalRandom;

@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public boolean register(User user) {
        try {
            // Do something that consumes resources
            for (int i = 0; i < 1000; i++) {
                Math.pow(ThreadLocalRandom.current().nextDouble(10), ThreadLocalRandom.current().nextDouble(5));
            }
            Thread.sleep(ThreadLocalRandom.current().nextInt(100));
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
        return true;
    }

    @Override
    public User login(String username, String password) {
        try {
            // Do something that consumes resources
            for (int i = 0; i < 200; i++) {
                Math.pow(ThreadLocalRandom.current().nextDouble(10), ThreadLocalRandom.current().nextDouble(5));
            }
            Thread.sleep(ThreadLocalRandom.current().nextInt(50));
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone("13912345678");
        user.setMail("dev@dubbo.apache.org");
        user.setRealName("Dubbo Test");
        return user;
    }
}
