I want a dynamic worksheet name.  

Put this tag as the worksheet name:  
`${issues.size()} issues`

I want my issues to be hyperlinked in the Excel report:

Hyperlinked by the Issue Key:  
`<jt:hyperlink type="url" address="${requestContext.canonicalBaseUrl}/browse/${issue.key}" value="${issue.key}"/>` 

Hyperlinked by some other field (example: Issue Summary):  
`<jt:hyperlink type="url" address="${requestContext.canonicalBaseUrl}/browse/${issue.key}" value="${issue.summary}"/>`

