/*
Use the REST API to get information
Source: https://www.midori-global.com/products/better-excel-exporter-for-jira/server/documentation/recipes
*/

import groovy.json.JsonSlurper
import org.apache.commons.io.IOUtils

// your Jira server
def user = "admin"
def password = "admin"
def urlConnection = new URL("http://jira.acme.com/rest/api/2/issue/DEMO-1").openConnection()
urlConnection.setRequestProperty("Authorization", "Basic " + (user + ":" + password).bytes.encodeBase64().toString())
def jsonString = IOUtils.toString(urlConnection.inputStream)

issueRest = new JsonSlurper().parseText(jsonString)

// Use for accessing external REST APIs
def jsonSlurper = new JsonSlurper()
dataRest = jsonSlurper.parseText(new URL("http://services.groupkt.com/country/get/iso2code/US").text)
