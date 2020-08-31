/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.yupiik.camel.sample.fintech.mock.bankbng;

import org.apache.meecrowave.Meecrowave;
import org.apache.meecrowave.junit.MonoMeecrowave;
import org.apache.meecrowave.testing.ConfigurationInject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@RunWith(MonoMeecrowave.Runner.class)
public class AccountBngTest {

    @ConfigurationInject
    private Meecrowave.Builder configuration;

    @Test
    public void checkConfig() {
        final Client client = ClientBuilder.newClient();
        try {
            String accounts = client.target("http://localhost:" + configuration.getHttpPort())
                    .path("fintech/mock/bankbng/accounts")
                    .request(MediaType.APPLICATION_XML_TYPE)
                    .get(String.class);
            Assert.assertNotNull(accounts);
            Assert.assertTrue(accounts.contains("<accounts>"));

        } finally {
            client.close();
        }
    }

}