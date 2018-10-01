package com.ks.configuation;

import java.util.List;

public class ConfigurationData
{
    private static ConfigurationData _INSTANCE = null;
    private String configName;
    private String ip;
    private String port;
    private String basePath;
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

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getPort()
    {
        return port;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public String getBasePath()
    {
        return basePath;
    }

    public void setBasePath(String basePath)
    {
        this.basePath = basePath;
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
