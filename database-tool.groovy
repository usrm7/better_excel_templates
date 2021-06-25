/**
 * Use to return data from Jira or external databases
 * Source: https://www.midori-global.com/products/better-excel-exporter-for-jira/server/documentation/recipes
 * Steps:
 * 1) Execute in template: <mt:execute script="database-tool.groovy"/>
 * 2) Call the database.executeSql method, iterate over the result, and access database column values
 *    via properties with the same name. For example, query the Jira user accounts directly from the database:
 *    | <jt:forEach items="${database.executeSql('com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/jiradb', 'root', '', 'SELECT * FROM cwd_user')}" var="row">${row.display_name} | ${row.user_name}</jt:forEach> |
 **/

import com.atlassian.jira.component.ComponentAccessor
import groovy.sql.Sql
import org.apache.log4j.Logger

database = new DatabaseTool()

class DatabaseTool {
    def log = Logger.getLogger(this.getClass())

    def executeSql(def jdbcDriverClassName, def url, def user, def password, def sqlQuery) {
        def result

        def sql
        def conn

        try {
            // assumes that the JDBC driver is available on the classpath
            def jdbcDriverClazz = ComponentAccessor.class.classLoader.loadClass(jdbcDriverClassName)
            log.debug("JDBC driver class: " + jdbcDriverClazz.canonicalName)

            def jdbcDriver = jdbcDriverClazz.newInstance()
            log.debug("JDBC driver: " + jdbcDriver)

            def props = new Properties()
            props.put("user", user)
            props.put("password", password)

            conn = jdbcDriver.connect(url, props)
            sql = Sql.newInstance(conn)
            result = sql.rows(sqlQuery)
            log.debug("Results found: " + result.size())
        } catch (Exception ex) {
            log.error("Failed to execute SQL", ex)
        } finally {
            sql.close()
            conn.close()
        }

        return result
    }
}
