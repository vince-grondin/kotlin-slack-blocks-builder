package eth.rochsolid.slack.blocks.models.compositionobjects

import kotlinx.serialization.SerialName
import java.net.URL


/**
 * Defines an object containing trigger information.
 *
 * Example:
 * ```json
 * {
 *   "url": "https://slack.com/shortcuts/Ft0123ABC456/123...xyz",
 *   "customizable_input_parameters": [
 *     {
 *       "name": "input_parameter_a",
 *       "value": "Value for input param A"
 *     },
 *     {
 *       "name": "input_parameter_b",
 *       "value": "Value for input param B"
 *     }
 *   ]
 * }
 * ```
 */
data class Trigger(
    /**
     * An array of [InputParameter] input parameter objects.
     * Each specified name must match an input parameter defined on the workflow of the provided trigger (url),
     * and the input parameter mapping on the trigger must be set as `customizable: true`.
     * Each specified value must match the type defined by the workflow input parameter of the matching name.
     * **The values used for these [customizableInputParameters] may be visible client-side to end users.
     * You should not share sensitive information or secrets via these input parameters.**
     */
    @SerialName("customizable_input_parameters")
    val customizableInputParameters: List<InputParameter>?,
    /**
     * A [link trigger URL](https://api.slack.com/automation/triggers/link).
     * Must be associated with a valid trigger.
     */
    val url: URL
) {
    data class InputParameter(
        val name: String,
        val value: String
    )
}
