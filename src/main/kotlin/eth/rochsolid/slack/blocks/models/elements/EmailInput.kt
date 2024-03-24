package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.compositionobjects.DispatchActionConfiguration
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import kotlinx.serialization.SerialName

/**
 * Allows user to enter an email into a single-line field.
 * Interactive component - see the [guide to enabling interactivity](https://api.slack.com/interactivity/handling).
 *
 * Example:
 * ```json
 * {
 *   "type": "input",
 *   "block_id": "input123",
 *   "label": {
 *     "type": "plain_text",
 *     "text": "Email Address"
 *   },
 *   "element": {
 *     "type": "email_text_input",
 *     "action_id": "email_text_input-action",
 *     "placeholder": {
 *       "type": "plain_text",
 *       "text": "Enter an email"
 *     }
 *   }
 * }
 * ```
 */
data class EmailInput(
    /**
     * An identifier for this action.
     * You can use this when you receive an interaction payload to identify the source of the action.
     * Should be unique among all other `action_id`s in the containing block.
     * Maximum length is 255 characters.
     */
    @SerialName("action_id")
    val actionId: ActionID?,
    /**
     * A dispatch configuration object that determines when during text input the element returns a [`block_actions` payload](https://api.slack.com/reference/interaction-payloads/block-actions).
     */
    @SerialName("dispatch_action_config")
    val dispatchActionConfig: DispatchActionConfiguration?,
    /**
     * The initial value in the email input when it is loaded.
     */
    @SerialName("initial_value")
    val initialValue: String?,
    /**
     * Indicates whether the element will be set to autofocus within
     * the [view object](https://api.slack.com/reference/surfaces/views).
     * Only one element can be set to `true`. Defaults to `false`.
     */
    @SerialName("focus_on_load")
    val focusOnLoad: Boolean? = false,
    /**
     * Defines the placeholder text shown on the date picker.
     * Maximum length for the `text` in this field is 150 characters.
     */
    val placeholder: Text.PlainText
) : Element(type = Type.EMAIL_TEXT_INPUT)
