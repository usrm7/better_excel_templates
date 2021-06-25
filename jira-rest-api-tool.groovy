/**
 * Use the REST API to get information
 * Source: https://www.midori-global.com/products/better-excel-exporter-for-jira/server/documentation/recipes
 * Steps:
 * 1) Execute in template: <mt:execute script="jira-rest-api-tool.groovy"/>
 * 2) Use the issueRest object to access the returned issue's fields in the template:
 *    ${issueRest.key}
 *    ${issueRest.fields.summary}
 *    ${issueRest.fields.status.name}
 **/

import groovy.json.JsonSlurper
import org.apache.commons.io.IOUtils

def user = "admin"
def password = "admin"
def urlConnection = new URL("http://jira.acme.com/rest/api/2/issue/DEMO-1").openConnection()
urlConnection.setRequestProperty("Authorization", "Basic " + (user + ":" + password).bytes.encodeBase64().toString())
def jsonString = IOUtils.toString(urlConnection.inputStream)

issueRest = new JsonSlurper().parseText(jsonString)