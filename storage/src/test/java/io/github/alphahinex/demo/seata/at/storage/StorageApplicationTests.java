package io.github.alphahinex.demo.seata.at.storage;

import groovy.json.JsonOutput;
import io.github.alphahinex.demo.seata.at.storage.vo.CommodityVO;
import io.github.springroll.test.AbstractSpringTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class StorageApplicationTests extends AbstractSpringTest {

	@BeforeEach
	void beforeAll() {
		setup();
	}

	@Test
	void contextLoads() {
		CommodityVO vo = new CommodityVO();
		vo.setCount(2);
		vo.setCommodityCode("test");
		put("/at/storage/decrease", JsonOutput.toJson(vo), HttpStatus.OK);
	}

}
