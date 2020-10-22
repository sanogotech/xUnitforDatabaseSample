# xUnitforDatabaseSample

## Docs
- https://www.sqlshack.com/sql-unit-testing-best-practices/
- https://the.agilesql.club/2016/04/sqlcover-code-coverage-for-sql-server-t-sql/
- https://solutioncenter.apexsql.com/how-to-create-and-run-sql-server-database-unit-tests-automatically/
- https://www.apexsql.com/sql-tools-unit-test.aspx?utm_source=sqlshack&utm_campaign=unit-test&utm_medium=native_link&utm_content=sql-shack



## sql-test-spring-app : @Sql Example in Spring Test

- https://www.concretepage.com/spring-5/sql-example-spring-test
- https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/testing.html#testcontext-executing-sql-declaratively

This page will walk through using Spring @Sql annotations **in integration test classes**. 
We will also go through using @SqlConfig, @SqlMergeMode and @SqlGroup annotations with @Sql annotation in integration test classes.

```
@Sql({ "/drop_schema.sql", "/create_schema.sql" })
@Sql("/insert_data.sql")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class SqlTest {
    ------
} 
```

## Reverse Database --- ORM
- https://stackoverflow.com/questions/37391498/how-to-reverse-engineer-a-database-and-generate-code-using-spring-boot-and-jooq


