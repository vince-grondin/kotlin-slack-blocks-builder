package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.compositionobjects.ConfirmationDialog
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import kotlinx.serialization.SerialName
import java.util.Date

/**
 * Allows users to select a date from a calendar style UI.
 * Interactive component - see the [guide to enabling interactivity](https://api.slack.com/interactivity/handling).
 *
 * Example ([view in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%09%7B%0A%09%09%22type%22%3A%20%22section%22%2C%0A%09%09%22block_id%22%3A%20%22section1234%22%2C%0A%09%09%22text%22%3A%20%7B%0A%09%09%09%22type%22%3A%20%22mrkdwn%22%2C%0A%09%09%09%22text%22%3A%20%22Pick%20a%20date%20for%20the%20deadline.%22%0A%09%09%7D%2C%0A%09%09%22accessory%22%3A%20%7B%0A%09%09%09%22type%22%3A%20%22datepicker%22%2C%0A%09%09%09%22action_id%22%3A%20%22datepicker123%22%2C%0A%09%09%09%22initial_date%22%3A%20%221990-04-28%22%2C%0A%09%09%09%22placeholder%22%3A%20%7B%0A%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%22text%22%3A%20%22Select%20a%20date%22%0A%09%09%09%7D%0A%09%09%7D%0A%09%7D%0A%5D)):
 * ```json
 * {
 *   "type": "section",
 *   "block_id": "section1234",
 *   "text": {
 *     "type": "mrkdwn",
 *     "text": "Pick a date for the deadline."
 *   },
 *   "accessory": {
 *     "type": "datepicker",
 *     "action_id": "datepicker123",
 *     "initial_date": "1990-04-28",
 *     "placeholder": {
 *       "type": "plain_text",
 *       "text": "Select a date"
 *     }
 *   }
 * }
 * ```
 */
data class DatePicker(
    /**
     * An identifier for this action.
     * You can use this when you receive an interaction payload to identify the source of the action.
     * Should be unique among all other `action_id`s in the containing block.
     * Maximum length is 255 characters.
     */
    @SerialName("action_id")
    val actionId: ActionID?,
    /**
     * A [ConfirmationDialog] object that defines an optional confirmation dialog after the button
     * is clicked.
     */
    val confirm: ConfirmationDialog?,
    /**
     * The initial date that is selected when the element is loaded. This should be in the format `YYYY-MM-DD`.
     */
    @SerialName("initial_date")
    val initialDate: Date?,
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
) : Element(type = Type.DATE_PICKER)
