/*
 * KM Router
 * Allows processing of different types of transactions
 *
 * OpenAPI spec version: 2.0.0.0
 * Contact: atencionclientes@kssoluciones.com.mx
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.ks.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.util.Objects;

/**
 * Pinpad
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-03T18:10:54.088Z")
public class Pinpad
{
    /**
     * &#39;The mode the start in the pinpad&#39; Sort order:   * &#39;00&#39; - Unknown   * &#39;01&#39; - Hand-entered   * &#39;02&#39; - Magnetic stripe   * &#39;03&#39; - Bar code read   * &#39;05&#39; - Chip read, CVV reliable   * &#39;80&#39; - Fall back   * &#39;90&#39; - Magnetic stripe   * &#39;95&#39; - Chip read, CVV not reliable
     */
    @JsonAdapter(EntryMode1Enum.Adapter.class)
    public enum EntryMode1Enum
    {
        _00("00"),

        _01("01"),

        _03("03"),

        _05("05"),

        _80("80"),

        _90("90"),

        _95("95");

        private String value;

        EntryMode1Enum(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }

        public static EntryMode1Enum fromValue(String text)
        {
            for (EntryMode1Enum b : EntryMode1Enum.values())
            {
                if (String.valueOf(b.value).equals(text))
                {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<EntryMode1Enum>
        {
            @Override
            public void write(final JsonWriter jsonWriter, final EntryMode1Enum enumeration) throws IOException
            {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public EntryMode1Enum read(final JsonReader jsonReader) throws IOException
            {
                String value = jsonReader.nextString();
                return EntryMode1Enum.fromValue(String.valueOf(value));
            }
        }
    }

    @JsonAdapter(MitEnum.Adapter.class)
    public enum MitEnum
    {
        _0("0"),

        _1("1"),

        _2("2");

        private String value;

        MitEnum(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return value;
        }

        @Override
        @JsonValue
        public String toString()
        {
            return String.valueOf(value);
        }

        @JsonCreator
        public static MitEnum fromValue(String text)
        {
            for (MitEnum b : MitEnum.values())
            {
                if (String.valueOf(b.value).equals(text))
                {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<MitEnum>
        {
            @Override
            public void write(final JsonWriter jsonWriter, final MitEnum enumeration) throws IOException
            {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public MitEnum read(final JsonReader jsonReader) throws IOException
            {
                String value = jsonReader.nextString();
                return MitEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("mit")
    private MitEnum mit = null;


    @SerializedName("entry_mode_1")
    private EntryMode1Enum entryMode1 = null;

    /**
     * Sort order:   * &#39;0&#39; - Unknown   * &#39;1&#39; - Can accept PIN&#39;s   * &#39;2&#39; - Can´t accept PIN&#39;s   * &#39;8&#39; - PIN pad out of service
     */
    @JsonAdapter(EntryMode2Enum.Adapter.class)
    public enum EntryMode2Enum
    {
        _0("0"),

        _1("1"),

        _2("2"),

        _8("8");

        private String value;

        EntryMode2Enum(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }

        public static EntryMode2Enum fromValue(String text)
        {
            for (EntryMode2Enum b : EntryMode2Enum.values())
            {
                if (String.valueOf(b.value).equals(text))
                {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<EntryMode2Enum>
        {
            @Override
            public void write(final JsonWriter jsonWriter, final EntryMode2Enum enumeration) throws IOException
            {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public EntryMode2Enum read(final JsonReader jsonReader) throws IOException
            {
                String value = jsonReader.nextString();
                return EntryMode2Enum.fromValue(String.valueOf(value));
            }
        }
    }

    public Pinpad mit(MitEnum mit)
    {
        this.mit = mit;
        return this;
    }

    /**
     * The Cardholder Identification Method' Sort order:   * '0' - Unknown   * '1' - PIN   * '2' - Signed
     *
     * @return mit
     **/
    @ApiModelProperty(example = "1", value = "'The Cardholder Identification Method' Sort order:   * '0' - Unknown   * '1' - Signed   * '2' - Pin ")

    public MitEnum getMit()
    {
        return mit;
    }

    public void setMit(MitEnum mit)
    {
        this.mit = mit;
    }


    @SerializedName("entry_mode_2")
    private EntryMode2Enum entryMode2 = null;

    @SerializedName("card_sequence")
    private Integer cardSequence = null;

    /**
     * Type of reader Sort order:   * &#39;0&#39; - Unknown   * &#39;1&#39; - No terminal   * &#39;2&#39; - Magnetic stripe   * &#39;3&#39; - Bar code   * &#39;4&#39; - OCR   * &#39;5&#39; - Magnetic stripe and EMV compatible chi reader   * &#39;6&#39; - Hand enteread   * &#39;7&#39; - MAgnetic stripe and hand-entered   * &#39;8&#39; - Magnetic stripe, hand-entered and EMV compatible chip reader   * &#39;9&#39; - EMV compatible chip reader
     */
    @JsonAdapter(TerminalCapabilityEnum.Adapter.class)
    public enum TerminalCapabilityEnum
    {
        _0("0"),

        _1("1"),

        _2("2"),

        _3("3"),

        _4("4"),

        _5("5"),

        _6("6"),

        _7("7"),

        _8("8"),

        _9("9");

        private String value;

        TerminalCapabilityEnum(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }

        public static TerminalCapabilityEnum fromValue(String text)
        {
            for (TerminalCapabilityEnum b : TerminalCapabilityEnum.values())
            {
                if (String.valueOf(b.value).equals(text))
                {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TerminalCapabilityEnum>
        {
            @Override
            public void write(final JsonWriter jsonWriter, final TerminalCapabilityEnum enumeration) throws IOException
            {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TerminalCapabilityEnum read(final JsonReader jsonReader) throws IOException
            {
                String value = jsonReader.nextString();
                return TerminalCapabilityEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("terminal_capability")
    private TerminalCapabilityEnum terminalCapability = null;

    @SerializedName("token_Q1")
    private String tokenQ1 = null;

    @SerializedName("token_Q2")
    private String tokenQ2 = null;

    public Pinpad entryMode1(EntryMode1Enum entryMode1)
    {
        this.entryMode1 = entryMode1;
        return this;
    }

    /**
     * &#39;The mode the start in the pinpad&#39; Sort order:   * &#39;00&#39; - Unknown   * &#39;01&#39; - Hand-entered   * &#39;02&#39; - Magnetic stripe   * &#39;03&#39; - Bar code read   * &#39;05&#39; - Chip read, CVV reliable   * &#39;80&#39; - Fall back   * &#39;90&#39; - Magnetic stripe   * &#39;95&#39; - Chip read, CVV not reliable
     *
     * @return entryMode1
     **/
    @ApiModelProperty(example = "05", required = true, value = "'The mode the start in the pinpad' Sort order:   * '00' - Unknown   * '01' - Hand-entered   * '02' - Magnetic stripe   * '03' - Bar code read   * '05' - Chip read, CVV reliable   * '80' - Fall back   * '90' - Magnetic stripe   * '95' - Chip read, CVV not reliable ")
    public EntryMode1Enum getEntryMode1()
    {
        return entryMode1;
    }

    public void setEntryMode1(EntryMode1Enum entryMode1)
    {
        this.entryMode1 = entryMode1;
    }

    public Pinpad entryMode2(EntryMode2Enum entryMode2)
    {
        this.entryMode2 = entryMode2;
        return this;
    }

    /**
     * Sort order:   * &#39;0&#39; - Unknown   * &#39;1&#39; - Can accept PIN&#39;s   * &#39;2&#39; - Can´t accept PIN&#39;s   * &#39;8&#39; - PIN pad out of service
     *
     * @return entryMode2
     **/
    @ApiModelProperty(example = "1", required = true, value = "Sort order:   * '0' - Unknown   * '1' - Can accept PIN's   * '2' - Can´t accept PIN's   * '8' - PIN pad out of service ")
    public EntryMode2Enum getEntryMode2()
    {
        return entryMode2;
    }

    public void setEntryMode2(EntryMode2Enum entryMode2)
    {
        this.entryMode2 = entryMode2;
    }

    public Pinpad cardSequence(Integer cardSequence)
    {
        this.cardSequence = cardSequence;
        return this;
    }

    /**
     * Get cardSequence
     *
     * @return cardSequence
     **/
    @ApiModelProperty(example = "432", value = "")
    public Integer getCardSequence()
    {
        return cardSequence;
    }

    public void setCardSequence(Integer cardSequence)
    {
        this.cardSequence = cardSequence;
    }

    public Pinpad terminalCapability(TerminalCapabilityEnum terminalCapability)
    {
        this.terminalCapability = terminalCapability;
        return this;
    }

    /**
     * Type of reader Sort order:   * &#39;0&#39; - Unknown   * &#39;1&#39; - No terminal   * &#39;2&#39; - Magnetic stripe   * &#39;3&#39; - Bar code   * &#39;4&#39; - OCR   * &#39;5&#39; - Magnetic stripe and EMV compatible chi reader   * &#39;6&#39; - Hand enteread   * &#39;7&#39; - MAgnetic stripe and hand-entered   * &#39;8&#39; - Magnetic stripe, hand-entered and EMV compatible chip reader   * &#39;9&#39; - EMV compatible chip reader
     *
     * @return terminalCapability
     **/
    @ApiModelProperty(example = "8", required = true, value = "Type of reader Sort order:   * '0' - Unknown   * '1' - No terminal   * '2' - Magnetic stripe   * '3' - Bar code   * '4' - OCR   * '5' - Magnetic stripe and EMV compatible chi reader   * '6' - Hand enteread   * '7' - MAgnetic stripe and hand-entered   * '8' - Magnetic stripe, hand-entered and EMV compatible chip reader   * '9' - EMV compatible chip reader    ")
    public TerminalCapabilityEnum getTerminalCapability()
    {
        return terminalCapability;
    }

    public void setTerminalCapability(TerminalCapabilityEnum terminalCapability)
    {
        this.terminalCapability = terminalCapability;
    }

    public Pinpad tokenQ1(String tokenQ1)
    {
        this.tokenQ1 = tokenQ1;
        return this;
    }

    /**
     * Authorization mode identifier
     *
     * @return tokenQ1
     **/
    @ApiModelProperty(example = "! Q100002 9 ", value = "Authorization mode identifier")
    public String getTokenQ1()
    {
        return tokenQ1;
    }

    public void setTokenQ1(String tokenQ1)
    {
        this.tokenQ1 = tokenQ1;
    }

    public Pinpad tokenQ2(String tokenQ2)
    {
        this.tokenQ2 = tokenQ2;
        return this;
    }

    /**
     * Access mode identifier
     *
     * @return tokenQ2
     **/
    @ApiModelProperty(example = "! Q200002 04", value = "Access mode identifier")
    public String getTokenQ2()
    {
        return tokenQ2;
    }

    public void setTokenQ2(String tokenQ2)
    {
        this.tokenQ2 = tokenQ2;
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
        Pinpad pinpad = (Pinpad) o;
        return Objects.equals(this.entryMode1, pinpad.entryMode1) && Objects.equals(this.entryMode2, pinpad.entryMode2) && Objects.equals(this.mit, pinpad.mit) && Objects.equals(this.cardSequence, pinpad.cardSequence) && Objects.equals(this.terminalCapability, pinpad.terminalCapability) && Objects.equals(this.tokenQ1, pinpad.tokenQ1) && Objects.equals(this.tokenQ2, pinpad.tokenQ2);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(entryMode1, entryMode2, mit, cardSequence, terminalCapability, tokenQ1, tokenQ2);
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Pinpad {\n");

        sb.append("    entryMode1: ").append(toIndentedString(entryMode1)).append("\n");
        sb.append("    entryMode2: ").append(toIndentedString(entryMode2)).append("\n");
        sb.append("    mit: ").append(toIndentedString(mit)).append("\n");
        sb.append("    cardSequence: ").append(toIndentedString(cardSequence)).append("\n");
        sb.append("    terminalCapability: ").append(toIndentedString(terminalCapability)).append("\n");
        sb.append("    tokenQ1: ").append(toIndentedString(tokenQ1)).append("\n");
        sb.append("    tokenQ2: ").append(toIndentedString(tokenQ2)).append("\n");
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

