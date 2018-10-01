package com.ks.configuation;

import com.ks.client.model.TransactionRequest;

import java.util.List;

public class Host
{

    private String ip;
    private String port;
    private String basePath;
    private String hostname;
    private String path;
    private int transactionsPerMinute;
    private List<TransactionRequest> transactions;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getHostname()
    {
        return hostname;
    }

    public void setHostname(String hostname)
    {
        this.hostname = hostname;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public int getTransactionsPerMinute()
    {
        return transactionsPerMinute;
    }

    public void setTransactionsPerMinute(int transactionsPerMinute)
    {
        this.transactionsPerMinute = transactionsPerMinute;
    }

    public List<TransactionRequest> getTransactions()
    {
        return transactions;
    }

    public void setTransactions(List<TransactionRequest> transactions)
    {
        this.transactions = transactions;
    }
}
