package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.compositionobjects.ConfirmationDialog
import eth.rochsolid.slack.blocks.models.compositionobjects.Option
import kotlinx.serialization.SerialName

/**
 * Allows users to choose multiple items from a list of options.
 *
 * Interactive component - see the [guide to enabling interactivity](https://api.slack.com/interactivity/handling).
 *
 * Examples:
 * - A section block containing a group of checkboxes:
 * ```json
 * {
 * 	"type": "modal",
 * 	"title": {
 * 		"type": "plain_text",
 * 		"text": "My App",
 * 		"emoji": true
 * 	},
 * 	"submit": {
 * 		"type": "plain_text",
 * 		"text": "Submit",
 * 		"emoji": true
 * 	},
 * 	"close": {
 * 		"type": "plain_text",
 * 		"text": "Cancel",
 * 		"emoji": true
 * 	},
 * 	"blocks": [
 * 		{
 * 			"type": "section",
 * 			"text": {
 * 				"type": "plain_text",
 * 				"text": "Check out these charming checkboxes"
 * 			},
 * 			"accessory": {
 * 				"type": "checkboxes",
 * 				"action_id": "this_is_an_action_id",
 * 				"initial_options": [{
 * 					"value": "A1",
 * 					"text": {
 * 						"type": "plain_text",
 * 						"text": "Checkbox 1"
 * 					}
 * 				}],
 * 				"options": [
 * 					{
 * 						"value": "A1",
 * 						"text": {
 * 							"type": "plain_text",
 * 							"text": "Checkbox 1"
 * 						}
 * 					},
 * 					{
 * 						"value": "A2",
 * 						"text": {
 * 							"type": "plain_text",
 * 							"text": "Checkbox 2"
 * 						}
 * 					}
 * 				]
 * 			}
 * 		}
 * 	]
 * }
 * ```
 */
data class Checkboxes(
    /**
     * An identifier for the action triggered when the checkbox group is changed.
     * You can use this when you receive an interaction payload to
     * [identify the source of the action](https://api.slack.com/interactivity/handling#payloads).
     * Should be unique among all other action_ids in the containing block.
     * Maximum length is 255 characters.
     */
    @SerialName("action_id")
    override val actionID: ActionID?,
    /**
     * A list of [Option] option objects. A maximum of 10 options are allowed.
     */
    val options: List<Option>,
    /**
     * A list of [Option] option objects that exactly matches one or more of the options within options.
     * These options will be selected when the checkbox group initially loads.
     */
    @SerialName("initial_options")
    val initialOptions: List<Option>?,
    /**
     * A [ConfirmationDialog] object that defines an optional confirmation dialog that appears
     * after clicking one of the checkboxes in this element.
     */
    val confirm: ConfirmationDialog?,
    /**
     * Indicates whether the element will be set to autofocus within
     * the [view object](https://api.slack.com/reference/surfaces/views).
     * Only one element can be set to `true`. Defaults to `false`.
     */
    @SerialName("focus_on_load")
    val focusOnLoad: Boolean? = false
) : Element(type = Type.CHECKBOXES)
