To make 'zebra stripes'  

Define the color scheme in the first Excel cell:  
`Summary<mt:class name="odd" style="fill-pattern: solid; fill-foreground-color: gray;"/><mt:class name="even" style="fill-pattern: solid; fill-foreground-color: white;"/>`

Then determine if the color should be displayed on even or odd lines:

`<jt:forEach items="${issues}" var="issue" indexVar="rowIndex"><jt:style class="${rowIndex % 2 ? 'odd' : 'even'}">${issue.summary}</jt:style></jt:forEach>`  
