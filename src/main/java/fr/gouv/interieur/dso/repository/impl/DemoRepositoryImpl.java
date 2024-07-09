package fr.gouv.interieur.dso.repository.impl;

import fr.gouv.interieur.dso.models.Demo;
import fr.gouv.interieur.dso.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DemoRepositoryImpl  implements DemoRepository {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Demo> getAll() {
        String query = "select id, name from demo;";
        List<Demo> demoList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        rows.forEach(map -> {
            Demo demo = new Demo();
            demo.setId(Integer.parseInt(String.valueOf(map.get(("id")))));
            demo.setName(String.valueOf(map.get("name")));
            demoList.add(demo);
        });
        return demoList;
    }

    @Override
    public Integer insert(Demo demo) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `demo` (`name`) VALUES (?);";
        int rowsAffected = jdbcTemplate.update(conn -> {
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, demo.getName());
            return  preparedStatement;
        }, generatedKeyHolder);
        // Get auto-incremented ID
        Integer id = generatedKeyHolder.getKey().intValue();
        return id;
    }
}
