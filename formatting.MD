# Excel Report Format

<h4> How do I get the report going? </h4>

First, you need to state which scripts the file will use.  These need to be at the very top of the Excel workbook, before any other code is run.  Most common would probably be 'jql-search.groovy'.  
`<mt:execute script="jql-search-tool.groovy"/>`  

<h4>I want to execute a JQL search and return the issues:</h4>

Include this on the row you wish to begin the search, modifying the JQL for your specific case:  
`<jt:forEach items="${jqlSearch.searchByJql('project=FOOBAR ORDER BY summary')}" var="issue">[${issue.key}] ${issue.summary}</jt:forEach>`

<h4>I want a dynamic worksheet name:</h4>  

Put this type of tag as the worksheet name:  
`${issues.size()} issues`

<h4>I want my issues to be hyperlinked in the Excel report:</h4>

Hyperlinked by the Issue Key:  
`<jt:hyperlink type="url" address="${requestContext.canonicalBaseUrl}/browse/${issue.key}" value="${issue.key}"/>` 

Hyperlinked by some other field (example, issue summary):  
`<jt:hyperlink type="url" address="${requestContext.canonicalBaseUrl}/browse/${issue.key}" value="${issue.summary}"/>`

