package io.github.alphahinex.demo.seata.at.storage;

import groovy.json.JsonOutput;
import io.github.alphahinex.demo.seata.at.storage.vo.CommodityVO;
import io.github.springroll.test.AbstractSpringTest;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@Sql
@Transactional
class StorageApplicationTest extends AbstractSpringTest {

	@Test
	void contextLoads() {
		String code = "test";
		get("/at/storage/" + code, HttpStatus.OK);

		CommodityVO vo = new CommodityVO();
		vo.setCount(2);
		vo.setCommodityCode(code);
		put("/at/storage/decrease", JsonOutput.toJson(vo), HttpStatus.OK);

		get("/at/storage/" + code, HttpStatus.OK);
	}

}
