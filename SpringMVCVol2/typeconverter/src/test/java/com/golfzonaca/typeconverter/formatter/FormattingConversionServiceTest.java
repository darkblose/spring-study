package com.golfzonaca.typeconverter.formatter;

import com.golfzonaca.typeconverter.converter.IpPortToStringConverter;
import com.golfzonaca.typeconverter.converter.StringToIpPortConverter;
import com.golfzonaca.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        //컨버터 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        //포맷터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        //컨버터 사용
        IpPort ipPort = conversionService.convert("localhost:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("localhost", 8080));
        //포맷터 사용
        assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
        assertThat(conversionService.convert("1,000", Integer.class)).isEqualTo(1000L);
    }
}
