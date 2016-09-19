import java.util.Map;

public class ProductSpec {
    private Map properties;

    public ProductSpec(){}

    public Map getProperties() {
        return properties;
    }

    public void setProperties(Map properties) {
        this.properties = properties;
    }

    public Object getProperty(String key){
        return this.properties.get(key);
    }
}
