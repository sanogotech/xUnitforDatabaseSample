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
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.context.jdbc.SqlMergeMode.MergeMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SqlMergeMode(MergeMode.MERGE)
@Sql({ "/drop_schema.sql", "/create_schema.sql", "/insert_data1.sql" })
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class SqlMergeModeTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Sql(statements = "insert into student(id, name) values (100, 'Shiva')")	
	@Test
	public void fetchRows1() {
		List<Map<String, Object>> students = jdbcTemplate.queryForList("SELECT * FROM student");
		assertEquals(3, students.size());
	}

	@SqlMergeMode(MergeMode.OVERRIDE)	
	@Sql("/insert_more_data1.sql")
	@Test
	public void fetchRows2() {
		List<Map<String, Object>> students = jdbcTemplate.queryForList("SELECT * FROM student");
		assertEquals(5, students.size());
	}
}
