/**
 * Use an external REST API to get information
 * Source: https://www.midori-global.com/products/better-excel-exporter-for-jira/server/documentation/recipes
 * Steps:
 * 1) Execute in template: <mt:execute script="external-rest-api-tool.groovy"/>
 * 2) Use the dataRest object to access the returned information in the template:
 *    ${dataRest.RestResponse.result.name}
 *    ${dataRest.RestResponse.result.alpha2_code}
 **/

import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()
dataRest = jsonSlurper.parseText(new URL("http://services.groupkt.com/country/get/iso2code/US").text)
