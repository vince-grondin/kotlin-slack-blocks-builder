package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.compositionobjects.ConfirmationDialog
import eth.rochsolid.slack.blocks.models.compositionobjects.Option
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import kotlinx.serialization.SerialName

/**
 * This multi-select menu will populate its options with a list of public channels visible to the current user in the
 * active workspace.
 *
 * Example:
 * ```json
 * [
 *   {
 *     "type": "section",
 *     "block_id": "section678",
 *     "text": {
 *       "type": "mrkdwn",
 *       "text": "Pick channels from the list"
 *     },
 *     "accessory": {
 *       "action_id": "text1234",
 *       "type": "multi_channels_select",
 *       "placeholder": {
 *         "type": "plain_text",
 *         "text": "Select channels"
 *       }
 *     }
 *   }
 * ]
 * ```
 */
data class MultiChannelsSelect(
    /**
     * An identifier for this action.
     * You can use this when you receive an interaction payload to identify the source of the action.
     * Should be unique among all other `action_id`s in the containing block.
     * Maximum length is 255 characters.
     */
    @SerialName("action_id")
    override val actionID: ActionID?,
    /**
     * An array of one or more IDs of any valid public channel to be pre-selected when the menu loads.
     */
    @SerialName("initial_channels")
    val initialChannels: List<String>?,
    /**
     * A [ConfirmationDialog] object that defines an optional confirmation dialog that appears
     * after clicking one of the checkboxes in this element.
     */
    override val confirm: ConfirmationDialog?,
    /**
     * Specifies the maximum number of items that can be selected in the menu.
     * Minimum number is 1.
     */
    @SerialName("max_selected_items")
    override val maxSelectedItems: Int?,
    /**
     * Indicates whether the element will be set to autofocus within
     * the [view object](https://api.slack.com/reference/surfaces/views).
     * Only one element can be set to `true`. Defaults to `false`.
     */
    @SerialName("focus_on_load")
    override val focusOnLoad: Boolean? = false,
    /**
     * Defines the placeholder text shown on the date picker.
     * Maximum length for the `text` in this field is 150 characters.
     */
    override val placeholder: Text.PlainText?
) : ActionableElement(type = Type.MULTI_CHANNELS_SELECT), MultiSelect
