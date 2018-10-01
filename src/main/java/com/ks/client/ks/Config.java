package com.ks.client.ks;

import com.ks.client.ApiClient;

public class Config
{

    private final String REGX_IP = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
    private final String REGX_HOST = "^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-]*[A-Za-z0-9])$";

    private ApiClient apiClient;
    private String basePath;
    private String protocolo;
    private String puerto;
    private String host;
    private String base;


    public Config(ApiClient apiClient)
    {
        this.apiClient = apiClient;
        basePath = "https://10.21.94.130/ks/km-switch/2.0.0.2";
        protocolo = "https";
        puerto = "";
        host = "10.21.94.130";
        base = "/ks/km-switch/2.0.0.2";
    }


    public void confirm()
    {
        if (puerto.equals(""))
        {
            basePath = protocolo + "://" + host + base;
        }
        else
        {
            basePath = protocolo + "://" + host + ":" + puerto + base;
        }
        apiClient.setBasePath(basePath);
    }

    public void setPuerto(String puerto)
    {
        if (puerto.matches("\\d+") && puerto.length() < 10)
        {
            this.puerto = puerto;
        }
    }

    public void setHost(String host)
    {
        if (host.matches(REGX_HOST) || host.equals(REGX_IP))
        {
            this.host = host;
        }
    }

    public void setBase(String base)
    {
        this.base = base;
    }

    public void setProtocolo(String protocolo)
    {
        if (protocolo.equals("http") || protocolo.equals("https"))
        {
            this.protocolo = protocolo;
        }
    }
}
