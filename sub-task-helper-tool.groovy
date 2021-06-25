/**
 * Get subtasks and issues
 * Source: https://www.midori-global.com/products/better-excel-exporter-for-jira/server/documentation/recipes
 **/

subTaskHelper = new SubTaskHelperTool()

public class SubTaskHelperTool {
    /**
     * Returns the passed issues merged with their sub-tasks.
     */
    public getIssuesAndSubtasks(issues) {
        def issuesAndSubtasks = []
        for (issue in issues) {
            issuesAndSubtasks.add(issue)
            for (subTask in issue.subTaskObjects) {
                issuesAndSubtasks.add(subTask)
            }
        }
        return issuesAndSubtasks
    }
}
