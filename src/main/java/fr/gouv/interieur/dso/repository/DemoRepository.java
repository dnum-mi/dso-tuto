package fr.gouv.interieur.dso.repository;

import fr.gouv.interieur.dso.models.Demo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DemoRepository {
    public List<Demo> getAll();

    public Integer insert(Demo demo);
}
