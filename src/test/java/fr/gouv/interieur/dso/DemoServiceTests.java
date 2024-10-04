package fr.gouv.interieur.dso;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.gouv.interieur.dso.models.Demo;
import fr.gouv.interieur.dso.service.jdbc.DemoService;

@SpringBootTest
class DemoServiceTests {

	@Autowired
	DemoService demoService;

	@Test
	void test() {
		List<Demo> list = demoService.getListDemo();
		Assertions.assertEquals(5, list.size());
	}

}
