package com.concretepage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SqlConfig(commentPrefix = "#")
@Sql({ "/drop_schema.sql", "/create_schema.sql" })
@Sql(scripts = { "/insert_data2.sql" })
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class SqlConfigTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void fetchRows1() {
		List<Map<String, Object>> students = jdbcTemplate.queryForList("SELECT * FROM student");
		assertEquals(2, students.size());
	}

	@Sql(scripts = "/insert_more_data2.sql", config= @SqlConfig(commentPrefix = "~"))
	@Test
	public void fetchRows2() {
		List<Map<String, Object>> students = jdbcTemplate.queryForList("SELECT * FROM student");
		assertEquals(4, students.size());
	}
}
