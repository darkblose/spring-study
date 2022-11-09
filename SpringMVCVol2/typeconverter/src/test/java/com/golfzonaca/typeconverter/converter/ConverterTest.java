package com.golfzonaca.typeconverter.converter;

import com.golfzonaca.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    @Test
    void stringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void integerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIp() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = new IpPort("localhost", 8080);
        String result = converter.convert(source);
        assertThat(result).isEqualTo("localhost:8080");
    }

    @Test
    void ipToString() {
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "localhost:8080";
        IpPort result = converter.convert(source);
        assertThat(result).isEqualTo(new IpPort("localhost", 8080));
    }
}
