package com.ks.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * {@link ColectorTransaction}
 *
 * @author Marco Calzada
 * @version 2.1.2.7
 * @since 26/04/2019
 */
public class ColectorTransaction
{
    @SerializedName("transaction_request")
    private TransactionRequest transactionRequest = null;

    @SerializedName("transaction_response")
    private TransactionResponse transactionResponse = null;

    public ColectorTransaction transactionRequest(TransactionRequest transactionRequest)
    {
        this.transactionRequest = transactionRequest;
        return this;
    }

    /**
     * XReference
     *
     * @return transactionRequest
     **/
    @ApiModelProperty(example = "4444555566667777888", value = "xreference")
    public TransactionRequest getTransactionRequest()
    {
        return transactionRequest;
    }

    public void setTransactionRequest(TransactionRequest transactionRequest)
    {
        this.transactionRequest = transactionRequest;
    }

    public ColectorTransaction transactionResponse(TransactionResponse transactionResponse)
    {
        this.transactionResponse = transactionResponse;
        return this;
    }

    /**
     * XReference
     *
     * @return transactionResponse
     **/
    @ApiModelProperty(example = "4444555666777888", value = "card_number")
    public TransactionResponse getTransactionResponse()
    {
        return transactionResponse;
    }

    public void setTransactionResponse(TransactionResponse transactionResponse)
    {
        this.transactionResponse = transactionResponse;
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
        ColectorTransaction colectorTransaction = (ColectorTransaction) o;
        return Objects.equals(this.transactionRequest, colectorTransaction.transactionRequest) && Objects.equals(this.transactionResponse, colectorTransaction.transactionResponse);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(transactionRequest, transactionResponse);
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class ColectorTransaction {\n");

        sb.append("    transaction_request: ").append(toIndentedString(transactionRequest)).append("\n");
        sb.append("    transaction_response: ").append(toIndentedString(transactionResponse)).append("\n");
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

    public String toSingleLineString()
    {
        return this.toString().replace("\n", "  ");
    }

}
