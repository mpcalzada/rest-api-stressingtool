/**
 * The <code>Diestel</code> class
 * <p>
 * com.ks.router.model
 * <p>
 * Created on 20/02/2019.
 *
 * @author MarcoCalzada
 */

package com.ks.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

public class Diestel
{

    @SerializedName("phone_number")
    private String phoneNumber = null;

    @SerializedName("sku")
    private String sku = "";

    @SerializedName("commission")
    private String commission = "";

    public Diestel phoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Get phoneNumber
     *
     * @return phoneNumber
     **/
    @ApiModelProperty(example = "001", value = "001")


    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public Diestel comission(String comission)
    {
        this.commission = comission;
        return this;
    }

    /**
     * Get commission
     *
     * @return commission
     **/
    @ApiModelProperty(example = "001", value = "001")


    public String getCommission()
    {
        return commission;
    }

    public void setCommission(String commission)
    {
        this.commission = commission;
    }

    public Diestel sku(String sku)
    {
        this.sku = sku;
        return this;
    }

    /**
     * Get sku
     *
     * @return sku
     **/
    @ApiModelProperty(example = "001", value = "001")


    public String getSku()
    {
        return sku;
    }

    public void setSku(String sku)
    {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Diestel diestel = (Diestel) o;
        return Objects.equals(this.phoneNumber, diestel.phoneNumber) && Objects.equals(this.commission, diestel.commission) && Objects.equals(this.sku, diestel.sku);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.phoneNumber, this.commission, this.sku);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"phone_number\" : \"").append(toIndentedString(phoneNumber)).append("\",\n");
        sb.append("\"commission\" : \"").append(toIndentedString(commission)).append("\",\n");
        sb.append("\"sku\" : \"").append(toIndentedString(sku)).append("\",\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o)
    {
        if (o == null)
        {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
