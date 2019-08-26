package com.ks;

import com.google.gson.internal.LinkedTreeMap;
import com.ks.admin.Stats;
import com.ks.client.ApiClient;
import com.ks.client.ApiException;
import com.ks.client.api.TransactionsApi;
import com.ks.client.model.TransactionRequest;
import com.ks.configuation.Configuration;
import com.ks.configuation.ConfigurationData;
import com.ks.configuation.Host;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App
{
    private static final SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss.SSS");

    private static ConfigurationData configurationData = new ConfigurationData();
    private final Scanner scanner = new Scanner(System.in);
    private int cont = 0;

    public static void main(String[] args) throws InterruptedException, IOException
    {
        Configuration.readConfig(args[0]);
        configurationData = ConfigurationData.getInstance();
        Stats.started();
        new App().start();
    }

    private void start() throws InterruptedException, IOException
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
                        Thread.sleep(10);
                    }
                    Thread.sleep(1000);
                }
            }
            Thread.sleep(3000);
            while (Stats.missingTrans())
            {
                if (scanner.nextLine().equalsIgnoreCase("yes"))
                {
                    break;
                }
                Thread.sleep(3000);
            }
        }
        Stats.finished();
        Stats.printResult();
    }

    private void send(TransactionRequest request, String hostPath, Host host)
    {
        try
        {
            final ApiClient apiClient;
            final TransactionsApi transactionsApi;

            apiClient = new ApiClient();
            apiClient.setBasePath("http://" + host.getIp() + ":" + host.getPort() + host.getBasePath());

            transactionsApi = new TransactionsApi(apiClient);
            Stats.newRequest();
            cont++;
            request.setTransactionTimeout(String.valueOf(System.currentTimeMillis() + 28000));
            request.setTransactionId(String.format("%012d", new Random().nextInt(Integer.MAX_VALUE)));
            System.out.println("Request:\t" + cont + " " + request.getTransactionId() + " - " + sd.format(new Date()));
            LinkedTreeMap response = (LinkedTreeMap) transactionsApi.genericPost(request, hostPath);
            Stats.newResponse();
            System.out.println("Response:\t" + request.getTransactionId() + " - " + sd.format(new Date()) + response.toString());
        }
        catch (ApiException e)
        {
            if (e.getResponseBody() != null && e.getResponseBody().contains("Transaccion duplicada"))
            {
                Stats.newDuplicated();
            }
            else
            {
                Stats.newError();
            }
            System.out.println("Error transaction id: " + request.getTransactionId() + "Error: " + e.toString() + e.getResponseBody() + e.toString());
        }
        catch (Exception e)
        {
            Stats.newError();
            System.out.println("Generic error transaction id: " + request.getTransactionId() + "Error: " + e.toString() + e.getMessage());
        }
    }
}
