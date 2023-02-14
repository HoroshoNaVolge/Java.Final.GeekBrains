import java.util.List;
import java.util.ArrayList;

public class Notebook {

    private String _name;

    private int _RAM;
    private String _opSystem;
    private String _model;
    private int _price;

    public Notebook(String name, int RAM, String opSystem, int price, String model) {
        this._name = name;
        this._RAM = RAM;
        this._opSystem = opSystem;
        this._model = model;
        this._price = price;
    }

    public Notebook(String name) {
        this._name = name;

    }

    public Notebook(String name, int digit, String filterString) {
        this._name = name;

        switch (filterString) {
            case "RAM":
                _RAM = digit;
            case "price":
                _price = digit;
        }
    }

    public Notebook(String name, String value, String filterString) {
        this._name = name;

        switch (filterString) {
            case "op":
                _opSystem = value;
            case "model":
                _model = value;
        }
    }

    public String filteredToString() {
        if (_RAM != 0) {
            return "|" + _name + "| " +
                    "|" + _RAM + " gb| ";
        }

        else if (_opSystem != null) {
            return "|" + _name + "| " +
                    "|" + _opSystem + "| ";
        }

        if (_model != null) {
            return "|" + _name + "| " +
                    "|" + _model + "| ";
        }

        if (_price != 0) {
            return "|" + _name + "| " +
                    "|" + _price + " rub| ";
        }
        return _name;
    }

    @Override
    public String toString() {

        return "|" + _name + "| " +
                "|" + _RAM + " gb| " +
                "|" + _opSystem + "| " +
                "|" + _model + "| " +
                "|" + _price + " rub| ";
    }

    public static List<String> getFilterProps() {
        List<String> list = new ArrayList<>();
        list.add("RAM");
        list.add("opSystem");
        list.add("model");
        list.add("price");

        return list;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getRAM() {
        return _RAM;
    }

    public void setRAM(int RAM) {
        this._RAM = RAM;
    }

    public String getOpSystem() {
        return _opSystem;
    }

    public void setOpSystem(String opSystem) {
        _opSystem = opSystem;
    }

    public String getModel() {
        return _model;
    }

    public void setModel(String model) {
        _model = model;
    }

    public int getPrice() {
        return _price;
    }

    public void setPrice(int price) {
        _price = price;
    }

}
