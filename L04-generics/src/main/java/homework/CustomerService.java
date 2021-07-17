package homework;


import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    TreeMap<Customer, String> customerStringTreeMap = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> newMapEntry = customerStringTreeMap.firstEntry();
        return new AbstractMap.SimpleEntry<>( new Customer(newMapEntry.getKey()),newMapEntry.getValue());
        // return null; // это "заглушка, чтобы скомилировать"
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return customerStringTreeMap.higherEntry(customer);
        // return null; // это "заглушка, чтобы скомилировать"
    }

    public void add(Customer customer, String data) {
        customerStringTreeMap.put(customer, data);
    }
}
