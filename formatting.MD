# Excel Report Format

<h4> How do I get the report going? </h4>

As an example, put this in the top of your report, generally the first row, first cell for any scripts that must be executed for the report.  
`<mt:execute script="jql-search-tool.groovy"/>`  
The script must include the closing tag.

<h4>I want a dynamic worksheet name</h4>  

Put this type of tag as the worksheet name:  
`${issues.size()} issues`

<h4>I want my issues to be hyperlinked in the Excel report</h4>

Hyperlinked by the Issue Key:  
`<jt:hyperlink type="url" address="${requestContext.canonicalBaseUrl}/browse/${issue.key}" value="${issue.key}"/>` 

Hyperlinked by some other field (example, issue summary):  
`<jt:hyperlink type="url" address="${requestContext.canonicalBaseUrl}/browse/${issue.key}" value="${issue.summary}"/>`

