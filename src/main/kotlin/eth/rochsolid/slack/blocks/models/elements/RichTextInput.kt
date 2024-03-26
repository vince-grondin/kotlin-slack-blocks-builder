package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.blocks.RichText
import eth.rochsolid.slack.blocks.models.compositionobjects.DispatchActionConfiguration
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import kotlinx.serialization.SerialName


/**
 * Allows users to enter formatted text in a WYSIWYG composer, offering the same messaging writing experience as in Slack.
 * Interactive component - see the [guide to enabling interactivity](https://api.slack.com/interactivity/handling).
 *
 * Example:
 * - An input block containing a rich text input element.
 * ```json
 * {
 *   "type": "rich_text_input",
 *   "action_id": "rich_text_input-action",
 *   "dispatch_action_config": {
 *     "trigger_actions_on": [
 *       "on_character_entered"
 *     ]
 *   },
 *   "focus_on_load": true,
 *   "placeholder": {
 *     "type": "plain_text",
 *     "text": "Enter text"
 *   }
 * }
 * ```
 */
data class RichTextInput(
    /**
     * An identifier for this action.
     * You can use this when you receive an interaction payload to identify the source of the action.
     * Should be unique among all other `action_id`s in the containing block.
     * Maximum length is 255 characters.
     */
    @SerialName("action_id")
    val actionId: ActionID?,
    /**
     * A dispatch configuration object that determines when during text input the element returns a
     * [`block_actions` payload](https://api.slack.com/reference/interaction-payloads/block-actions).
     */
    @SerialName("dispatch_action_config")
    val dispatchActionConfig: DispatchActionConfiguration?,
    /**
     * The initial value in the rich text input when it is loaded.
     */
    @SerialName("initial_value")
    val initialValue: RichText?,
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
    val placeholder: Text.PlainText?
) : Element(type = Type.RICH_TEXT_INPUT)
