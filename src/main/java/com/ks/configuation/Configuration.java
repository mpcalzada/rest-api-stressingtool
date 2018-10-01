package com.ks.configuation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ks.lib.Configuracion;

import java.io.File;

public class Configuration
{

    public static void readConfig()
    {
        try
        {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readValue(new File(Configuracion.getRutaConfiguracion() + "\\config.json"), ConfigurationData.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
