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
    }

    public void start() throws InterruptedException
    {
        for (Host host : configurationData.getHosts())
        {
            for (TransactionRequest transactionRequest : host.getTransactions())
            {
                for (int second = 0; second < host.getStressingSeconds(); second++)
                {
                    for (int tranNumber = 1; tranNumber <= host.getTransactionsPerSecond(); tranNumber++)
                    {
                        System.out.println("Sending transaction to " + host.getHostname() + " numero :" + tranNumber);
                        new Thread(() -> this.send(transactionRequest, host.getPath(), host)).start();
                    }
                    Thread.sleep(1000);
                }
            }
            Thread.sleep(40000);
        }
    }

    private void send(TransactionRequest request, String hostPath, Host host)
    {
        try
        {
            final ApiClient apiClient;
            final TransactionsApi transactionsApi;
            final Object untypedResponse;

            transactionCount++;
            request.setTransactionId(String.format("%012d", transactionCount));

            apiClient = new ApiClient();
            apiClient.setBasePath("http://" + host.getIp() + ":" + host.getPort() + host.getBasePath());

            transactionsApi = new TransactionsApi(apiClient);

            System.out.println("Enviando transaction id: " + request.getTransactionId());
            untypedResponse = transactionsApi.genericPost(request, hostPath);
            System.out.println(untypedResponse.toString());
        }
        catch (Exception e)
        {
            System.out.println("Error transaction id: " + request.getTransactionId() + "Error: " + e.getMessage());

        }
    }
}
