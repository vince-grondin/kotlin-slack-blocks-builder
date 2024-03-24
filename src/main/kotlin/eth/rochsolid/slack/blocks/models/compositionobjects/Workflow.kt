package eth.rochsolid.slack.blocks.models.compositionobjects

/**
 * Defines an object containing workflow information.
 *
 * Example:
 * ```json
 * {
 *   "trigger": {
 *       "url": "https://slack.com/shortcuts/Ft0123ABC456/321...zyx",
 *       "customizable_input_parameters": [
 *         {
 *           "name": "input_parameter_a",
 *           "value": "Value for input param A"
 *         },
 *         {
 *           "name": "input_parameter_b",
 *           "value": "Value for input param B"
 *         }
 *       ]
 *   }
 * }
 * ```
 */
data class Workflow(
    /**
     * A [Trigger] trigger object that contains information about a workflow's trigger.
     */
    val trigger: Trigger
)
