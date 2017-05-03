package pl.edu.agh.soa.lab7.zad2;

import javax.ejb.Local;
import java.util.List;

@Local
public interface FirmService {

    void save(String firm);

    List<String> findAll();

}
