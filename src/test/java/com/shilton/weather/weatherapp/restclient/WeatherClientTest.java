package com.shilton.weather.weatherapp.restclient;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.shilton.weather.weatherapp.models.CurrentForecast;
import com.shilton.weather.weatherapp.models.DailyForecast;
import com.shilton.weather.weatherapp.models.HourlyForecast;
import com.shilton.weather.weatherapp.models.WeatherForecastSummary;
import com.shilton.weather.weatherapp.test.TestingUtilities;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.lanwen.wiremock.ext.WiremockResolver;
import ru.lanwen.wiremock.ext.WiremockUriResolver;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(JUnitPlatform.class)
@SpringBootTest
@ExtendWith({
        SpringExtension.class,
        WiremockResolver.class,
        WiremockUriResolver.class
})
public class WeatherClientTest {

    private final static String COMMON_ROOT_URI = "/com/shilton/weather/weatherapp/restclient/";


    @BeforeAll
    public static void setup() {
        System.out.println(WeatherClientTest.class.getName() + "Test Start...");
    }

    @Test
    @Tag("fast")
    @DisplayName("\uD83D\uDE02 Test Current Weather Forecast Call")
    public void testGetCurrentWeatherForecast(@WiremockResolver.Wiremock WireMockServer server, @WiremockUriResolver.WiremockUri String uri) throws Exception {
        String filename = "testGetCurrentWeatherForecast.json";
        String content = TestingUtilities.readFile(COMMON_ROOT_URI + filename);

        setMockRequestListener(server,"/data/2.5/weather?id=1007311&units=metric&appid="+WeatherClient.API_KEY, content);

        WeatherClient weatherClient = getWeatherClient(uri);
        CurrentForecast weatherForecast = weatherClient.getCurrentWeatherForecast("1007311");
        assertNotNull(weatherForecast);
    }

    @Test
    @DisplayName("Test Weather Forecast Summary Call")
    public void testGetWeatherForecastSummary(@WiremockResolver.Wiremock WireMockServer server, @WiremockUriResolver.WiremockUri String uri) throws Exception {
        String filename = "testGetWeatherForecastSummary.json";
        String content = TestingUtilities.readFile(COMMON_ROOT_URI + filename);
        setMockRequestListener(server,"/data/2.5/group?id=1007311&units=metric&appid="+WeatherClient.API_KEY, content);

        WeatherClient weatherClient = getWeatherClient(uri);
        WeatherForecastSummary weatherForecast = weatherClient.getWeatherForecastSummary("1007311");
        assertNotNull(weatherForecast);
    }

    @Test
    @DisplayName("Test Hourly Weather Forecast Call")
    public void testGetHourlyWeatherForecastCity(@WiremockResolver.Wiremock WireMockServer server, @WiremockUriResolver.WiremockUri String uri) throws Exception {
        String filename = "testGetHourlyWeatherForecastCity.json";
        String content = TestingUtilities.readFile(COMMON_ROOT_URI + filename);
        setMockRequestListener(server,"/data/2.5/forecast?id=1007311&units=metric&appid="+WeatherClient.API_KEY, content);

        WeatherClient weatherClient = getWeatherClient(uri);
        HourlyForecast weatherForecast = weatherClient.getHourlyWeatherForecastCity("1007311");
        assertNotNull(weatherForecast);
    }

    @Test
    @DisplayName("Test Daily Weather Forecast Call")
    public void testGetDailyWeatherForecastCity(@WiremockResolver.Wiremock WireMockServer server, @WiremockUriResolver.WiremockUri String uri) throws Exception {
        String filename = "testGetDailyWeatherForecastCity.json";
        String content = TestingUtilities.readFile(COMMON_ROOT_URI + filename);
        setMockRequestListener(server,"/data/2.5/forecast/daily?id=1007311&units=metric&appid="+WeatherClient.API_KEY, content);

        WeatherClient weatherClient = getWeatherClient(uri);
        DailyForecast weatherForecast = weatherClient.getDailyWeatherForecastCity("1007311");
        assertNotNull(weatherForecast);
    }

    @AfterAll
    public static void destroy() {
        System.out.println(WeatherClientTest.class.getName() + "Test End!!");
    }

    private void setMockRequestListener(WireMockServer server, String testUrl, String body) {
        server.stubFor(get(urlEqualTo(testUrl)).willReturn(aResponse()
                .withStatus(200)
                .withBody(body)));
    }

    private WeatherClient getWeatherClient(String uri) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(WeatherClient.class, uri);
    }
}
