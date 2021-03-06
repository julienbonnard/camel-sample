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
package io.yupiik.camel.sample.fintech.platform.entrypoint.api;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/accounts")
public class AccountsEndpoint {

    @GET
    public List<AccountDetail> getAllAccounts(
            @HeaderParam("X-Request-ID") String requestId,
            @HeaderParam("PSU-IP-Address") String psuIpAddress,
            @HeaderParam("Consent-ID") String consentId,
            @HeaderParam("Authorization") String authorization) {
        return null;
    }

    @GET
    @Path("/{account-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountDetail getAccount(
            @PathParam("account-id") String accountId,
            @HeaderParam("X-Request-ID") String requestId,
            @HeaderParam("PSU-IP-Address") String psuIpAddress,
            @HeaderParam("Consent-ID") String consentId,
            @HeaderParam("Authorization") String authorization) {
        return null;
    }

    @GET
    @Path("/{account-id}/balances")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAccountBalances(
            @PathParam("account-id") String accountId,
            @HeaderParam("X-Request-ID") String requestId,
            @HeaderParam("PSU-IP-Address") String psuIpAddress,
            @HeaderParam("Consent-ID") String consentId,
            @HeaderParam("Authorization") String authorization) {
        return null;
    }

    @GET
    @Path("/{account-id}/transactions")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllAccountTransactions(
            @PathParam("account-id") String accountId,
            @HeaderParam("X-Request-ID") String requestId,
            @HeaderParam("PSU-IP-Address") String psuIpAddress,
            @HeaderParam("Consent-ID") String consentId,
            @HeaderParam("Authorization") String authorization) {
        return null;
    }

    @GET
    @Path("/{account-id}/transactions/{transaction-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccountTransaction(
            @PathParam("account-id") String accountId,
            @PathParam("transaction-id") String transactionId,
            @HeaderParam("X-Request-ID") String requestId,
            @HeaderParam("PSU-IP-Address") String psuIpAddress,
            @HeaderParam("Consent-ID") String consentId,
            @HeaderParam("Authorization") String authorization) {
        return null;
    }
}
