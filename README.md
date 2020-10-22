# xUnitforDatabaseSample


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





