package classWork.rest;

import java.util.List;
import java.util.Objects;

public class Data {

    public String code;
    public List<User> data;

    public Data(String code, List<User> data) {
        this.code = code;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data1 = (Data) o;
        return Objects.equals(code, data1.code) && Objects.equals(data, data1.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, data);
    }

    @Override
    public String toString() {
        return "Data{" +
                "code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
