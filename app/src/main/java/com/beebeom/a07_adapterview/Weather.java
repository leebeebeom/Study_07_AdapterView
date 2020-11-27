package com.beebeom.a07_adapterview;

public class Weather {
    private String city;
    private String weather;
    private String temp;

    //인스턴스를 만들고 생성자에 데이터를 넣어주면
    //그 인스턴스에 데이터가 입력됨
    public Weather(String city, String weather, String temp) {
        this.city = city;
        this.weather = weather;
        this.temp = temp;
    }

    //인스턴스의 데이터를 가져오기 위한 메소드들.
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    //log 등으로 어떤 데이터가 들어있는지 볼 수 있게.
    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", weather='" + weather + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}
