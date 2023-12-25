public class BusinessAddress implements Address{

    private String title;
    private String countryName;
    private String cityName;
    private String districtName;
    private String address;
    private String companyName;
    private int taxNumber;

    public BusinessAddress(String title, String countryName, String cityName, String districtName, String address, String companyName, int taxNumber) {
        this.title = title;
        this.countryName = countryName;
        this.cityName = cityName;
        this.districtName = districtName;
        this.address = address;
        this.companyName = companyName;
        this.taxNumber = taxNumber;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }
}
