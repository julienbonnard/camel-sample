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

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.camel.CamelContext;
import org.apache.camel.core.osgi.OsgiDefaultCamelContext;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component(
        name = "io.yupiik.camel.sample.fintech.platform.entrypoint.accounts.context",
        immediate = true
)
public class AccountsCamelContext {

    private OsgiDefaultCamelContext camelContext;
    private ServiceRegistration<CamelContext> serviceRegistration;

    @Activate
    public void activate(ComponentContext context) throws Exception {
        camelContext = new OsgiDefaultCamelContext(context.getBundleContext());
        camelContext.setName("fintech-accounts");
        camelContext.start();
        camelContext.getRegistry().bind("provider.jackson", new JacksonJsonProvider());
        camelContext.getRegistry().bind("swagger", new Swagger2Feature());
        camelContext.addRoutes(new AccountsRoute());
        serviceRegistration = context.getBundleContext().registerService(CamelContext.class, camelContext, null);
    }

    @Deactivate
    public void deactivate() throws Exception {
        serviceRegistration.unregister();
        camelContext.removeRouteDefinitions(camelContext.getRouteDefinitions());
        camelContext.stop();
    }

}
