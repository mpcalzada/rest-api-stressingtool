package com.ks.reporting;

import com.ks.client.model.TransactionRequest;
import com.ks.lib.Configuracion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Report
{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

    public static Report getInstance()
    {
        return ourInstance;
    }

    private static Report ourInstance = new Report();
    private static FileWriter fileWriter;

    private Report()
    {
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy-HH:mm");
            fileWriter = new FileWriter(new File(Configuracion.getRutaConfiguracion() + "/" + "Report-" + dateFormat.format(new Date()) + ".csv"));
            fileWriter.write("trxID,response,time,error");
        }
        catch (Exception e)
        {
            System.out.println("Error al crear el reporte de respuestas debido a: " + Arrays.toString(e.getStackTrace()));
        }
    }

    public void save(TransactionRequest request, String response, boolean error)
    {
        try
        {
            synchronized (fileWriter)
            {
                fileWriter.write(request.getTransactionId() + "," + response + "," + dateFormat.format(new Date()) + "," + error);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error al almacenar en reporte: " + request.getTransactionId() + "," + response + "," + dateFormat.format(new Date()) + "," + error + "\n" + e.getMessage());
        }
    }
}
