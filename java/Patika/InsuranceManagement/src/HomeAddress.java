public class HomeAddress implements Address{

    private String title;
    private String countryName;
    private String cityName;
    private String districtName;
    private String address;

    public HomeAddress(String title, String countryName, String cityName, String districtName, String address) {
        this.title = title;
        this.countryName = countryName;
        this.cityName = cityName;
        this.districtName = districtName;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
