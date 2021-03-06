/*
 * Copyright (C) 2020 - Yupiik SAS - https://www.yupiik.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.yupiik.camel.sample.fintech.platform.entrypoint.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountsProcessor implements Processor {

    private static Logger logger = LoggerFactory.getLogger(AccountsProcessor.class);

    @Override
    public void process(Exchange exchange) {
        String bank = exchange.getMessage().getHeader("X-Fintech-Bank", String.class);
        if (bank != null)
            exchange.getMessage().setHeader("X-Fintech-Route-Redirect", "direct-vm:" + bank);
    }

}
