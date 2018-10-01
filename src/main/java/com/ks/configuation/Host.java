package com.ks.configuation;

import com.ks.client.model.TransactionRequest;

import java.util.List;

public class Host
{
    private String hostname;
    private String path;
    private int transactionsPerMinute;
    private List<TransactionRequest> transactions;

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
