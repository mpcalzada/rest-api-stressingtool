package com.ks.configuation;

import java.util.List;

public class ConfigurationData
{
    private static ConfigurationData _INSTANCE = null;
    private String configName;
    private List<Host> hosts;

    public ConfigurationData()
    {
        _INSTANCE = this;
    }

    public static ConfigurationData getInstance()
    {
        return _INSTANCE;
    }

    public String getConfigName()
    {
        return configName;
    }

    public void setConfigName(String configName)
    {
        this.configName = configName;
    }

    public List<Host> getHosts()
    {
        return hosts;
    }

    public void setHosts(List<Host> hosts)
    {
        this.hosts = hosts;
    }
}
