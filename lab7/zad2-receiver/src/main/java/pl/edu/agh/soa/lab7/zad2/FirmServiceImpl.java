package pl.edu.agh.soa.lab7.zad2;

import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class FirmServiceImpl implements FirmService {

    private List<String> firms = new LinkedList<>();

    @Override
    public void save(String firm) {
        firms.add(firm);
    }

    @Override
    public List<String> findAll() {
        return firms;
    }
}
