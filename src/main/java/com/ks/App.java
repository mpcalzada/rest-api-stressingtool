package com.ks;

import com.google.gson.internal.LinkedTreeMap;
import com.ks.client.ApiClient;
import com.ks.client.api.TransactionsApi;
import com.ks.client.model.TransactionRequest;
import com.ks.configuation.Configuration;
import com.ks.configuation.ConfigurationData;
import com.ks.configuation.Host;

/**
 * Hello world!
 */
public class App
{

    private static ConfigurationData configurationData = new ConfigurationData();
    private static int transactionCount = 0;


    public static void main(String[] args) throws InterruptedException
    {
        Configuration.readConfig();
        configurationData = ConfigurationData.getInstance();

        new App().start();

        while (true)
        {
            Thread.sleep(5000);
        }
    }

    public void start()
    {
        for (Host host : configurationData.getHosts())
        {
            System.out.println("Sending transaction to " + host.getHostname());

            for (int i = 0; i <= host.getTransactionsPerMinute(); i++)
            {
                for (TransactionRequest transactionRequest : host.getTransactions())
                {
                    new Thread(() -> this.send(transactionRequest, host.getPath())).start();
                    esperar();
                }
            }
        }
    }

    private void send(TransactionRequest request, String hostPath)
    {
        try
        {
            final LinkedTreeMap response;
            final ApiClient apiClient;
            final TransactionsApi transactionsApi;
            final Object untypedResponse;

            transactionCount++;
            request.setTransactionId(String.format("%012d", transactionCount));

            apiClient = new ApiClient();
            apiClient.setBasePath("http://" + configurationData.getIp() + ":" + configurationData.getPort() + configurationData.getBasePath());

            transactionsApi = new TransactionsApi(apiClient);

            System.out.println("Enviando transaction id: " + request.getTransactionId());
            untypedResponse = transactionsApi.genericPost(request, hostPath);

            response = (LinkedTreeMap) untypedResponse;

            System.out.println(response.toString());
        }
        catch (Exception e)
        {
            System.out.println("Error transaction id: " + request.getTransactionId() + "Error: " + e.getMessage());

        }
    }

    private void esperar()
    {
        try
        {
            Thread.sleep(250);
        }
        catch (InterruptedException e)
        {
            System.out.println("Error al esperar");
        }
    }
}
